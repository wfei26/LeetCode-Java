import java.util.*;

public class A833_FindAndReplaceInString {
    public static void main(String[] args) {
        A833_FindAndReplaceInString solution = new A833_FindAndReplaceInString();
        String s = "vmokgggqzp";
        int[] indexes = {3,5,1};
        String [] sources = {"kg", "ggq", "mo"};
        String[] targets = {"s", "so", "bfr"};
        String output = solution.findReplaceString(s, indexes, sources, targets);
        System.out.println(output);
    }


    /**
     * Step 1: iterate through the indexes array and find out all indices that support replacement. Then, store
     * mappings from those index values to their indices in the indexes array into a map named indexValueToIndex.
     *
     * Step 2: iterate through str, at each iteration i, check whether we can perform replacement,
     * i.e., indexValueToIndex.get(i) != null,
     * if yes, append targets[i] to the StringBuilder and increase i by sources[i].length() - 1
     * if no, append str.charAt(i) and increment i
     *
     * WARNING: MUST BE CAREFUL to use i and index[i] in everywhere
     * */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S.length() == 0) {
            return S;
        }

        // store index of every index value because we want to match index of sources and targets later
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (S.startsWith(sources[i], indexes[i])) {
                map.put(indexes[i], i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length();) {
            // if need to substitute
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            }
            // if do not need to substitute
            else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
