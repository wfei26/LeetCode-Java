public class A151_ReverseWordsInAString {
    public static void main(String[] args) {
        A151_ReverseWordsInAString solution = new A151_ReverseWordsInAString();
        String input = "the   sky     is         blue";
        String output = solution.reverseWords(input);
        System.out.println(output);
    }

    /**
     * Step 1: reverse the entire sentence
     * Step 2: reverse words in the sentence
     * Step 3: remove duplicate spaces at leading, trailing and inside the sentence
     * */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int n = s.length();
        char[] strArr = s.toCharArray();
        int start = 0;

        // step 1
        reverse(strArr, start, n - 1);

        // step 2
        for (int i = 0; i < n; i++) {
            if (strArr[i] == ' ') {
                // when there are consecutive spaces between two words, the reverse function will automatically
                // skip these spaces since start > i - 1 in these conditions
                reverse(strArr, start, i - 1);
                start = i + 1;
            }
        }
        // WARNING: DO NOT FORGET to reverse the last word after jumping out the loop
        reverse(strArr, start, n - 1);

        // step 3
        return cleanSpaces(strArr, n);
    }

    public void reverse(char[] arr, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // trim leading, trailing and multiple spaces by using array 覆盖式写法
    String cleanSpaces(char[] arr, int n) {
        // left pointer trace the new array that removed spaces, right pointer trace the original array with spaces
        int left = 0, right = 0;

        while (right < n) {
            while (right < n && arr[right] == ' ') {
                right++; // skip spaces
            }

            while (right < n && arr[right] != ' ') {
                arr[left++] = arr[right++]; // keep non spaces
            }

            while (right < n && arr[right] == ' ') {
                right++; // skip spaces
            }

            if (right < n) {
                arr[left++] = ' '; // keep only one space
            }
        }

        return new String(arr).substring(0, left);
    }
}
