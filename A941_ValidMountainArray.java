public class A941_ValidMountainArray {
    public static void main(String[] args) {
        A941_ValidMountainArray solution = new A941_ValidMountainArray();
        int[] input = {1,2,2};
        boolean output = solution.validMountainArray(input);
        System.out.println(output);
    }

    public boolean validMountainArray(int[] A) {
        int i;
        if (A.length < 3) {
            return false;
        }

        // check all element with ascending order until reach the peak point
        // valid rule: A[i] > A[i - 1]
        for (i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                break;
            }
        }

        // if the first two elements are not ascending order or the last two elements are not descending order
        // the array must be invalid mountain array
        if (i == 1 || i == A.length) {
            return false;
        }

        // check all elements with descending order, if there exists an element violate the monotonic rule
        // return false directly
        // valid rule: A[i] < A[i - 1]
        for (; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
