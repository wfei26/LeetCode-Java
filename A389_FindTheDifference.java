public class A389_FindTheDifference {
    public static void main(String[] args) {
        A389_FindTheDifference solution = new A389_FindTheDifference();
        String s = "aab", t = "aa";
        char output = solution.findTheDifference(s, t);
        System.out.println(output);
    }

    /** use XOR to operate both of two strings, all same element will be eliminated, the rest item should be
     * the difference one */
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}
