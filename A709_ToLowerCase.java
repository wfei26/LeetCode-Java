public class A709_ToLowerCase {
    public static void main(String[] args) {
        A709_ToLowerCase solution = new A709_ToLowerCase();
        String output = solution.toLowerCase("HeLLo");
        System.out.println(output);
    }

    /** Each upper case letter has 32 difference with its corresponding lower case letter in ASCII table */
    public String toLowerCase(String str) {
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
                charArr[i] += 32;
            }
        }
        return new String(charArr);
    }
}
