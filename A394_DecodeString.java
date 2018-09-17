import java.util.Stack;

public class A394_DecodeString {
    public static void main(String[] args) {
        A394_DecodeString solution = new A394_DecodeString();
        String input = "2[abc]3[cd]ef";
        String output = solution.decodeString(input);
        System.out.println(output);
    }

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        //store result string
        Stack<Integer> countStack = new Stack<>();
        //store number of repeat times
        //use stack because we need to deal with nested bracket
        //eg: 2[3[ab]2[cd]]
        Stack<String> resultStack = new Stack<>();
        char[] strArr = s.toCharArray();
        int count = 0;
        String curResult = "";
        for (int i = 0; i < s.length(); i++) {
            //calculate repeat number
            if (Character.isDigit(strArr[i])) {
                count = count * 10 + (strArr[i] - '0');
            }
            //push previous decoded string into stack
            else if (strArr[i] == '[') {
                countStack.push(count);
                resultStack.push(curResult);
                count = 0;
                curResult = "";
            }
            //start to decode current string
            else if (strArr[i] == ']') {
                int repeat = countStack.pop();
                StringBuilder temp = new StringBuilder(resultStack.pop());
                //concat new repeated string to previous result string
                for (int j = 0; j < repeat; j++) {
                    temp.append(curResult);
                }
                curResult = temp.toString();
            }
            //normal character, concat to current string, preparing for decoding
            else {
                curResult += strArr[i];
            }
        }
        return curResult;
    }
}
