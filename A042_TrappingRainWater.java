public class A042_TrappingRainWater {
    public static void main(String[] args) {
        A042_TrappingRainWater container = new A042_TrappingRainWater();
        int[] inputs = {0,1,0,2,1,0,1,3,2,1,2,1};
        int output = container.trap(inputs);
        System.out.println(output);
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        //leftMax represents the highest bar from left
        int leftMax = Integer.MIN_VALUE;
        //rightMax represents the highest bar from right
        int rightMax = Integer.MIN_VALUE;

        //use two pointers to scan the entire array until they meet with each other
        for (int left = 0, right = height.length - 1; left <= right;) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                //DO NOT FORGET to minus height of current position
                result += leftMax - height[left];
                left++;
            }
            else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
