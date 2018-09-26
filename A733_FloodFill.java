public class A733_FloodFill {
    public static void main(String[] args) {
        A733_FloodFill solution = new A733_FloodFill();
        int[][] inputs = {{1,1,1},
                          {1,1,0},
                          {1,0,1}};
        int[][] outputs = solution.floodFill(inputs, 1, 1, 2);
        for (int[] rows : outputs) {
            for (int col : rows) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oriColor = image[sr][sc];
        //DO NOT FORGET to check if new color is as same as current color in starting point
        //Otherwise, we will have infinite recursion call, then STACK OVERFLOW!!!
        if (oriColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, oriColor, newColor);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int oriColor, int newColor) {
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length && image[sr][sc] == oriColor) {
            image[sr][sc] = newColor;
        }
        else {
            return;
        }
        dfs(image, sr - 1, sc, oriColor, newColor);
        dfs(image, sr + 1, sc, oriColor, newColor);
        dfs(image, sr, sc + 1, oriColor, newColor);
        dfs(image, sr, sc - 1, oriColor, newColor);
    }
}
