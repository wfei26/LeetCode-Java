import java.util.HashMap;

public class A454_4SumII {
    public static void main(String[] args) {
        A454_4SumII solution = new A454_4SumII();
        int[] a = {1,2};
        int[] b = {-2,-1};
        int[] c = {-1,2};
        int[] d = {0,2};
        int myResult = solution.fourSumCount(a, b, c, d);
        System.out.println(myResult);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return 0;
        }

        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(0 - sum)) {
                    result += map.get(0 - sum);
                }
            }
        }
        return result;
    }
}
