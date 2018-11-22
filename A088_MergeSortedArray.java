public class A088_MergeSortedArray {
    public static void main(String[] args) {
        A088_MergeSortedArray solution = new A088_MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.println(num);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int remainIndex = m + n - 1;
        int i = m - 1, j = n - 1;
        //append nums1 and nums2 from the end (total length of two array) of nums1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[remainIndex--] = nums1[i--];
            }
            else {
                nums1[remainIndex--] = nums2[j--];
            }
        }
        //if nums2 still have some numbers left
        //eg: nums1 = 3,5,6,0,0,0; nums2 = 1,2,3
        while (j >= 0) {
            nums1[remainIndex--] = nums2[j--];
        }
    }
}
