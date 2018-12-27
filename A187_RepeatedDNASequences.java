import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A187_RepeatedDNASequences {
    public static void main(String[] args) {
        A187_RepeatedDNASequences solution = new A187_RepeatedDNASequences();
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> output = solution.findRepeatedDnaSequences(input);
        for (String s : output) {
            System.out.println(s);
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }

        Set<String> cache = new HashSet<>();
        Set<String> result = new HashSet<>();
        // keep a window with size 10, and then check if we have seen current substring before
        for (int i = 0; i < s.length() - 9; i++) {
            String curStr = s.substring(i, i + 10);
            if (!cache.add(curStr)) {
                result.add(curStr);
            }
        }
        // IMPORTANT: convert a set to an array list directly
        return new ArrayList<>(result);
    }
}
