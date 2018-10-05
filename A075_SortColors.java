public class A075_SortColors {
    public static void main(String[] args) {
        A075_SortColors solution = new A075_SortColors();
        int[] myInputs = {0,0,2,0,1,2,0};
        solution.sortColors(myInputs);
        for (int i = 0; i < myInputs.length; i++) {
            System.out.println(myInputs[i]);
        }
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        //set three blocks to divide three colors
        //i always points to the index of first non-zero number (divide 0 and the others)
        //j is the scanning pointer
        //k starts from end of array, and always points to first non-two number from the end (divide 2 and the others)
        for (int i = 0, j = 0, k = nums.length - 1; j <= k;) {
            //if current number is 0, swap it with ith number
            //and move both of i pointer and j pointer to right by 1
            if (nums[j] == 0) {
                swap(nums, i++, j++);
            }
            //if current number is 1, keep its position and keep traversing
            else if (nums[j] == 1) {
                j++;
            }
            //if current number is 2, swap it with kth number
            //CAUTION: do not use j++ in this condition, since we do not if we get 0 or 1 from the
            //kth position, we need to check the swapped item in next iteration
            else {
                swap(nums, j, k--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
