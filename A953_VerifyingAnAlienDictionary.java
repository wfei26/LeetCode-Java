public class A953_VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        A953_VerifyingAnAlienDictionary solution = new A953_VerifyingAnAlienDictionary();
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean output = solution.isAlienSorted(words, order);
        System.out.println(output);
    }

    /** Mapping each character with its index in order array, and then use mapping dictionary to compare
     * every pair of words in words array */
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }

        int n = order.length();
        int[] map = new int[26];

        for (int i = 0; i < n; i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            if (!correctOrder(word1, word2, map)) {
                return false;
            }
        }
        return true;
    }

    public boolean correctOrder(String word1, String word2, int[] map) {
        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            else if (map[c1 - 'a'] > map[c2 - 'a']) {
                return false;
            }
            else {
                return true;
            }
        }
        return word2.length() >= word1.length();
    }
}
