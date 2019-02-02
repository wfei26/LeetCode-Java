public class A922_SortArrayByParityII {
    public static void main(String[] args) {
        A922_SortArrayByParityII solution = new A922_SortArrayByParityII();
        int[] input = {6,2,5,1,3,8};
        int[] output = solution.sortArrayByParityII(input);
        for (int num : output) {
            System.out.print(num + " ");
        }
    }

    /** use two pointers: evenPtr always points the first incorrect even position, oddPtr always points the first
     * incorrect odd position, swap every pair of incorrect position at the end of iteration */
    public int[] sortArrayByParityII(int[] A) {
        int evenPtr = 0, oddPtr = 1;
        while (evenPtr < A.length && oddPtr < A.length) {
            // find next incorrect even position
            while (evenPtr < A.length && A[evenPtr] % 2 == 0) {
                evenPtr += 2;
            }
            // find next incorrect odd position
            while (oddPtr < A.length && A[oddPtr] % 2 == 1) {
                oddPtr += 2;
            }
            // check the boundary and swap two incorrect positions
            if (evenPtr < A.length && oddPtr < A.length) {
                swap(A, evenPtr, oddPtr);
            }
        }
        return A;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
