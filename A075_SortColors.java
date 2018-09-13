public class A075_SortColors {
    public static void main(String[] args) {
        A075_SortColors solution = new A075_SortColors();
        int[] myInputs = {2,0,2,1,1,0};
        solution.sortColors(myInputs);
        for (int i = 0; i < myInputs.length; i++) {
            System.out.println(myInputs[i]);
        }
    }

    public void sortColors(int[] nums) {
        int curIndex0 = 0, curIndex1 = 0, curIndex2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[curIndex2++] = 2;
                nums[curIndex1++] = 1;
                nums[curIndex0++] = 0;
            }
            else if (nums[i] == 1) {
                nums[curIndex2++] = 2;
                nums[curIndex1++] = 1;
            }
            else {
                nums[curIndex2++] = 2;
            }
        }
    }
}
