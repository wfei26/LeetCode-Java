import java.util.HashSet;

public class A266_PalindromePermutation {
    public static void main(String[] args) {
        A266_PalindromePermutation palinPermuValidation = new A266_PalindromePermutation();
        String input = "aab";
        boolean output = palinPermuValidation.canPermutePalindrome(input);
        System.out.println(output);
    }

    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            }
            else {
                set.remove(c);
            }
        }
        return (set.size() == 0) || (set.size() == 1);
    }
}
