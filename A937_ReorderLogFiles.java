import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A937_ReorderLogFiles {
    public static void main(String[] args) {
        A937_ReorderLogFiles solution = new A937_ReorderLogFiles();
    }

    /** use two list to store characters and numbers, then sort characters list */
    public String[] reorderLogFiles(String[] logs) {
        List<String> characters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        for (String log : logs) {
            char key = log.charAt(log.indexOf(" ") + 1);
            if (Character.isDigit(key)) {
                numbers.add(log);
            }
            else {
                characters.add(log);
            }
        }

        Collections.sort(characters, (a, b) -> (a.substring(a.indexOf(" ") + 1)).compareTo(b.substring(b.indexOf(" ") + 1)));

        String[] result = new String[logs.length];
        int index = 0;
        for (String s : characters) {
            result[index++] = s;
        }
        for (String num : numbers) {
            result[index++] = num;
        }
        return result;
    }
}
