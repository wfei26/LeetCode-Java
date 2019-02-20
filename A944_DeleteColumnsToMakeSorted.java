public class A944_DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        A944_DeleteColumnsToMakeSorted solution = new A944_DeleteColumnsToMakeSorted();
        String[] input = {"cba","daf","ghi"};
        int output = solution.minDeletionSize(input);
        System.out.println(output);
    }

    public int minDeletionSize(String[] A) {
        if (A.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                // once we find violation of current column, break the loop, then check next column
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
