public class A926_FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {
        A926_FlipStringToMonotoneIncreasing solution = new A926_FlipStringToMonotoneIncreasing();
        String input = "00110";
        int output = solution.minFlipsMonoIncr(input);
        System.out.println(output);
    }

    public int minFlipsMonoIncr(String S) {
        int n = S.length();
        // count0[i] represents number of 1's before index i
        int[] count0 = new int[n];
        // count1[j] represents number of 0's after index j
        int[] count1 = new int[n];
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            count0[i] = count0[i - 1] + (S.charAt(i - 1) == '1' ? 1 : 0);
            count1[j] = count1[j + 1] + (S.charAt(j + 1) == '0' ? 1 : 0);
        }

        int result = Integer.MAX_VALUE;
        // count minimum number of 0's and 1's we need to replace in the entire string
        for (int i = 0; i < n; i++) {
            result = Math.min(result, count0[i] + count1[i]);
        }
        return result;
    }
}
