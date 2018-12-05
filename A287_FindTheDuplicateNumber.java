public class A287_FindTheDuplicateNumber {
    public static void main(String[] args) {
        A287_FindTheDuplicateNumber solution = new A287_FindTheDuplicateNumber();
        int[] input = {1,3,4,2,2};
        int output = solution.findDuplicate(input);
        System.out.println(output);
    }

    public int findDuplicate(int[] nums) {
        // corner case: array must contain at least two numbers
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        /*
        * Use input array to simulate a linked list, and find starting point of cycle in linked list
        * eg: for array [1,3,4,2,2]
        * index: 0, 1, 2, 3, 4
        * value: 1, 3, 4, 2, 2
        * linked list: 0 -> 1 -> 3 -> 2 -> 4 -> 2 -> 4 -> 2 ->...
        * So the starting point of linked list cycle is 2
        * */

        // initialize slow and fast pointer as two different value is because we want to escape from
        // the while loop exit condition slow == fast
        int slow = nums[0];
        int fast = nums[nums[0]];

        // determine the meeting point of slow and fast pointer
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // assume length of start position of linked list to starting point of cycle is l1
        // then the slow pointer will travel another l1 distance to arrive the starting point of cycle
        // so reset fast pointer to 0, until they meet again to find the starting point of cycle
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
