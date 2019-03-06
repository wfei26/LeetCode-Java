public class A031_NextPermutation {
    public static void main(String[] args){
        A031_NextPermutation solution = new A031_NextPermutation();
        int[] myInputs = {1,5,8,3,7,6,5,2};
        solution.nextPermutation(myInputs);
        for (int i = 0; i < myInputs.length; i++) {
            System.out.println(myInputs[i]);
        }
    }

    /**
     * Step 1: start from the last index, compare every pair of numbers, find the position where the left number is
     * smaller than right number, represented by "firstSmaller"
     *
     * Step 2: start from the last index again, find the first number that greater than num[firstSmaller], then we
     * can swap numbers in firstSmaller and firstGreater
     *
     * Step 3: reverse the part of array after index "firstSmaller", since the changing part of next permutation
     * should be in ascending order
     * */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        // step 1: find the first smaller number from the end
        int firstSmaller = n - 2;
        while (firstSmaller >= 0 && nums[firstSmaller] >= nums[firstSmaller + 1]) {
            firstSmaller--;
        }

        // step 2: if it is not the case like "5,4,3,2,1", we need to swap two numbers
        if (firstSmaller >= 0) {
            int firstGreater = n - 1;
            while (firstGreater > firstSmaller && nums[firstGreater] <= nums[firstSmaller]) {
                firstGreater--;
            }
            swap(nums, firstSmaller, firstGreater);
        }

        // step 3: reverse the right changing part
        for (int i = firstSmaller + 1, j = n - 1; i < j; i++, j--) {
            swap(nums, i , j);
        }
    }

    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
