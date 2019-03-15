public class A169_MajorityElement {
    public static void main(String[] args) {
        A169_MajorityElement solution = new A169_MajorityElement();
        int[] input = {1,1,2,2,2,1,1,2};
        int res = solution.majorityElement(input);
        System.out.println(res);
    }

    /**
     * @param majorNum - current major number candidate
     * @param count - number of quota left for current candidate
     * The idea is to record a number as current candidate, once we see a number that different with candidate, we
     * cancel each other, reduce count by 1. After traversing the entire array, the last element left will be the
     * major element with highest frequency that greater than n/2
     * */
    public int majorityElement(int[] nums) {
        int majorNum = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majorNum = nums[i];
                count++;
            }
            else {
                if (nums[i] != majorNum) {
                    count--;
                }
                else {
                    count++;
                }
            }
        }
        return majorNum;
    }
}
