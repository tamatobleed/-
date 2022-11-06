package yunsuan;

import java.util.ArrayList;

interface jiekou{
      String shengcheng(Integer num ,Integer avg ,Integer mode );
    /**
     * num是生成题目数量，avg是题目范围，mode是模式选择1是加减，2是四则运算。
     *
     */

     String getquestion(Integer n);//获取返回第n项题目
      String compare(Integer input,Integer num);//输入答案与题目个数，由程序进行比较.返回“对”“错”
     String answer(Integer i);//获取第i题目答案
    String getconclusion(ArrayList<String> a);//返回答案结论如 9/10
    ArrayList<String> getallwrong();//返回错误的题目
 }
/**每次输入开始或继续时都生成一个题目或答案，调用生成算法时为answer和question赋值，由于是用于七八岁的儿童，不支持分数与负数。
*实现类为shixian,jiekou a=new shixian;
 * a.shengcheng(10.10,1);
 *
*/