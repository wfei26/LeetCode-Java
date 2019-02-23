public class A880_DecodedStringAtIndex {
    public static void main(String[] args) {
        A880_DecodedStringAtIndex solution = new A880_DecodedStringAtIndex();
        String input = "leet2code3";
        String output = solution.decodeAtIndex(input, 10);
        System.out.println(output);
    }

    /** If we decode and expand the entire string by using stack, it may occur stack overflow. Instead of it, we could
     * virtually expand the string, which iteratively store current string length until it reach K. Because we do not
     * care all strings before K, we only care the substring across K.
     * After preprocessing, start from last accessing position, we should trace back to find Kth position */
    public String decodeAtIndex(String S, int K) {
        if (S.length() == 0) {
            return S;
        }

        int i = 0;
        int strLen = 0;
        for (i = 0; i < S.length() && strLen < K; i++) {
            if (strLen == K) {
                return Character.toString(S.charAt(i));
            }

            if (!Character.isDigit(S.charAt(i))) {
                strLen++;
            }
            else {
                strLen = strLen * (S.charAt(i) - '0');
            }
        }

        // leet2code3
        // leetleetcodeleetleetcodeleetleetcode
        while (i > 0) {
            // if character is a digit, we should drop the redundant repeating part by mod string length
            if (Character.isDigit(S.charAt(i))) {
                strLen /= S.charAt(i) - '0';
                K = K % strLen;
            }
            else if (K % strLen == 0) {
                return Character.toString(S.charAt(i));
            }
            else if (K % strLen > 0) {
                strLen++;
            }
            i--;
        }
        return "";
    }
}
