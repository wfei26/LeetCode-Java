import java.util.Arrays;

public class A324_WiggleSortII {
    public static void main(String[] args) {
        A324_WiggleSortII solution = new A324_WiggleSortII();
        int[] myInputs = {1,1,2,1,2,2,1};
        solution.wiggleSort(myInputs);
        for (int i = 0; i < myInputs.length; i++) {
            System.out.println(myInputs[i]);
        }
    }

    public void wiggleSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int[] sortedArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedArr[i] = nums[i];
        }
        Arrays.sort(sortedArr);
        for (int i = nums.length - 1, j = 0, k = i / 2 + 1; i >= 0; i--) {
            if (i % 2 == 1) {
                nums[i] = sortedArr[k++];
            }
            else {
                nums[i] = sortedArr[j++];
            }
        }
    }
}
