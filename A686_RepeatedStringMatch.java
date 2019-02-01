public class A686_RepeatedStringMatch {
    public static void main(String[] args) {
        A686_RepeatedStringMatch solution = new A686_RepeatedStringMatch();
        String a = "abcd", b = "cdabcdab";
        int output = solution.repeatedStringMatch(a, b);
        System.out.println(output);
    }

    /** start from appending 1 A until over than size limit: lenA + lenB. We set lenA + lenB as boundary
     * is because the prefix of B and postfix of B may from part of A, but the total size of B is no more
     * than lenA + lenB
     * */
    public int repeatedStringMatch(String A, String B) {
        if (A.length() == 0 && B.length() == 0) {
            return 0;
        }

        int res = 1;
        StringBuilder sb = new StringBuilder();

        // while size of sb is within the total length of A of B, we try to append extra A and then check
        // if B is substring of A
        while (sb.length() <= A.length() + B.length()) {
            sb.append(A);
            if (isSubstring(sb.toString(), B)) {
                return res;
            }
            res++;
        }
        return -1;
    }

    public boolean isSubstring(String A, String B) {
        for (int i = 0; i + B.length() <= A.length(); i++) {
            if (A.substring(i, i + B.length()).equals(B)) {
                return true;
            }
        }
        return false;
    }
}
