public class A135_Candy {
    public static void main(String[] args) {
        A135_Candy solution = new A135_Candy();
        int[] input = {1,2,2};
        int output = solution.candy(input);
        System.out.println(output);
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        // use greedy algorithm to allocate candy to each child from left to right with rules
        int[] candyFromLeft = new int[n];
        candyFromLeft[0] = 1;

        // use greedy algorithm to allocate candy to each child from right to left with rules
        int[] candyFromRight = new int[n];
        candyFromRight[n - 1] = 1;

        for (int i = 1, j = n - 2; i < n; i++, j--) {
            // if current rating is greater then previous, allocate only 1 more
            if (ratings[i] > ratings[i - 1]) {
                candyFromLeft[i] = candyFromLeft[i - 1] + 1;
            }
            // if equal or less, re-assign to 1 by greedy algorithm
            else {
                candyFromLeft[i] = 1;
            }

            // similar as above
            if (ratings[j] > ratings[j + 1]) {
                candyFromRight[j] = candyFromRight[j + 1] + 1;
            }
            else {
                candyFromRight[j] = 1;
            }
        }

        // calculate max value from each position of two pre-calculated arrays
        // we can guarantee that we can satisfy these three conditions:
        // 1. Each child must have at least one candy since we at least assign 1 to any of them
        // 2. Children with a higher rating get more candies than their neighbors since we define
        // rules in previous loops
        // 3. The answer must be minimum since we use greedy algorithm to allocate candies to children
        // when we traverse from both of two directions, and then we got max from two greedy results
        // i.e. result += max(min1, min2)
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.max(candyFromLeft[i], candyFromRight[i]);
        }
        return result;
    }
}
