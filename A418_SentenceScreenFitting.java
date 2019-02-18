public class A418_SentenceScreenFitting {
    public static void main(String[] args) {
        A418_SentenceScreenFitting solution = new A418_SentenceScreenFitting();
        String[] input = {"I", "had", "apple", "pie"};
        int output = solution.wordsTyping(input, 4, 5);
        System.out.println(output);
    }

    /** We can maintain a globe variable "lenSum" to record total length from first line to last line.
     * At the beginning of every iteration, we add total column length to "lenSum", then we can keep putting
     * words in current length.
     * The key step is to check whether last character is a space or an alphabet
     * 1. if it is a space, we do not need to trace back, since we already fill partial sentence in current line
     * 2. if it is an alphabet, we need to trace back to find the most recent space position
     * Overall, "lenSum" represents total effective length (有效长度), if the rest of line does not have enough
     * spots to fill out a word, we need to trace back to decrease the effective length. It means the rest of line
     * is ineffective length, which cannot be counted in "lenSum" */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence.length == 0) {
            return 0;
        }

        // convert string array to a string sentence with space between every word
        String str = String.join(" ", sentence) + " ";
        int n = str.length();
        int lenSum = 0;
        for (int i = 0; i < rows; i++) {
            lenSum += cols;
            // if last character is space, add effective length by 1, since we put a space after input sentence before
            if (str.charAt(lenSum % n) == ' ') {
                lenSum++;
            }
            // otherwise, find the most recent space position
            else {
                // DO NOT FORGET to MOD n since we may repeat many times of entire sentence in a single line
                while (lenSum > 0 && str.charAt((lenSum - 1) % n) != ' ') {
                    lenSum--;
                }
            }
        }
        return lenSum / n;
    }
}
