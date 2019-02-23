public class A791_CustomSortString {
    public static void main(String[] args) {
        A791_CustomSortString solution = new A791_CustomSortString();
        String s = "cba";
        String t = "abcd";
        String output = solution.customSortString(s, t);
        System.out.println(output);
    }

    /** count frequency of each character in T, traverse S, find all matching characters, and then append the rest */
    public String customSortString(String S, String T) {
        int[] map = new int[26];
        for (char c : T.toCharArray()) {
            map[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        // append sorted characters (show in S) firstly
        for (int i = 0; i < S.length(); i++) {
            int curChar = S.charAt(i) - 'a';
            for (int j = 0; j < map[curChar]; j++) {
                sb.append(S.charAt(i));
            }
            // set frequency as 0, to avoid appending again in next loop
            map[curChar] = 0;
        }

        // append the rest of characters except sorted character
        for (int i = 0; i < 26; i++) {
            while (map[i] != 0) {
                sb.append((char)(i + 'a'));
                map[i]--;
            }
        }
        return sb.toString();
    }
}
