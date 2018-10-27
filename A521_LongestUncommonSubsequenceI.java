public class A521_LongestUncommonSubsequenceI {
    public static void main(String[] args) {
        A521_LongestUncommonSubsequenceI solution = new A521_LongestUncommonSubsequenceI();
        String str1 = "aba";
        String str2 = "cdc";
        int output = solution.findLUSlength(str1, str2);
        System.out.println(output);
    }

    //we can always choose the longer string as the "Subsequence",
    //and surely it cannot be the subsequence of the shorter one
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        else {
            return Math.max(a.length(), b.length());
        }
    }
}
