public class A136_SingleNumber {
    public static void main(String[] args) {
        A136_SingleNumber solution = new A136_SingleNumber();
        int[] myInput = {2,2,1};
        int myResult = solution.singleNumber(myInput);
        System.out.println(myResult);
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
