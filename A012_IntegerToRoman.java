public class A012_IntegerToRoman {
    public static void main(String[] args) {
        A012_IntegerToRoman solution = new A012_IntegerToRoman();
        int input = 3464;
        String myResult = solution.intToRoman(input);
        System.out.println(myResult);
    }

    public String intToRoman(int num) {
        int[] numArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < numArr.length; i++) {
            while (num >= numArr[i]) {
                num -= numArr[i];
                newStr.append(strArr[i]);
            }
        }
        return newStr.toString();
    }
}
