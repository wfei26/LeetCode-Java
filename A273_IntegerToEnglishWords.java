public class A273_IntegerToEnglishWords {
    public static void main(String[] args) {
        A273_IntegerToEnglishWords converter = new A273_IntegerToEnglishWords();
        int input = 1234567891;
        String output = converter.numberToWords(input);
        System.out.println(output);
    }


    String[] lessThanTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String result = "";
        for (int i = 0; num > 0; i++) {
            if (num % 1000 != 0) {
                //append new string to the front of previous generated string
                result = smallNumConverter(num % 1000) + thousands[i] + " " + result;
            }
            num = num / 1000;
        }
        //DO NOT FORGET to delete space from start and end of result string
        return result.trim();
    }

    //deal with number that less than one thousand
    public String smallNumConverter(int num) {
        if (num == 0) {
            //MUST return EMPTY STRING at here, not "Zero"
            return "";
        }
        //DO NOT FORGET to add spaces for the following cases
        else if (num < 20) {
            return lessThanTwenty[num] + " ";
        }
        else if (num < 100) {
            return tens[num / 10] + " " + smallNumConverter(num % 10);
        }
        else {
            return lessThanTwenty[num / 100] + " Hundred " + smallNumConverter(num % 100);
        }
    }
}
