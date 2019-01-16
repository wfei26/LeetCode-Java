public class A038_CountAndSay {
    public static void main(String[] args) {
        A038_CountAndSay solution = new A038_CountAndSay();
        String output = solution.countAndSay(9);
        System.out.println(output);
    }

    public String countAndSay(int n) {
        // base case (recursion exit)
        if (n == 1) {
            return "1";
        }

        // recursively get previous string
        String prevStr = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // traverse the previous string, and then use two pointer to build the result string
        while (i < prevStr.length()) {
            int j = 0;
            char curChar = prevStr.charAt(i);
            // increase second pointer until find different number
            while (i + j < prevStr.length() && prevStr.charAt(i + j) == curChar) {
                j++;
            }
            sb.append(j).append(curChar);
            i += j;
        }
        return sb.toString();
    }
}
