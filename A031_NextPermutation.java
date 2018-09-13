import java.util.List;

public class A031_NextPermutation {
    public static void main(String[] args){
        A031_NextPermutation solution = new A031_NextPermutation();
        int[] myInputs = {1,5,8,3,7,6,5,2};
        solution.nextPermutation(myInputs);
        for (int i = 0; i < myInputs.length; i++) {
            System.out.println(myInputs[i]);
        }
    }

    public void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 2; i >= 0 && nums[i + 1] <= nums[i]; i--) {}
        if (i >= 0) {
            for (j = nums.length - 1; j >= 0 && nums[j] <= nums[i]; j--) {}
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse (int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
