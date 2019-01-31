public class A157_ReadNCharactersGivenRead4 {
    public static void main(String[] args) {
        A157_ReadNCharactersGivenRead4 solution = new A157_ReadNCharactersGivenRead4();
        int output = solution.read(new char[100], 5);
        System.out.println(output);
    }

    String input = "leetcode";

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int result = 0;
        boolean endOfFile = false;
        char[] tempBuf = new char[4];

        while (!endOfFile && result < n) {
            int curReadLen = read4(tempBuf);

            // if return length is less than 4, then it must reach the end
            if (curReadLen < 4) {
                endOfFile = true;
            }

            // WARNING: the input string may still have more than 4 characters, but n may be less than 4,
            // so we have to get the min value between n - preResult and current return value of read4()
            curReadLen = Math.min(curReadLen, n - result);

            // assign new values from temp buf to main buf
            for (int i = 0; i < curReadLen; i++, result++) {
                buf[result] = tempBuf[i];
            }
        }
        return result;
    }

    public int read4(char[] buf) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            buf[i] = input.charAt(res);
            res++;
        }
        return res;
    }
}
