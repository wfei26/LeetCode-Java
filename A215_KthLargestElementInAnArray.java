public class A215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        A215_KthLargestElementInAnArray solution = new A215_KthLargestElementInAnArray();
        int[] input = {3,2,3,1,2,4,5,5,6};
        int output = solution.findKthLargest(input, 4);
        System.out.println(output);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // return the index of the kth largest number
        int index = quickSelect(nums, 0, nums.length - 1, k);
        return nums[index];
    }

    public int quickSelect(int[] nums, int left, int right, int k) {
        int partitionIndex = left;
        int pivot = nums[right];
        // Standard partition process of QuickSort. It considers the last element as pivot and moves
        // all greater element to left of it and smaller elements to right
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, partitionIndex);
                partitionIndex++;
            }
        }
        // swap pivot number with the number at the current partition index
        swap(nums, partitionIndex, right);

        // count how many numbers are less than or equal to pivot from left
        int sortedLen = partitionIndex - left + 1;

        //find the current result when sorted length is equal to k
        if (sortedLen == k) {
            return partitionIndex;
        }
        // pivot is too big, so it must be on the left of partition
        else if (sortedLen > k) {
            return quickSelect(nums, left, partitionIndex - 1, k);
        }
        // pivot is too small, so it must be on the right of partition
        else {
            return quickSelect(nums, partitionIndex + 1, right, k - sortedLen);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
