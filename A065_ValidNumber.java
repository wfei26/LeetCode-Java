public class A065_ValidNumber {
    public static void main(String[] args) {
        A065_ValidNumber soliution = new A065_ValidNumber();
        String input = ". 1";
        boolean output = soliution.isNumber(input);
        System.out.println(output);
    }

    public boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        // WARNING: DO NOT FORGET to remove space at front and end of string
        s = s.trim();

        boolean seenNumber = false;
        boolean seenPower = false;
        boolean numberExistAfterPower = true; // initialize to true, in case if we do not have 'e' in string
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                seenNumber = true;
                numberExistAfterPower = true;
            }

            // only valid if we have not seen dot and see 'e'
            else if (s.charAt(i) == '.') {
                if (seenDot || seenPower) {
                    return false;
                }
                seenDot = true;
            }

            // on valid if we have already seen number or never seen 'e'
            else if (s.charAt(i) == 'e') {
                if (seenPower || !seenNumber) {
                    return false;
                }
                seenPower = true;
                // DO NOT FORGET to reset this variable because we need to check whether still exists numbers after 'e'
                numberExistAfterPower = false;
            }

            // only first position or first position after 'e' can have operand '-' or '+'
            else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return seenNumber && numberExistAfterPower;
    }
}
