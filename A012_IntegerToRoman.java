public class A012_IntegerToRoman {
    public static void main(String[] args) {
        A012_IntegerToRoman solution = new A012_IntegerToRoman();
        int input = 3464;
        String myResult = solution.intToRoman(input);
        System.out.println(myResult);
    }

    /** enumerate all special numbers and roman numbers in two arrays: 1, 4, 9, 10 and all other numbers that is 10
     * times of these numbers */
    public String intToRoman(int num) {
        int[] numArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < numArr.length; i++) {
            // WARNING: MUST use while, cannot use if
            while (num >= numArr[i]) {
                num -= numArr[i];
                newStr.append(strArr[i]);
            }
        }
        return newStr.toString();
    }
}
