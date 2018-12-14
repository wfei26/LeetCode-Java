import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A500_KeyboardRow {
    public static void main(String[] args) {
        A500_KeyboardRow solution = new A500_KeyboardRow();
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        String[] output = solution.findWords(input);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public String[] findWords(String[] words) {
        List<String> ressult = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        String[] keyboard = {"qwertyuiop", "asdfghjjkl", "zxcvbnm"};

        // store every character with its line number into map
        for (int i = 0; i < keyboard.length; i++) {
            for (char c : keyboard[i].toCharArray()) {
                map.put(c, i);
            }
        }

        for (String word : words) {
            // DO NOT FORGET to convert word to lower case
            String lowerWord = word.toLowerCase();
            int curLine = map.get(lowerWord.charAt(0));
            int count = 0;
            for (char c : lowerWord.toCharArray()) {
                if (map.get(c) == curLine) {
                    count++;
                }
            }
            // if all characters are from same line, then count should be equal to word length
            // then we can add to result
            if (count == word.length()) {
                ressult.add(word);
            }
        }

        String[] strArr = new String[ressult.size()];
        for (int i = 0; i < ressult.size(); i++) {
            strArr[i] = ressult.get(i);
        }
        return strArr;
    }
}
