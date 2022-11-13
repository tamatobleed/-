import java.util.ArrayList;

public class GameFunction {
    /**获取问题*/
    public static String getQuestion(ArrayList<String> list) {
        return list.get(0);
    }

    /**获取提示一*/
    public static String getTipsOne(ArrayList<String> list) {
        return list.get(1);
    }

    /**获取提示二*/
    public static String getTipsTwo(ArrayList<String> list) {
        return list.get(2);
    }

    /**判断对错*/
    public static boolean isRight(ArrayList<String> list, String answer) {
        //若为空，直接判错
        if(answer.length() == 0)  return false;

        boolean result = false;
        if (answer.equals(list.get(3))) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**获取答案*/
    public static String getAnswer(ArrayList<String> list) {
        return list.get(3);
    }
}
