public class A043_MultiplyStrings {
    public static void main(String[] args) {
        A043_MultiplyStrings solution = new A043_MultiplyStrings();
        String nums1 = "123";
        String nums2 = "456";
        String result = solution.multiply(nums1, nums2);
        System.out.println(result);
    }

    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] resultVal = new int[len1 + len2];

        int unit, tens, multiplyVal, sum;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >=0; j--) {
                tens = i + j;
                unit = i + j + 1;
                multiplyVal = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                sum = multiplyVal + resultVal[unit];
                resultVal[unit] = sum % 10;
                resultVal[tens] += sum / 10;
            }
        }

        StringBuilder resultStr = new StringBuilder();
        boolean ifLeadingZero = true;
        for (int i = 0; i < resultVal.length; i++) {
            if (resultVal[i] == 0 && ifLeadingZero) {
                continue;
            }
            else {
                resultStr.append(resultVal[i]);
                ifLeadingZero = false;
            }
        }
        if (resultStr.length() == 0) {
            return "0";
        }
        else {
            return resultStr.toString();
        }
    }
}
