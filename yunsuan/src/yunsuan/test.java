package yunsuan;

public class test {
    public static void main(String[] args) {
        jiekou a=new shixian();
        a.shengcheng(100,10);
        String b=a.getquestion(10);
        String c=a.answer(10);
        String d=a.compare(10,10);
        String e=a.getwrong(1);

     System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
/**     测试类 可删除
 *
 *
 */