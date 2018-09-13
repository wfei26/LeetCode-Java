public class A028_ImplementStrStr {
    public static void main(String[] args) {
        A028_ImplementStrStr solution = new A028_ImplementStrStr();
        String hs = "hello";
        String nd = "ll";
        int myResult = solution.strStr(hs, nd);
        System.out.println(myResult);
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                break;
            }
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
