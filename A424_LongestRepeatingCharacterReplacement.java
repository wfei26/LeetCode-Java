public class A424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        A424_LongestRepeatingCharacterReplacement solution = new A424_LongestRepeatingCharacterReplacement();
        String myInput = "AABABAA";
        int k = 2;
        int myResults = solution.characterReplacement(myInput, k);
        System.out.println(myResults);
    }

//    public int characterReplacement(String s, int k) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        int result = 0, maxCount = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int left = 0, right = 0; right < s.length(); right++) {
//            if (!map.containsKey(s.charAt(right))) {
//                map.put(s.charAt(right), 1);
//            }
//            else {
//                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
//            }
//            maxCount = Math.max(maxCount, map.get(s.charAt(right)));
//
//            for (; right - left + 1 - maxCount > k; left++) {
//                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
//            }
//            result = Math.max(result, right - left + 1);
//        }
//        return result;
//    }

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0, maxCount = 0;
        int[] count = new int[26];
        for (int left = 0, right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
            for (; right - left + 1 > maxCount + k; left++) {
                count[s.charAt(left) - 'A']--;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
