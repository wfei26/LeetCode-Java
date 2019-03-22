import java.util.HashMap;

public class A013_RomanToInteger {
    public static void main(String[] args) {
        A013_RomanToInteger solution = new A013_RomanToInteger();
        String myInput = "LIVII";
        int myResult = solution.romanToInt(myInput);
        System.out.println(myResult);
    }

    /** put all special number mapping relationship into a map, then traverse the input number from end to start.
     * If left roman number is smaller than right, we subtract it, otherwise, we add it up */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] strArr = s.toCharArray();
        int result = map.get(strArr[s.length() - 1]);
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(strArr[i]) < map.get(strArr[i + 1])) {
                result -= map.get(strArr[i]);
            }
            else {
                result += map.get(strArr[i]);
            }
        }
        return result;
    }
}
