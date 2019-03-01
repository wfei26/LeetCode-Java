import java.util.Random;
import java.util.TreeMap;

public class A528_RandomPickWithWeight {
    public static void main(String[] args) {
        int[] input = new int[]{1,3};
        A528_RandomPickWithWeight solution = new A528_RandomPickWithWeight(input);
    }

    /** Accumulate weight of each index value, and put into a treeMap. Then we will have a tree map with all keys
     * in range [0, sum]. We can random a number from [0, sum - 1], and get higherKey() of random number in treeMap
     * higherKey() will return a key that STRICTLY greater than given input */
    TreeMap<Integer, Integer> treeMap;
    int sum = 0;
    public A528_RandomPickWithWeight(int[] w) {
        treeMap = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            treeMap.put(sum, i);
        }
    }

    public int pickIndex() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(sum);
        int key = treeMap.higherKey(randomIndex);
        return treeMap.get(key);
    }
}
