public class A393_UTF8Validation {
    public static void main(String[] args) {
        A393_UTF8Validation validation = new A393_UTF8Validation();
        int[] inputs = {197, 130, 1};
        boolean output = validation.validUtf8(inputs);
        System.out.println(output);
    }

    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }

        /*Char. number range|        UTF-8 octet sequence
        (hexadecimal)       |              (binary)
        --------------------+---------------------------------------------
        0000 0000-0000 007F | 0xxxxxxx
        0000 0080-0000 07FF | 110xxxxx 10xxxxxx
        0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
        0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx*/

        //count means how many element need to be matched after matching the first element
        int count = 0;
        for (int entry : data) {
            //firstly, we need to decide which case does the current entry belong to
            //there are four different cases in binary sequence based on problem descriptions
            if (count == 0) {
                //IMPORTANT: 0b means there are some leading zeros in binary form, and shift one digit
                //means divide by 2 in hexadecimal
                //after shifting five digits to left, whether new entry can match binary form 0b110
                if ((entry >> 5) == 0b110) {
                    count++;
                }
                else if ((entry >> 4) == 0b1110) {
                    count += 2;
                }
                else if ((entry >> 3) == 0b11110) {
                    count += 3;
                }
                //for case 1 in problem, if we shift 7 digits to left, decide if it is equal to 0
                //if not, then we cannot match the entry to any cases
                else if ((entry >> 7) != 0) {
                    return false;
                }
            }
            else {
                //all of the rest element are "10xxxxxx", so we just need to match 0b10
                //for all cases above, then decide if we could have count equals to 0 finally
                if ((entry >> 6) != 0b10) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}
