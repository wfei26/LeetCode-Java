public class A069_SqrtX {
    public static void main(String[] args) {
        A069_SqrtX solution = new A069_SqrtX();
        int input = 1;
        int output = solution.mySqrt(input);
        System.out.println(output);
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int result = 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if mid is not greater than x/mid, result could be in this range
            // since our mid value is left bias
            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;
            }
            // if mid is greater than x/mid, result will never in the range
            // between mid to x
            // eg: x = 160, mid = 16, x/mid = 10, result should less than 16
            else {
                right = mid - 1;
            }
        }
        return result;
    }
}
