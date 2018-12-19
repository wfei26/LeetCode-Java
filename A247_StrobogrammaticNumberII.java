import java.util.*;

public class A247_StrobogrammaticNumberII {
    public static void main(String[] args) {
        A247_StrobogrammaticNumberII solution = new A247_StrobogrammaticNumberII();
        List<String> output = solution.findStrobogrammatic(3);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        String keys = "01689", values = "01986";
        for (int i = 0; i < keys.length(); i++) {
            map.put((keys.charAt(i)), values.charAt(i));
        }

        List<String> resultList = dfs(map, n, n);
        return resultList;
    }

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
