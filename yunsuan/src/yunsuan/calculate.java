package yunsuan;

public class calculate {
    String cal(String[] all) {

        int i;
        for (i = 1; i < all.length; i = i + 2)
        {

            if(all[i].equals("x")){
                all[i+1]=mul(all[i-1],all[i+1]);
                all[i]="";
                all[i-1]="";
            }
            if(all[i].equals("÷")){
                all[i+1]=chu(all[i-1],all[i+1]);
                all[i]="";
                all[i-1]="";
            }
        }


       all=replaceNull(all);
        for (i = 1; i < all.length; i = i + 2)
        {if(all[i]!=null){

            if(all[i].equals("+")){
                all[i+1]=jiajian(all[i-1],all[i+1],"+");
                all[i]="";
                all[i-1]="";
            }
            if(all[i].equals("-")){
                all[i+1]=jiajian(all[i-1],all[i+1],"-");
                all[i]="";
                all[i-1]="";
            }}
        }
        String question="";
        for (int b = 0; b < all.length; b++) {

            question = question + all[b];
        }
        String [] a=question.split("/");
        int b;
        b=Integer.parseInt(a[0]);
        question=b+"";
        return question;
    }
    private String[] replaceNull(String[] str){
        //用StringBuffer来存放数组中的非空元素，用“;”分隔
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length; i++) {
            if("".equals(str[i])) {
                continue;
            }
            sb.append(str[i]);
            if(i != str.length - 1) {
                sb.append(";");
            }
        }
        //用String的split方法分割，得到数组
        str = sb.toString().split(";");
        return str;
    }

    String zhengfenshu(String a){
        String[]c=a.split("/");
        int d=Integer.parseInt(c[0]);
        int f=Integer.parseInt(c[1]);
        if(d==0){return "0";}
        if(f==1){return c[0];}
        return a;
    }

    String mul(String a,String b){
        String t="";
        int[] c=sp(a);
        int[] d=sp(b);
        int e=c[0]*d[0];
        int f=c[1]*d[1];
        int g=gon(e,f);
        t=e/g+"/"+f/g;
        return t;}
    String chu(String a,String b){
        String t="";
        int[] c=sp(a);
        int[] d=sp(b);
        int e=c[0]*d[1];
        int f=c[1]*d[0];
        int g=gon(e,f);
        t=e/g+"/"+f/g;
        return t;}
    int[] sp(String a){
        String[] b=a.split("/");
        int[] c=new int[2];
        c[0]=Integer.parseInt(b[0]);
        c[1]=Integer.parseInt(b[1]);
        return c;
    }
    int gon(int a,int b){
        while(b!=0){
            int c=a%b;
            a=b;
            b=c;
        }
        int a1 = a;
        return a1;
    }
    String jiajian(String a,String b,String p){
        String t="";
        int[] c=sp(a);
        int[] d=sp(b);
        int g=c[1]*d[1]/gon(c[1],d[1]);
        int e=g/c[1]*c[0];
        int f=g/d[1]*d[0];
        if(p.equals("+")){
            int h=e+f;
            t=h+"/"+g;
        }
        else{
            int h=e-f;
            t=h+"/"+g;
        }
        return t;
    }


}
