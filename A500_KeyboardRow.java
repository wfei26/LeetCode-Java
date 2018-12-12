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
        for (int i = 0; i < keyboard.length; i++) {
            for (char c : keyboard[i].toCharArray()) {
                map.put(c, i);
            }
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {

            }
        }

        String[] strArr = new String[ressult.size()];
        for (int i = 0; i < ressult.size(); i++) {
            strArr[i] = ressult.get(i);
        }
        return strArr;
    }
}
