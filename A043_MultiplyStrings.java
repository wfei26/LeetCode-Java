public class A043_MultiplyStrings {
    public static void main(String[] args) {
        A043_MultiplyStrings solution = new A043_MultiplyStrings();
        String nums1 = "123";
        String nums2 = "456";
        String result = solution.multiply(nums1, nums2);
        System.out.println(result);
    }

    /** Use brute force to traverse every single digit of the input numbers, and multiply each single digit one by one.
     * For example, if I multiply a number ins num1[i] and a number in num2[j], then the unit index will be i + j + 1,
     * the tens index will be i + j (draw hte multiplication diagram to get the index). */
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] numArr = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int unitIndex = i + j + 1;
                int tensIndex = i + j;
                // get sum for current multiplication step
                int sum = numArr[unitIndex] + multiply;

                // WARNING: unit digit will be a new number, but tens digit must be accumulation with previous value
                numArr[unitIndex] = sum % 10;
                numArr[tensIndex] += sum / 10;
            }
        }

        // WARNING: DO NOT FORGET to delete all leading zeros in result num
        StringBuilder sb = new StringBuilder();
        boolean isLeadingZero = true;
        for (int digit : numArr) {
            if (digit == 0 && isLeadingZero) {
                continue;
            }
            else {
                isLeadingZero = false;
                sb.append(digit);
            }
        }
        // corner case: if result is equal to 0
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
