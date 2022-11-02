package yunsuan;
import java.lang.*;
import java.util.Random;

interface jiekou{
      String shengcheng(int num ,int avg );//生成算式的放在String[]中
     String getquestion(int n);//获取返回第n项题目
      String compare(int input,int num);//输入答案与题目个数，由程序进行比较.返回“对”“错”
     String answer(int i);//获取第i题目答案
     String getwrong(int i);//将错误的题目放在一个数组中、方法获取错误的第n题
 }
/**每次输入开始或继续时都生成一个题目或答案，调用生成算法时为answer和question赋值，由于是用于七八岁的儿童，不支持分数与负数。
*实现类为shixian,jiekou a=new shixian;
*/