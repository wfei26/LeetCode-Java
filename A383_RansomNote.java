public class A383_RansomNote {
    public static void main(String[] args) {
        A383_RansomNote solution = new A383_RansomNote();
        String ransom = "ab";
        String magazine = "aab";
        boolean output = solution.canConstruct(ransom, magazine);
        System.out.println(output);
    }

    // use map to count frequency of each character in magazine, and then check ransom note
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
