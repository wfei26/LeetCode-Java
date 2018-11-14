public class A055_JumpGame {
    public static void main(String[] args) {
        A055_JumpGame solution = new A055_JumpGame();
        int[] inputs = {2,2,3,1,4};
        boolean output = solution.canJump(inputs);
        System.out.println(output);
    }

    //Remark: each element in the array represents the MAXIMUM jump length at that position
    //it means we do not have to jump exact number of steps of the value in that index
    //we can jump any number of steps less than or equal to the value of each index
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        //"maxReach" represents the maximum position we can reach, which start from any position
        //The key point is that we need to maintain a starting index i, to determine
        //if i can reach the last index by setting the boundary condition "i <= maxReach"
        //eg: if we have {3,2,1,0,4}, the maxReach will always stay at 3
        int i = 0;
        for (int maxReach = 0; i < nums.length && i <= maxReach; i++) {
            maxReach = Math.max(i + nums[i], maxReach);
        }
        return i == nums.length;
    }
}
