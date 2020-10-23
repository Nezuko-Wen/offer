package leecode;

/**
 * 字符串转整数
 */
public class No8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }

    //有限状态机DFA





    //这个一般解法过不了leecode
    public static int myAtoi(String str) {
        if (str.length() == 0){
            return 0;
        }
        int result = 0;
        boolean isValid = false;
        Long l = 0L;
        char symbol = ' ';
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!isValid){
                if (chars[i] == '+' || chars[i] == '-') {
                    if ('0' <= chars[i + 1] && chars[i + 1] <= '9'){
                        isValid = true;
                        symbol = chars[i];
                        continue;
                    }
                }
                if ('0' <= chars[i] && chars[i] <= '9'){
                    isValid = true;
                    int value = chars[i] - 48;
                    l = l * 10 + value;
                    continue;
                }
            }
            else {
                if ('0' <= chars[i] && chars[i] <= '9') {
                    int value = chars[i] - 48;
                    if (l * 10 + value >= Integer.MAX_VALUE){
                        l = new Long(Integer.MAX_VALUE);
                        break;
                    }
                    l = l * 10 + value;
                }
                else {
                    break;
                }
            }
        }
        if (symbol == '-'){
            l = l - 2 * l;
        }
        result = l.intValue();
        return result;
    }
}

