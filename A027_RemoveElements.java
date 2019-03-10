public class A027_RemoveElements {
    public static void main(String[] args) {
        A027_RemoveElements solution = new A027_RemoveElements();
    }

    /** Two pointer solution */
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
            }
            else {
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}
