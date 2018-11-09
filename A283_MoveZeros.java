public class A283_MoveZeros {
    public static void main(String[] args) {
        A283_MoveZeros solution = new A283_MoveZeros();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        //insert nonzero numbers to the front of array
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        //fill out the rest position to 0
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
