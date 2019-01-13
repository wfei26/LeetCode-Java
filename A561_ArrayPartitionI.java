import java.util.Arrays;

public class A561_ArrayPartitionI {
    public static void main(String[] args) {
        A561_ArrayPartitionI solution = new A561_ArrayPartitionI();
        int[] input = {1,4,3,2};
        int output = solution.arrayPairSum(input);
        System.out.println(output);
    }

    // greedy algorithm: sort the array, and then every consecutive two numbers will form a pair
    // sum of all numbers in even position will be the max sum of min numbers
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
