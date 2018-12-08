public class A214_ShortestPalindrome {
    public static void main(String[] args) {
        A214_ShortestPalindrome solution = new A214_ShortestPalindrome();
        String input = "aacecaaa";
        String output = solution.shortestPalindrome(input);
        System.out.println(output);
    }

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        // curEnd+1 means the starting position we need to add reversed characters
        int curEnd = s.length() - 1;
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else {
                curEnd--;
                j = curEnd;

                // since we have to adding characters IN FRONT OF original string, so we need to reset
                // left pointer to 0 and starting from first position to traverse again
                i = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        // adding reversed right part in front of original string
        // IMPORTANT: reverse() is API for StringBuilder, NOT for String
        sb.append(s.substring(curEnd + 1)).reverse();
        sb.append(s);
        return sb.toString();
    }
}
