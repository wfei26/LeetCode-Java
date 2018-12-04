import java.util.HashSet;
import java.util.Set;

public class A345_ReverseVowelsOfAString {
    public static void main(String[] args) {
        A345_ReverseVowelsOfAString solution = new A345_ReverseVowelsOfAString();
        String input = "leetcode";
        String output = solution.reverseVowels(input);
        System.out.println(output);
    }

    public String reverseVowels(String s) {
        if (s == null) {
            return s;
        }

        Set<Character> dict = new HashSet<>();
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < vowels.length(); i++) {
            dict.add(vowels.charAt(i));
        }

        // use two pointers to trace vowels
        int i = 0, j = s.length() - 1;
        char[] strArr = s.toCharArray();
        while (i < j) {
            if (!dict.contains(strArr[i])) {
                i++;
            }
            if (!dict.contains(strArr[j])) {
                j--;
            }
            if (dict.contains(strArr[i]) && dict.contains(strArr[j])) {
                swap(strArr, i, j);
                i++;
                j--;
            }
        }
        return new String(strArr);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
