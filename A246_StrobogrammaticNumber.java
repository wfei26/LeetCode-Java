import java.util.HashMap;
import java.util.Map;

public class A246_StrobogrammaticNumber {
    public static void main(String[] args) {
        A246_StrobogrammaticNumber solution = new A246_StrobogrammaticNumber();
        String input = "689";
        boolean output = solution.isStrobogrammatic(input);
        System.out.println(output);
    }

    // set all mapping relationship between every pair of strobogrammatic number
    // and then use two pointers to check the input num
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        String keys = "01689", values = "01986";
        for (int i = 0; i < keys.length(); i++) {
            map.put(keys.charAt(i), values.charAt(i));
        }

        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
