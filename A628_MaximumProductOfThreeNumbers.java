public class A628_MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        A628_MaximumProductOfThreeNumbers solution = new A628_MaximumProductOfThreeNumbers();
        int[] myInputs = {1,2,3,4};
        int myResult = solution.maximumProduct(myInputs);
        System.out.println(myResult);
    }

    public int maximumProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int val : nums) {
            if (val > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = val;
            }
            else if (val > secondMax) {
                thirdMax = secondMax;
                secondMax = val;
            }
            else if (val > thirdMax) {
                thirdMax = val;
            }

            if (val < min) {
                secondMin = min;
                min = val;
            }
            else if (val < secondMin){
                secondMin = val;
            }
        }
        return Math.max(max * secondMax * thirdMax, max * min * secondMin);
    }
}
