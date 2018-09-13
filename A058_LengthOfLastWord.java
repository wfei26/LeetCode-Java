public class A058_LengthOfLastWord {
    public static void main(String[] args) {
        A058_LengthOfLastWord solution = new A058_LengthOfLastWord();
        String myInput = "hello world    ";
        int myResult = solution.lengthOfLastWord(myInput);
        System.out.println(myResult);
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int i = s.length() - 1;
        for (; i >= 0 && s.charAt(i) == ' '; i--){}
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return result;
            }
            result++;
        }
        return result;
    }
}
