public class A066_PlusOne {
    public static void main(String[] args) {
        A066_PlusOne solution = new A066_PlusOne();
        int[] myArr = {9,9,9,9};
        int[] resultArr = solution.plusOne(myArr);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i]);
        }
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
