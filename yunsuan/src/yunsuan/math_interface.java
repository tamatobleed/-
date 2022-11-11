package yunsuan;

import java.util.ArrayList;

/**
 * @Description 数学运算接口。
 * 总体设计：在一次运行中，本地保留全部算式：formuls
 * @Author DR.BLXY
 * @Date 11-08-2022 周二 1:50
 */
interface math_interface{


    /**
     * 算式生成函数（默认中间过程或接口可能含有负数，无分数，长度为2）
     * @param num  生成题目数量
     * @param avg  题目的过程量，结果量的最大数字
     * @param mode 1->加减法；2->乘除法;3->加减乘除
     * @return 完全的算式字符串的数组，如：2+2=4，...
     */
    ArrayList<String> createFormuls(Integer num ,Integer avg ,Integer mode);


    /**
     * 题目生成函数
     * @param Formuls  完全的算式字符串数组，如:2+2=4，...
     * @return 包含等号的题目数组，:2+2=，...
     */
    ArrayList<String> createQuestions(ArrayList<String> Formuls);


    /**
     * 检查答案函数
     *    完全的算式字符串数组，如:2+2=4，...
     * @param answers 输入顺序的各题答案的字符串数组，如：“4”
     *                。若无本题无作答，默认为"//",两个除号
     * @return 返回的字符串结果，如:共获得8/10分！请再接再厉！
     */
    String checkAnswers(ArrayList<String> questions,ArrayList<String> answers);//输入答案与题目个数，由程序进行比较.返回“对”“错”
    ArrayList<String> wronganswer();//获取本次生成对象的错误题目
    /**可以通过字节流进一步改进，加入长期错题与加入错题清除算法
     *
     *
     */


}