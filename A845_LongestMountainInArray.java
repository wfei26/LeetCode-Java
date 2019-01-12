public class A845_LongestMountainInArray {
    public static void main(String[] args) {
        A845_LongestMountainInArray solution = new A845_LongestMountainInArray();
        int[] input = {2,2,2};
        int output = solution.longestMountain(input);
        System.out.println(output);
    }

    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int maxRes = 0;
        int n = A.length;
        for (int left = 1, right = 1; left < n;) {
            // skip all invalid sequences, and then set left most pointer of next valid mountain sequence
            while (left < n && A[left] <= A[left - 1]) {
                left++;
            }

            // find peak element (mountain top)
            right = left + 1;
            while (right < n && A[right] > A[right - 1]) {
                right++;
            }

            // update max length until reach the right bound of mountain sequence
            while (right < n && A[right] < A[right - 1]) {
                right++;
                // ONLY if we find the valid mountain sequence, we can update max length
                // so DO NOT put this line in outside of inner while loop
                maxRes = Math.max(maxRes, right - left + 1);
            }
            // reset left pointer
            left = right;
        }
        return maxRes;
    }
}
