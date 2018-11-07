import java.util.HashMap;

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

        //just use hash map to store jewels, and find jewels in stones
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : J.toCharArray()) {
            map.put(c, 1);
        }

        int count = 0;
        for (char key : S.toCharArray()) {
            if (map.containsKey(key)) {
                count++;
            }
        }
        return count;
    }
}
