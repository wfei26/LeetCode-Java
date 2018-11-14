public class A665_NonDecreasingArray {
    public static void main(String[] args) {
        A665_NonDecreasingArray solution = new A665_NonDecreasingArray();
        int[] input = {4,2,3};
        boolean output = solution.checkPossibility(input);
        System.out.println(output);
    }

    /*
     * For a given array a1, a2, a3, a4, a5, assume a4 < a3. In order to achieve non-decreasing, we have to change one of value from a4 or a3. Meanwhile, for the greedy thinking, we have to minimize a4. Whether we want to change a3 or a4 is depends on value of a2
     * Assume a4 < a3, then a3 >= a2, so if a4 < a2, then we should change a4, and let a4 = a3
     * eg: 0, 3, 5, 2, 6   =>   change a4 to 5
     * Assume a4 < a3, then a3 >= a2, so if a4 >= a2, then we should change a3, but we do not have to consider this case
     * eg: 0, 2, 5, 3, 6   =>   change a3 to 3
     * The key point of two different cases above is to MINIMIZE the changing value
     * */
    public boolean checkPossibility(int[] nums) {
        if(nums.length <= 2) {
            return true;
        }

        boolean found = false;
        for (int i = 1; i < nums.length; i++) {
            //if two numbers are in invalid order
            if (nums[i] < nums[i - 1]) {
                //if already swapped before
                if (found) {
                    return false;
                }
                //eg: for the case 0, 3, 5, 2, 6, a3 > a4, and a2 > a4, change a4 to a3
                if (i >= 2 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                }
                //must in outside of if-statement
                found = true;
            }
        }
        return true;
    }
}
