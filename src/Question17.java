public class Question17 {
    public static void main(String[] args) {
        int condition = 3;
        printNumList(condition);
    }

    private static void printNumList(int condition) {
        char[] addChar = new char[condition];
        for (int i = 0; i < addChar.length; i ++){
            addChar[i] = '0';
        }
        StringBuffer spellStr = new StringBuffer();
        while (true){
            boolean max = false;
            int index = addChar.length - 1;
            for (;;){
                if (addChar[index] + 1 > '9'){
                    if (index == 0){
                        max = true;
                        break;
                    }
                    addChar[index] = '0';
                    index --;
                    continue;
                }
                addChar[index] = (char) (addChar[index] + 1);
                boolean firstNum = false;
                for (char newValue : addChar){
                    if (!firstNum){
                        if (newValue == '0'){
                            continue;
                        }
                        firstNum = true;
                    }
                    spellStr.append(newValue);
                }
                System.out.println(spellStr.toString());
                spellStr.setLength(0);
                break;
            }
            if (max){
                break;
            }
        }
    }
}
