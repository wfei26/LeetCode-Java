public class A556_NextGreaterElementIII {
    public static void main(String[] args) {
        A556_NextGreaterElementIII solution = new A556_NextGreaterElementIII();
        int myInput = 1;
        int myResult = solution.nextGreaterElement(myInput);
        System.out.println(myResult);
    }

    public int nextGreaterElement(int n) {
        String numStr = Integer.toString(n);
        int[] numArr = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            numArr[i] = numStr.charAt(i) - '0';
        }
        nextPermutation(numArr);
        int result = 0;
        for (int i = numArr.length - 1, j = 1; i >= 0; i--, j *= 10) {
            result += numArr[i] * j;
        }
        if (result >= Integer.MAX_VALUE || result <= n) {
            return -1;
        }
        return result;
    }

    public void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 2; i >= 0 && nums[i + 1] <= nums[i]; i--) {}
        if (i >= 0) {
            for (j = nums.length - 1; j >= 0 && nums[j] <= nums[i]; j--) {}
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse (int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
