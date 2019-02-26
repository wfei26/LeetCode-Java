public class A137_SingleNumberII {
    public static void main(String[] args) {
        A137_SingleNumberII solution = new A137_SingleNumberII();
        int[] input = {2,2,3,2};
        int output = solution.singleNumber(input);
        System.out.println(output);
    }

    /** There are only 32 bits for a number in Java. We can traverse all numbers and count number of 1's in every
     * bit index (totally 32). If number of 1's in current bit index can be divided by 3, then current bit index
     * must not be the effective index of that single number. So we only need to find those bit index that have
     * countBit % 3 != 0, it will be the result single number. */
    public int singleNumber(int[] nums) {
        int result = 0;
        int occurTime = 3;
        for (int i = 0; i < 32; i++) {
            int countBit = 0;
            int curIndex = 1 << i;
            for (int num : nums) {
                // WARNING: we CANNOT use (num & curIndex) == 1 at here, because we want to determine whether
                // current bit index is 0 or not, but "== 1" means if current number is equal to number 1 (bit: 01)
                if ((num & curIndex) != 0) {
                    countBit++;
                }
            }
            if (countBit % occurTime != 0) {
                result |= curIndex;
            }
        }
        return result;
    }
}
