public class A167_TwoSumWithInputArrayIsSorted {
    public static void main(String[] args) {
        A167_TwoSumWithInputArrayIsSorted solution = new A167_TwoSumWithInputArrayIsSorted();
        int[] myInputs = {2,7,11,15};
        int target = 9;
        int[] myResults = solution.twoSum(myInputs, target);
        System.out.println(myResults[0]);
        System.out.println(myResults[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) {
            return result;
        }
        for (int small = 0, large = numbers.length - 1; small < large;) {
            if (numbers[small] + numbers[large] == target) {
                result[0] = small + 1;
                result[1] = large + 1;
                break;
            }
            else if (numbers[small] + numbers[large] > target) {
                large--;
            }
            else {
                small++;
            }
        }
        return result;
    }
}
