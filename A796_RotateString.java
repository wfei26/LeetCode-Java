public class A796_RotateString {
    public static void main(String[] args) {
        A796_RotateString solution = new A796_RotateString();
        String input1 = "abced";
        String input2 = "cedab";
        boolean output = solution.rotateString(input1, input2);
        System.out.println(output);
    }

    public boolean rotateString(String A, String B) {
        if (A.length() == 0 && B.length() == 0) {
            return true;
        }

        // append first character to end of string in every iteration
        for (int i = 0; i < A.length(); i++) {
            if (A.equals(B)) {
                return true;
            }
            A = A.substring(1) + A.substring(0, 1);
        }
        return false;
    }
}
