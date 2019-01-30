import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A271_EncodeAndDecodeStrings {
    public static void main(String[] args) {
        A271_EncodeAndDecodeStrings solution = new A271_EncodeAndDecodeStrings();
        List<String> input = new ArrayList<>(Arrays.asList("i", "love", "leetcode"));
        String encodeStr = solution.encode(input);
        List<String> decodeStr = solution.decode(encodeStr);
        for (String str : decodeStr) {
            System.out.println(str);
            //System.out.println(1);
        }
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("@").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // returns the index within this string of the first occurrence of the specified substring,
            // starting at the specified index
            int indexOfAt = s.indexOf('@', i);

            // get length of current word
            int wordLen = Integer.valueOf(s.substring(i, indexOfAt));

            // get right bound index of current word
            i = indexOfAt + wordLen + 1;

            // get current word by getting substring from @ + 1 to updated i position
            result.add(s.substring(indexOfAt + 1, i));
        }
        return result;
    }
}
