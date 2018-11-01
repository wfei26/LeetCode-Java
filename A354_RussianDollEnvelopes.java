import java.util.Arrays;

public class A354_RussianDollEnvelopes {
    public static void main(String[] args) {
        A354_RussianDollEnvelopes solution = new A354_RussianDollEnvelopes();
        int[][] inputs = {{5,4},{6,4},{6,7},{2,3}};
        int output = solution.maxEnvelopes(inputs);
        System.out.println(output);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        //sort envelopes by width (envelopes[i][0]), then we only need to consider height
        //if two envelopes have same width, sort them by descending order
        //because [3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting,
        //otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
        //but we actually do not want to count them as valid russian doll envelopes
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            else {
                return a[0] - b[0];
            }
        });

        int n = envelopes.length;
        int[] tails = new int[n];
        int result = 0;

        //KEY POINTS: after sorting them by width with increasing order, we need to find Longest Increasing Subsequence
        //by traversing height of each envelope, then we get the final result
        //store tails of each increasing subsequence with different length
        /*eg: 3, 5, 1, 8, 2, 12
         * 1
         * 1, 2
         * 3, 5, 8
         * 3, 5, 8, 12
         * tails = {1, 2, 8, 12}
         */
        //we do not care about what elements are in each subsequence, we only care about
        //tails of them, because every time we only compare with their tails to decide
        //which subsequence could we add new item and update the entire structure
        for (int[] envelope : envelopes) {

            //Use binary search to find the correct tail for new item
            //KEY POINTS: find the smallest ceiling of every new number from the existed tails
            //and replace that ceiling number with new number
            //CORNER CASE: left == right at the first iteration, then tails[0] = envelope[0][1]
            //so do not need to worry about the tails array does not have any items
            //CAUTION: DO NOT INITIALIZE right pointer as "envelopes.length - 1", because we need to
            //adopt Binary Search in tails array, NOT the input array
            int left = 0, right = result;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < envelope[1]) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }

            //update tails of current subsequence with length of left + 1
            tails[left] = envelope[1];
            //if updated subsequence is the longest one, increase result size by 1
            if (left == result) {
                result++;
            }
        }
        return result;
    }
}
