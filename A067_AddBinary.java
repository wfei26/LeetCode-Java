public class A067_AddBinary {
    public static void main(String[] args) {
        A067_AddBinary solution = new A067_AddBinary();
        String a = "1010";
        String b = "1011";
        String myResult = solution.addBinary(a, b);
        System.out.println(myResult);
    }

    public String addBinary(String a, String b) {
        StringBuilder newStr = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            newStr.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            newStr.append(carry);
        }
        return newStr.reverse().toString();
    }
}
