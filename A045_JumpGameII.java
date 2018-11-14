public class A045_JumpGameII {
    public static void main(String[] args) {
        A045_JumpGameII solution = new A045_JumpGameII();
        int[] input = {2,3,1,1,4};
        int output = solution.jump(input);
        System.out.println(output);
    }

    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }

        /*
        * Try to change this problem to a BFS problem, where nodes in level i are all the nodes that
        * can be reached in i-1th jump. for example. 2 3 1 1 4 , is
        * 2      level 0
        * 3 1    level 1
        * 1 4    level 2
        * clearly, the minimum jump of 4 is 2 since 4 is in level 2
        * */

        //level means current number of jumping times
        int level = 0;
        //curMaxReach means the max position we can reach for current iteration
        int curMaxReach = 0, nextMaxReach = 0;

        //since the problem assume that we can always reach the last index,
        //so we can set an infinite loop to find the correct result
        int i = 0;
        while (true) {
            level++;
            //try all possible jumping from every position less than or equal to max reach
            while (i <= curMaxReach) {
                nextMaxReach = Math.max(nextMaxReach, i + nums[i]);
                //once max reach equal to or over than last index, return current level
                if (nextMaxReach >= nums.length - 1) {
                    return level;
                }
                i++;
            }
            //update curMaxReach
            curMaxReach = nextMaxReach;
        }
    }
}
