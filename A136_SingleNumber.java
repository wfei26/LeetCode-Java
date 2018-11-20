public class A136_SingleNumber {
    public static void main(String[] args) {
        A136_SingleNumber solution = new A136_SingleNumber();
        int[] myInput = {4,1,2,3,1,2,3};
        int myResult = solution.singleNumber(myInput);
        System.out.println(myResult);
    }

    /*
    * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
    * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
    * = 0 ^ 0 ^ ..........^ 0 ^ N
    * = N
    * */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
