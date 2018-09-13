public class A006_ZigZagConversion {
    public static void main(String[] args) {
        A006_ZigZagConversion solution = new A006_ZigZagConversion();
        String myStr = "PAYPALISHIRING";
        int myRows = 4;
        String myResult = solution.convert(myStr, myRows);
        System.out.println(myResult);
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder[] newStr = new StringBuilder[numRows];
        int strLen = s.length();
        for (int i = 0; i < numRows; i++) {
            newStr[i] = new StringBuilder();
        }

        for (int i = 0; i < strLen;) {
            for (int j = 0; j < numRows && i < strLen; j++, i++) {
                newStr[j].append(s.charAt(i));
            }
            for (int j = numRows - 2; j >= 1 && i < strLen; j--, i++) {
                newStr[j].append(s.charAt(i));
            }
        }

        for (int i = 1; i < numRows; i++) {
            newStr[0].append(newStr[i]);
        }
        return newStr[0].toString();
    }
}
