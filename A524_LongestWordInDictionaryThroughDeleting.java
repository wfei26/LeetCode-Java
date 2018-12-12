import java.util.List;

public class A524_LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {

    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        int max = 0;

        for (String str : d) {
            if (isSubsequence(s, str)) {
                max = Math.max(max, str.length());
                result = str;
            }
        }
        return result;
    }

    public boolean isSubsequence(String a, String b) {
        for (int i = 0, j = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            if (j == b.length() - 1) {
                return true;
            }
        }
        return false;
    }
}
