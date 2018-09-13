import java.lang.reflect.Array;
import java.util.*;

public class A049_GroupAnagrams {
    public static void main(String[] args) {
        A049_GroupAnagrams solution = new A049_GroupAnagrams();
        String[] myInputs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> myResults = solution.groupAnagrams(myInputs);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println("-----------------");
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return results;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String key = new String(strArr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
