public class A344_ReverseString {
    public static void main(String[] args) {
        A344_ReverseString solution = new A344_ReverseString();
        String myStr = "abcdefg";
        String result = solution.reverseString(myStr);
        System.out.println(result);
    }

    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] strArr = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            swap(strArr, i, j);
        }
        return new String(strArr);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
