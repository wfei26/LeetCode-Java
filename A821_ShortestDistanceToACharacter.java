
public class A821_ShortestDistanceToACharacter {
    public static void main(String[] args) {
        A821_ShortestDistanceToACharacter solution = new A821_ShortestDistanceToACharacter();
        String s = "loveleetcode";
        char c = 'e';
        int[] output = solution.shortestToChar(s, c);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] result = new int[n];

        // initialize pos as -n because we want to set first several distances as max as possible
        // then we can calculate min distance in second pass
        int pos = -n;

        // traverse from left to right, and get all shortest distance from all left C's
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            else {
                result[i] = i - pos;
            }
        }

        // traverse from right to left, and get all shortest distance from all right C's.
        // then compare with previous result to get min result
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            else {
                result[i] = Math.min(result[i], Math.abs(i - pos));
            }
        }
        return result;
    }
}
