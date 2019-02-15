public class A896_MonotonicArray {
    public static void main(String[] args) {
        A896_MonotonicArray solution = new A896_MonotonicArray();
        int[] input = {1,2,3,5,6};
        boolean output = solution.isMonotonic(input);
        System.out.println(output);
    }

    /** Even though the array could be monotonic, we still cannot determine if it is increasing or decreasing
     * we can use two integer flags to represent increasing status and decreasing status. Finally, if either of
     * flag is equal to array length, then the array should be monotonic */
    public boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }
        int increasing = 1;
        int decreasing = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                increasing++;
            }
            else if (A[i] < A[i - 1]) {
                decreasing++;
            }
            else {
                increasing++;
                decreasing++;
            }
        }
        return increasing == A.length || decreasing == A.length;
    }
}
