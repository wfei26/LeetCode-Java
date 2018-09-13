public class A280_WiggleSort {
    public static void main(String[] args) {
        A280_WiggleSort solution = new A280_WiggleSort();
        int[] myInputs = {3,5,2,1,6,4};
        solution.wiggleSort(myInputs);
        for (int i = 0; i < myInputs.length; i++) {
            System.out.println(myInputs[i]);
        }
    }

    public void wiggleSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
            else {
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
