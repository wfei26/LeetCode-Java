import java.util.HashSet;
import java.util.Set;

public class A824_GoatLatin {
    public static void main(String[] args) {
        A824_GoatLatin solution = new A824_GoatLatin();
        String input = "I speak Goat Latin";
        String output = solution.toGoatLatin(input);
        System.out.println(output);
    }

    /** store vowel in a hashset, and follow the requirements to build string */
    public String toGoatLatin(String S) {
        String[] strArr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<Character> vowel = new HashSet<>();
        String vowels = "aeiouAEIOU";
        for (char c : vowels.toCharArray()) {
            vowel.add(c);
        }

        for (int i = 0; i < strArr.length; i++) {
            char firstLetter = strArr[i].charAt(0);
            if (vowel.contains(firstLetter)) {
                sb.append(strArr[i]);
            }
            else {
                sb.append(strArr[i].substring(1)).append(firstLetter);
            }
            sb.append("ma");
            for (int j = 0; j < i + 1; j++) {
                sb.append("a");
            }
            if (i != strArr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
