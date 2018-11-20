public class A443_StringCompression {
    public static void main(String[] args) {
        A443_StringCompression solution = new A443_StringCompression();
        char[] input = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int output = solution.compress(input);
        System.out.println(output);
    }

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < chars.length;) {
            // re-initialize count and curChar at the beginning of every iteration
            int count = 0;
            char curChar = chars[i];
            while (i < chars.length && curChar == chars[i]) {
                count++;
                i++;
            }

            // assign curChar to current result index
            chars[result++] = curChar;

            // assign each digit of count number to current result index
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[result++] = c;
                }
            }
        }
        return result;
    }
}
