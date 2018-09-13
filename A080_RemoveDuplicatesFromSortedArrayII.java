public class A080_RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        A080_RemoveDuplicatesFromSortedArrayII solution = new A080_RemoveDuplicatesFromSortedArrayII();
        int[] myInputs = {1,1,1,2,2,3};
        int myResult = solution.removeDuplicates(myInputs);
        System.out.println(myResult);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int countEqual = 1;
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                //reset count to 1
                countEqual = 1;
                nums[slow] = nums[fast];
                slow++;
            }
            else {
                if (countEqual < 2) {
                    nums[slow] = nums[fast];
                    slow++;
                    countEqual++;
                }
            }
        }
        return slow;
    }
}
