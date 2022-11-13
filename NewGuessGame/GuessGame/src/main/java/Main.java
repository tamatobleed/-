import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("不是狐，不是狗，前面架铡刀，后面拖扫帚");
        list1.add("一种肉食动物");
        list1.add("许多童话里的大反派");
        list1.add("狼");

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("角黍头，梅花脚，屁股挂把批示刀，坐着反比立着高");
        list2.add("是人类的好朋友");
        list2.add("高兴时会摇尾巴");
        list2.add("狗");

        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("年纪并不大，胡子一大把，不论遇见谁，总爱喊妈妈");
        list3.add("有一部以它为主角的动画片");
        list3.add("十二生肖中有它");
        list3.add("羊");

        ArrayList<String> list4 = new ArrayList<String>();
        list4.add("坐也是行，立也是行，行也是行，卧也是行");
        list4.add("住在水里");
        list4.add("没手也没脚");
        list4.add("鱼");

        ArrayList<String> list5 = new ArrayList<String>();
        list5.add("有位小姑娘，身穿黄衣裳。谁要欺负她，她就戳一枪");
        list5.add("以勤劳著称");
        list5.add("是一种群居动物");
        list5.add("黄蜂");

        ArrayList<String> list6 = new ArrayList<String>();
        list6.add("纵横沙漠中，展翅飞不起，快走犹如飞，是鸟中第一");
        list6.add("人们喜欢用它来比喻胆小怕事的人");
        list6.add("是体型最大的鸟类");
        list6.add("鸵鸟");

        ArrayList<String> list7 = new ArrayList<String>();
        list7.add("瞳孔遇光能大小，唱起歌来妙妙妙，夜半巡逻不需灯，四处畅行难不倒");
        list7.add("一种很常见的宠物");
        list7.add("老鼠的天敌");
        list7.add("猫");

        ArrayList<String> list8 = new ArrayList<String>();
        list8.add("上肢下肢都是手，有时爬来有时走，走时很象一个人，爬时又象一条狗");
        list8.add("是人类的近亲");
        list8.add("孙悟空是它们中的一员");
        list8.add("猴子");

        ArrayList<String> list9 = new ArrayList<String>();
        list9.add("小小飞贼，兵器是针，抽别人血，养自我身");
        list9.add("是一种害虫");
        list9.add("喜欢嗡嗡叫");
        list9.add("蚊子");

        ArrayList<String> list10 = new ArrayList<String>();
        list10.add("身体花绿，走路弯曲弄笑的谜语，洞里进出，启齿恶毒");
        list10.add("喜欢吐舌头");
        list10.add("没手也没脚，走路靠爬行");
        list10.add("蛇");


        /**接口测试*/

        /**问题*/
        ArrayList<String> list = null;
        /**随机数，实现随机出题*/
        int num = (int) (Math.random() * 10 + 1);
        switch (num) {
            case 1 : list = list1;
                break;
            case 2 : list = list2;
                break;
            case 3 : list = list3;
                break;
            case 4 : list = list4;
                break;
            case 5 : list = list5;
                break;
        }
        System.out.println(GameFunction.getQuestion(list));
        System.out.println(GameFunction.getTipsOne(list));
        System.out.println(GameFunction.getTipsTwo(list));
        System.out.println(GameFunction.getAnswer(list));
    }
}
