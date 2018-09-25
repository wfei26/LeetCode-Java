public class A069_SqrtX {
    public static void main(String[] args) {
        A069_SqrtX solution = new A069_SqrtX();
        int input = 2;
        int output = solution.mySqrt(input);
        System.out.println(output);
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        //define x / 2 as right bound of binary search is because
        //the square root of x should not greater than x/2
        int left = 1, right = x / 2;
        while(true) {
            int mid = left + (right - left) / 2;
            //when current mid is greater than x/mid
            //we still need find smaller number
            if (mid > x / mid) {
                right = mid - 1;
            }
            //we do not use mid > x/mid or mid < x/mid as exit is because
            //both of two conditions does not satisfy the expected result
            //but use mid + 1 is correct
            else if ((mid + 1) > x / (mid + 1)) {
                return mid;
            }
            //otherwise, increase left bound
            else {
                left = mid + 1;
            }
        }
    }
}
