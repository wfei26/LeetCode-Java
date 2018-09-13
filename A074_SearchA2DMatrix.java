public class A074_SearchA2DMatrix {
    public static void main(String[] args) {
        A074_SearchA2DMatrix solution = new A074_SearchA2DMatrix();
        int[][] myInputs = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
        int target = 3;
        boolean myResult = solution.searchMatrix(myInputs, target);
        System.out.println(myResult);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            //(mid/cols) can get the line of mid point
            //(mid%cols) can get the horizontal position of mid point
            if (matrix[mid / cols][mid % cols] < target) {
                left = mid + 1;
            }
            else if (matrix[mid / cols][mid % cols] > target) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
