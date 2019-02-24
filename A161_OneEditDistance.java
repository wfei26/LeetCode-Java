public class A161_OneEditDistance {
    public static void main(String[] args) {
        A161_OneEditDistance solution = new A161_OneEditDistance();
        String s = "abcc";
        String t = "acc";
        boolean output = solution.isOneEditDistance(s, t);
        System.out.println(output);
    }

    /**
     * We actually only has two conditions:
     * 1. when they have same length, one of them should be modified: we only need to compare the rest of substring
     * start from i + 1 of two strings -> if same: true, else: false
     * 2. when they have different length, delete and insert can be considered as same case: we only need to compare
     * the rest of substring from i of the shorter one and from i + 1 of the longer one -> if same: true, else: false
     * */
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length(), tlen = t.length();
        for (int i = 0; i < slen && i < tlen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // same length
                if (slen == tlen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                // different length
                else if (slen < tlen) {
                    return s.substring(i).equals(t.substring(i + 1));
                }
                // different length
                else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        // corner case: All previous chars are the same, the only possibility is deleting the end char in the longer
        // one of s and t
        return Math.abs(slen - tlen) == 1;
    }
}
