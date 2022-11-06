package yunsuan;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        jiekou a=new shixian();

        ArrayList<String> asd=new ArrayList<>(100);
        ArrayList<String> asddd =new ArrayList<String>();
        a.shengcheng(100,10,2);
        String b=a.getquestion(10);
        String c=a.answer(10);
        String d=a.compare(10,10);
        asddd=a.getallwrong();
        String f=a.getconclusion(asd);
     System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(asddd);
        System.out.println(f);
    }
}
/**     测试类 可删除
 *
 *
 */