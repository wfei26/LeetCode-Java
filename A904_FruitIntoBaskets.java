import java.util.HashMap;

public class A904_FruitIntoBaskets {
    public static void main(String[] args) {
        A904_FruitIntoBaskets solution = new A904_FruitIntoBaskets();
        int[] input = {3,3,3,1,2,1,1,2,3,3,4};
        int output = solution.totalFruit(input);
        System.out.println(output);
    }

    //Convert this question to "maximum sliding window that contains only two different numbers"
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }

        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < tree.length; j++) {
            //update map values
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);

            //while map contains more than 2 kinds of fruit, remove from left pointer
            //until completely remove one of the fruit
            while (map.size() > 2) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) == 0) {
                    map.remove(tree[i]);
                }
                i++;
            }

            //update max window size
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}
