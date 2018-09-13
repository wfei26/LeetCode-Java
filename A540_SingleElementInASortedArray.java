public class A540_SingleElementInASortedArray {
    public static void main(String[] args) {
        A540_SingleElementInASortedArray solution = new A540_SingleElementInASortedArray();
        int[] myInputs = {1,1,2,2,3,3,4,6,6};
        int myResult = solution.singleNonDuplicate(myInputs);
        System.out.println(myResult);
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) {
                mid--;
            }

            // We didn't find a pair. The single element must be on the left.
            // (pipes mean start & end)
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            }

            // We found a pair. The single element must be on the right.
            // Example: |1 1 3 3 5 6 6|
            //               ^ ^
            // Next:     1 1 3 3|5 6 6|
            else {
                left = mid + 2;
            }
        }
        return nums[left];
    }
}
