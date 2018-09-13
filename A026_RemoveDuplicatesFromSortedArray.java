public class A026_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        A026_RemoveDuplicatesFromSortedArray solution = new A026_RemoveDuplicatesFromSortedArray();
        int[] myInputs = {0,0,1,1,1,2,2,3,3,4};
        int myResult = solution.removeDuplicates(myInputs);
        System.out.println(myResult);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
