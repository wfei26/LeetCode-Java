public class A158_ReadNCharactersGivenRead4II_CallMultipleTimes {
    public static void main(String[] args) {
        A158_ReadNCharactersGivenRead4II_CallMultipleTimes solution = new A158_ReadNCharactersGivenRead4II_CallMultipleTimes();
        int output = solution.read(new char[8], 5);
        System.out.println(output);
    }

    String input = "leetcode";


    /**
     * @param bufCache: store reading results when we call read4() every time. Once it is empty, call read4() again
     * @param bufPtr: globe variable that points next reading position in bufCache. It should always < 4
     * @param bufCount: count number of elements in bufCache. Usually equals to 4, but may less than 4 when reach end of input
     * */
    char[] bufCache = new char[4];
    int bufPtr = 0;
    int bufCount = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int nIndex = 0;

        // fill out every position until reach n
        while (nIndex < n) {
            // only if bufPtr does not reach the end of bufCache array, we can assign value from bufCache to final buf array
            if (bufPtr < bufCount) {
                buf[nIndex++] = bufCache[bufPtr++];
            }

            // if we already used all characters from bufCache, we need to read new characters by calling read4()
            // and then fill the bufCache
            else {
                bufCount = read4(bufCache);
                bufPtr = 0;

                // if no more characters we can read, we should break the entire loop and return 0
                if (bufCount == 0) {
                    break;
                }
            }
        }
        return nIndex;
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
