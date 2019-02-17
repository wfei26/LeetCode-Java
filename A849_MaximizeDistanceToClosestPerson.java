public class A849_MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        A849_MaximizeDistanceToClosestPerson solution = new A849_MaximizeDistanceToClosestPerson();
        int[] input = {1,0,0,0};
        int output = solution.maxDistToClosest(input);
        System.out.println(output);
    }

    /** we need to consider two general cases: zeros window in the middle of array and on the two sides of array
     * for the first case, we should divide length by 2, for the second case, we can use the length directly
     * then we need to iteratively update max distance */
    public int maxDistToClosest(int[] seats) {
        if (seats.length == 0) {
            return 0;
        }

        int result = 0;
        int i = 0;
        for (int j = 0; j < seats.length; j++) {
            if (seats[j] == 1) {
                // get left most zeros window if it exists
                if (i == 0) {
                    result = j - i;
                }
                else {
                    result = Math.max(result, (j - i + 1) / 2);
                }
                // once we found 1, update left pointer to start another zeros window
                i = j + 1;
            }
        }
        // compare with right most zeros window if it exists
        result = Math.max(result, seats.length - i);
        return result;
    }
}
