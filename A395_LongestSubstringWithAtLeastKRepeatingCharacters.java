import java.util.Arrays;

public class A395_LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        A395_LongestSubstringWithAtLeastKRepeatingCharacters solution = new A395_LongestSubstringWithAtLeastKRepeatingCharacters();
        String myInput = "eeaaabbbcce";
        int size = 3;
        int myResult = solution.longestSubstring(myInput, size);
        System.out.println(myResult);
    }

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int[] map = new int[26];
        char[] strArr = s.toCharArray();

        //find the longest window which contains exactly "totalAlphabet" number of unique
        //characters and for each character, there are at least K repeating ones
        for (int totalAlphabet = 1; totalAlphabet <= 26; totalAlphabet++) {
            Arrays.fill(map, 0);
            int numOfAlphabet = 0;
            int qualified = 0;
            for (int i = 0, j = 0; j < strArr.length;) {
                if (numOfAlphabet <= totalAlphabet) {
                    int curIndex = strArr[j] - 'a';
                    if (map[curIndex] == 0) {
                        numOfAlphabet++;
                    }
                    map[curIndex]++;
                    //Once one alphabet matches the K length, it satisfies the condition of window
                    if (map[curIndex] == k) {
                        qualified++;
                    }
                    j++;
                }
                else {
                    int curIndex = strArr[i] - 'a';
                    if (map[curIndex] == k) {
                        qualified--;
                    }
                    map[curIndex]--;
                    if (map[curIndex] == 0) {
                       numOfAlphabet--;
                    }
                    i++;
                }
                //Traverse the entire map array from 1 to 26, we can guarantee that we will
                //find the longest qualified window in one of the iterations.
                //When numOfAlphabet = totalAlphabet = qualified
                if (numOfAlphabet == totalAlphabet && numOfAlphabet == qualified) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }
}
