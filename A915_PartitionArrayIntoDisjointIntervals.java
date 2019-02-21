public class A915_PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        A915_PartitionArrayIntoDisjointIntervals solution = new A915_PartitionArrayIntoDisjointIntervals();
        int[] input = {1,1,1,0,6,12};
        int output = solution.partitionDisjoint(input);
        System.out.println(output);
    }

    /** Use an array to store curMin from right to left. Then use a constant variable to update curMax from
     * left to right, once we find curMax in index i is less than or equal to curRightMin[i + 1], we found
     * the answer */
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] curRightMin = new int[n];
        curRightMin[n - 1] = A[n - 1];

        // pre-processing
        for (int i = n - 2; i >= 0; i--) {
            curRightMin[i] = Math.min(A[i], curRightMin[i + 1]);
        }

        // find partition
        int countLeft = 1;
        int curLeftMax = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            curLeftMax = Math.max(curLeftMax, A[i]);
            if (curLeftMax <= curRightMin[i + 1]) {
                break;
            }
            countLeft++;
        }
        return countLeft;
    }
}
