public class A303_RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] inputs = {1,2,3,4,5,6};
        A303_RangeSumQueryImmutable sum = new A303_RangeSumQueryImmutable(inputs);
        int output = sum.sumRange(2, 5);
        System.out.println(output);
    }

    int[] preSum;
    public A303_RangeSumQueryImmutable(int[] nums) {
        //DO NOT FORGET to determine whether input length is 0
        if (nums.length != 0) {
            preSum = new int[nums.length];
            preSum[0] = nums[0];
            //iteratively calculate prefixSum
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return preSum[j];
        }
        return preSum[j] - preSum[i - 1];
    }
}
