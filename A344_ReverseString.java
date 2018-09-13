public class A344_ReverseString {
    public static void main(String[] args) {
        A344_ReverseString solution = new A344_ReverseString();
        String myStr = "abcdefg";
        String result = solution.reverseStringBetter(myStr);
        System.out.println(result);
    }

    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            result.append(s.charAt(j));
        }
        return result.toString();
    }

    public String reverseStringBetter(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] strArr = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char temp = strArr[i];
            strArr[i] = strArr[j];
            strArr[j] = temp;
        }
        return new String(strArr);
    }
}
