import java.util.HashSet;
import java.util.Set;

public class A414_ThirdMaximumNumber {
    public static void main(String[] args) {
        A414_ThirdMaximumNumber solution = new A414_ThirdMaximumNumber();
        int[] input = {2,2,3,1};
        int output = solution.thirdMax(input);
        System.out.println(output);
    }

    public int thirdMax(int[] nums) {
        // deduplicate by using hash set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] newNums = new int[set.size()];
        int i = 0;
        for (int key : set) {
            newNums[i] = key;
            i++;
        }
        // then use quick select to find third largest number
        return findKthLargest(newNums, 3);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
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
            if (nums[i] >= pivot) {
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
