public class A541_ReverseStringII {
    public static void main(String[] args) {
        A541_ReverseStringII solution = new A541_ReverseStringII();
        String myStr = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k = 39;
        String result = solution.reverseStr(myStr, k);
        System.out.println(result);
    }

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }

        char[] strArr = s.toCharArray();
        for (int i = 0, j = k - 1; i < s.length(); i += 2 * k, j += 2 * k) {
            if (j > s.length() - 1) {
                j = s.length() - 1;
            }
            for (int start = i, end = j; start < end; start++, end--) {
                char temp = strArr[start];
                strArr[start] = strArr[end];
                strArr[end] = temp;
            }
        }
        return new String(strArr);
    }
}
