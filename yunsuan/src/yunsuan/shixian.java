package yunsuan;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 *
 *
 *
 */
public  class shixian implements jiekou {
    int k = 0;
   int time=0;
   int shuliang=0;//题目数量
    String []answer =new String[10000];
    ArrayList<String> wrong =new ArrayList<String>();
    String []question =new String[10000];//在new对象时创建放置
    int p = 0;

    public  String shengcheng(Integer time ,Integer avg,Integer mode) {
        shuliang=time ;
           int a=0;
        for(int i=0;i<time;i++){
            suanshi(i,avg,mode);
            a=Integer.parseInt(answer[i]);
            if(question[i]=="0"||a<=0) suanshi(i,avg,mode);
            if(question[i]=="0"||a<=0) suanshi(i,avg,mode);
        }
        if(question.length!=0)return "生成失败";
        question=replaceNull(question);
        answer=replaceNull(answer);
         return  "生成成功";
    }



    public String getquestion(Integer n){
        return  question[n-1];
    }


    

    @Override
    public String getconclusion(ArrayList<String> a) {


        return time+"/"+shuliang;
    }

    @Override
    public ArrayList<String> getallwrong() {
        return wrong;
    }

    public String  compare(Integer input,Integer num){
        int a=Integer.parseInt(answer[num]);
        if(input==a) {time++;return "答案正确";}
        else{
            boolean add = wrong.add(question[num - 1] + "=" + answer[num - 1]);
            p++; return "答案错误";}

    }//输入答案，由程序进行比较.输出"答案正确"或"答案错误"
    public String answer(Integer i){
        if(answer[i-1].equals(""))return "算式未开始生成";
       else return answer[i-1];

    }
    //获取当前题目答案

    //生成算式的方法
    private  String[] guolv(String[] all){
      int a, b;
    String k;

         for(int h=0;h<2;h++){

        for (int i = 1; i < all.length; i = i + 2) {
            if (all[i].equals("÷")) {
                b = Integer.parseInt(all[i + 1]);
                a = Integer.parseInt(all[i - 1]);             //排除除数为零与出现负数和分数可能
                if (b == 0) {
                    all[i + 1] = "";
                    all[i] = "0";
                    all[i - 1] = "";
                } else if (a % b != 0) {
                    all[i + 1] = "";
                    all[i] = "0";
                    all[i - 1] = "";
                }all=replaceNull(all);

            }
        }

        for (int i = 1; i < all.length; i = i + 2) {
            if (all[i].equals("-")) {
                a = Integer.parseInt(all[i - 1]);
                b = Integer.parseInt(all[i + 1]);
                if (a < b) {
                    k = all[i - 1];
                    all[i - 1] = all[i + 1];
                    all[i + 1] = k;
                    all=replaceNull(all);
                }
            }
        }
    }
        all=replaceNull(all);
        return all;
        }

    private  String[] turn(String[] all){
        for(int z=0;z< all.length;z++){
            if(!all[z].contains("/")&&!all[z].equals("x")&&!all[z].equals("÷")&&!all[z].equals("+")&&!all[z].equals("-")&&!all[z].equals(""))
                all[z]=all[z]+"/1";}
        return all;
    }


    public    String suanshi(int i ,int avg,int mode) {


        k = random2and3();            //是生成两还是三个数
        String[] num = new String[k];
        String[] fu = new String[k - 1];
        String[] all = new String[2 * k - 1];
        for (int d = 0; d < k; d++) {
            num[d] = randomnum(avg);
        }
        //生成n以内的随机数
        for (int d = 0; d < k - 1; d++) {
            fu[d] = randomfu(mode);
        }
        //生成随机四则运算字符
        int w = 0;
        int q = 0;
        for (int y = 0; y < 2 * k - 1; y++) {

            //数加入
            if (y % 2 == 0) {

                all[y] = num[w];
                w++;
            }
            //字符加进
            else {
                all[y] = fu[q];
                q++;
            }
        }
        all = guolv(all);
       String que="";
        for (int k = 0; k < all.length; k++) {
            que = que + all[k];
        }
        all = turn(all);
        question[i]=que;
        calculate c = new calculate();
        answer[i] = c.cal(all,i,avg);

        return "生成成功";
    }






    private int random2and3(){
        Random a=new Random();
        int d=a.nextInt(2);


        return d+2;
    }



    private String randomnum(int n){
        Random r=new Random();
        int a=r.nextInt(n);
        String h=Integer.toString(a);
        String j=h;
        return  j;
    }
    private String randomfu(int mode) {
        Random d=new Random();

        String fu="";

        if(mode==2){int k=d.nextInt(4);
            if(k==0)fu="+";
        if(k==1)fu="-";
        if(k==2)fu="x";
        if(k==3)fu="÷";}
        if(mode==1){int k=d.nextInt(2); if(k==0)fu="+";
            if(k==1)fu="-";}

        return fu;
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

}

