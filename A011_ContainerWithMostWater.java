public class A011_ContainerWithMostWater {
    public static void main(String[] args) {
        A011_ContainerWithMostWater solution = new A011_ContainerWithMostWater();
        int[] inputs = {1,8,6,2,5,4,8,3,7};
        int output = solution.maxArea(inputs);
        System.out.println(output);
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int n = height.length;
        //left pointer points to the left most bar, right pointer points to the right most bar
        //Always move the pointer with shorter length, since how much water is depends on the short bar
        //木桶原理
        for (int i = 0, j = n - 1; i < j;) {
            //re-calculate area in every iteration
            result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            //if the left bar length is shorter, move the left pointer by 1
            if (height[i] < height[j]) {
                i++;
            }
            //if the right bar length is smaller or equal, move the right pointer by 1
            else {
                j--;
            }
        }
        return result;
    }
}
