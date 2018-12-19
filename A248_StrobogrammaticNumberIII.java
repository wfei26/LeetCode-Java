import java.util.*;

public class A248_StrobogrammaticNumberIII {
    public static void main(String[] args) {
        A248_StrobogrammaticNumberIII solution = new A248_StrobogrammaticNumberIII();
        int output = solution.strobogrammaticInRange("0", "0");
        System.out.println(output);
    }

    public int strobogrammaticInRange(String low, String high) {
        Map<Character, Character> map = new HashMap<>();
        String keys = "01689", values = "01986";
        for (int i = 0; i < keys.length(); i++) {
            map.put((keys.charAt(i)), values.charAt(i));
        }

        // get all possible candidates between low and high
        List<String> candidates = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            candidates.addAll(dfs(map, i, i));
        }

        int result = 0;
        // drop invalid candidates that have same length with low but smaller than low number
        // and have same length with high but greater than high number
        for (String sgNum : candidates) {
            // IMPORTANT: compare two strings: a.compareTo(b)
            // WARNING: must use continue to deal with this case, CANNOT use complement of the condition
            // with result++ inside of if statement
            // eg: if low = high, the invalid number will must satisfy either case in if statement, but it is wrong
            if (sgNum.length() == low.length() && sgNum.compareTo(low) < 0
                    || sgNum.length() == high.length() && sgNum.compareTo(high) > 0) {
                continue;
            }
            result++;
        }
        return result;
    }

    // completely reuse the dfs function of the previous question: Strobogrammatic Number II
    public List<String> dfs(Map<Character, Character> map, int curLen, int originalLen) {
        // recursion exit: when string is odd length or even length
        if (curLen == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        else if (curLen == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        // recursive step: expand from middle to left and right in every recursive call
        List<String> newList = dfs(map, curLen - 2, originalLen);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < newList.size(); i++) {
            for (Map.Entry<Character, Character> entry : map.entrySet()) {
                // corner case: number cannot start with 0
                if (entry.getKey() == '0' && curLen == originalLen) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey()).append(newList.get(i)).append(entry.getValue());
                result.add(sb.toString());
            }
        }
        return result;
    }
}
