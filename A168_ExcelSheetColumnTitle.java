public class A168_ExcelSheetColumnTitle {
    public static void main(String[] args) {
        A168_ExcelSheetColumnTitle solution = new A168_ExcelSheetColumnTitle();
        String output = solution.convertToTitle(701);
        System.out.println(output);
    }

    /** iteratively divide by 26, and get %26 value at every iteration */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            // Because we always use 'A' + n%26, 'A' is virtually stand for 1 at here, we have to deduct 1
            // before doing this operation. eg. if n == 1, we definitely need to put A at current iteration,
            // however, 'A' + 1 will give us 'B', so we must need 'A' + 0 to get correct result.
            n--;
            // convert ASCII number to an alphabet
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
