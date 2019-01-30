public class A982_TriplesWithBitwiseANDEqualToZero {
    public static void main(String[] args) {
        A982_TriplesWithBitwiseANDEqualToZero solution = new A982_TriplesWithBitwiseANDEqualToZero();
        int[] input = {2,1,3};
        int output = solution.countTriplets(input);
        System.out.println(output);
    }

    /**
     * Brute force: similar to three sum, use three nested loop to calculate all possible three products.
     * If product is 0, then update result value according differences between each number
     *     * if three numbers are same: 1 combination
     *     * if two numbers are same: 3 combinations
     *     * if no numbers are same: 6 combinations
     * */
    public int countTriplets(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int count = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int res = A[i] & A[j] & A[k];
                    if (res == 0) {
                        if (i == k && i == j) {
                            count += 1;
                        }
                        else if (i == j || i == k || k == j) {
                            count += 3;
                        }
                        else {
                            count += 6;
                        }
                    }
                }
            }
        }
        return count;
    }
}
