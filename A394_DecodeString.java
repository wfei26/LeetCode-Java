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

        //store number of repeat times
        Stack<Integer> countStack = new Stack<>();

        //store result string
        //use stack because we need to deal with nested bracket
        //eg: 2[3[ab]2[cd]]
        Stack<String> resultStack = new Stack<>();

        char[] strArr = s.toCharArray();
        int count = 0;
        StringBuilder curStr = new StringBuilder();

        //we have four different cases: digit, '[', ']', alphabet
        for (int i = 0; i < s.length(); i++) {
            //calculate repeat number
            if (Character.isDigit(strArr[i])) {
                count = count * 10 + (strArr[i] - '0');
            }

            //push previous decoded string into stack
            else if (strArr[i] == '[') {
                countStack.push(count);
                resultStack.push(curStr.toString());
                //DO NOT FORGET to reset count and curResult
                count = 0;
                //REMEMBER: API to clean StringBuilder object: .setLength(0)
                curStr.setLength(0);
            }

            //start to decode current string
            else if (strArr[i] == ']') {
                int repeat = countStack.pop();
                StringBuilder prefixStr = new StringBuilder(resultStack.pop());
                //concat new repeated string to previous result string
                for (int j = 0; j < repeat; j++) {
                    prefixStr.append(curStr);
                }
                //update result string
                curStr = prefixStr;
            }

            //normal character, concat to current string, preparing for decoding
            else {
                curStr.append(strArr[i]);
            }
        }
        return curStr.toString();
    }
}
