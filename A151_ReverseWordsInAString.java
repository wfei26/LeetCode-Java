public class A151_ReverseWordsInAString {
    public static void main(String[] args) {
        A151_ReverseWordsInAString solution = new A151_ReverseWordsInAString();
        String input = "the sky is         blue";
        String output = solution.reverseWords(input);
        System.out.println(output);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int n = s.length();
        char[] strArr = s.toCharArray();
        int start = 0;
        reverse(strArr, start, n - 1);
        for (int i = 0; i < n; i++) {
            if (strArr[i] == ' ') {
                reverse(strArr, start, i - 1);
                start = i + 1;
            }
        }
        reverse(strArr, start, n - 1);
        return cleanSpaces(strArr, n);
    }

    public void reverse(char[] arr, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }
}
