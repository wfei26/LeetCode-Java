import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A997_FindTheTownJudge {
    public static void main(String[] args) {
        A997_FindTheTownJudge solution = new A997_FindTheTownJudge();
        int[][] input = {{1,3}, {2,3}};
        int output = solution.findJudge(3, input);
        System.out.println(output);
    }

    /** The algorithm is exactly same as Q277. Find the Celebrity. The only difference is that we need to build the graph */
    /**
     * Two passes to solve the problem, kind of greedy thinking
     *
     * First pass: find the most possible candidate. Rule: if current candidate trust any person, we will change to
     * another candidate since town judge candidate CANNOT trust anyone
     *
     * Second pass: check two conditions without any exception:
     * 1. candidate does not trust anyone
     * 2. but everyone should trust candidate
     * */
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            return N;
        }

        // build graph
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : trust) {
            map.putIfAbsent(pair[0], new HashSet<>());
            map.get(pair[0]).add(pair[1]);
        }

        // first pass: find most possible candidate
        int candidate = trust[0][1];
        for (int i = 1; i < trust.length; i++) {
            if (map.containsKey(candidate)) {
                candidate = trust[i][1];
            }
        }

        // second pass: check both conditions
        for (int key : map.keySet()) {
            if (map.containsKey(candidate) || !map.get(key).contains(candidate)) {
                return -1;
            }
        }
        return candidate;
    }
}
