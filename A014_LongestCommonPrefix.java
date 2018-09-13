public class A014_LongestCommonPrefix {
    public static void main(String[] args) {
        A014_LongestCommonPrefix solution = new A014_LongestCommonPrefix();
        String[] inputs = {"flower", "flow", "flight"};
        String myResult = solution.longestCommonPrefix(inputs);
        System.out.println(myResult);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }
}
