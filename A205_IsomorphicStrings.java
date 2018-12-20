public class A205_IsomorphicStrings {
    public static void main(String[] args) {
        A205_IsomorphicStrings solution = new A205_IsomorphicStrings();
        String input1 = "paper", input2 = "title";
        boolean output = solution.isIsomorphic(input1, input2);
        System.out.println(output);
    }

    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) {
                return false;
            }
            // corner case: we cannot use use i as map value
            // if value is i, then 0 will have trivial meaning: first position or never traversed
            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
