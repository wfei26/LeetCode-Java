import java.util.ArrayList;
import java.util.List;

public class A763_PartitionLabels {
    public static void main(String[] args) {
        A763_PartitionLabels solution = new A763_PartitionLabels();
        String myInput = "caedbdedda";
        List<Integer> myResults = solution.partitionLabels(myInput);
        for (int item : myResults) {
            System.out.println(item);
        }
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> results = new ArrayList<>();
        if (S == null) {

        }

        int len = S.length();
        char[] strArr = S.toCharArray();

        //use a hash map to record the last index of each character
        int[] map = new int[26];
        for (int i = 0; i < len; i++) {
            map[strArr[i] - 'a'] = i;
        }

        int last = 0;
        for (int left = 0, right = 0; right < len; right++) {
            //"last" can record the most possible tail of a partition
            //since "last" always saves the max index of last occurrence of
            //all visited character, it can guarantee that there does not
            //have any same character after current window when last == right
            last = Math.max(last, map[strArr[right] - 'a']);
            if (last == right) {
                results.add(right - left + 1);
                left = right + 1;
            }
        }
        return results;
    }
}
