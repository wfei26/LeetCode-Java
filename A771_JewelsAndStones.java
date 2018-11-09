import java.util.HashSet;

public class A771_JewelsAndStones {
    public static void main(String[] args) {
        A771_JewelsAndStones solution = new A771_JewelsAndStones();
        String jewels = "z";
        String stones = "ZZ";
        int myResult = solution.numJewelsInStones(jewels, stones);
        System.out.println(myResult);
    }

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }

        //use set to store jewels, and find stones in set
        HashSet<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
