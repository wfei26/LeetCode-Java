public class A415_AddStrings {
    public static void main(String[] args) {
        A415_AddStrings solution = new A415_AddStrings();
        String a = "234";
        String b = "432";
        String myResult = solution.addStrings(a, b);
        System.out.println(myResult);
    }

    public String addStrings(String num1, String num2) {
        StringBuilder newStr = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0;) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            newStr.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            newStr.append(carry);
        }
        return newStr.reverse().toString();
    }
}
