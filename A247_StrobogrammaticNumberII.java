import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A247_StrobogrammaticNumberII {
    public static void main(String[] args) {
        A247_StrobogrammaticNumberII solution = new A247_StrobogrammaticNumberII();
        List<String> output = solution.findStrobogrammatic(3);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();
        String keys = "01689", values = "01986";
        for (int i = 0; i < keys.length(); i++) {
            map.put(keys.charAt(i), values.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        stringHelper(result, map, sb, n);
        return result;
    }

    public void stringHelper(List<String> result, Map<Character, Character> map, StringBuilder sb, int n) {
        if (n == 0) {
            result.add(sb.toString());
        }

        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            sb.append(entry);
            stringHelper(result, map, sb, n - 2);
        }
    }
}
