public class A067_AddBinary {
    public static void main(String[] args) {
        A067_AddBinary solution = new A067_AddBinary();
        String a = "1010";
        String b = "1011";
        String myResult = solution.addBinary(a, b);
        System.out.println(myResult);
    }

    public String addBinary(String a, String b) {
        int sum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;) {
            sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            // WARNING: MUST get carry firstly, and then update sum secondly
            carry = sum / 2;
            sum = sum % 2;
            sb.append(sum);
        }
        // corner case: the last adding still generate non-zero carry
        if (carry != 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
