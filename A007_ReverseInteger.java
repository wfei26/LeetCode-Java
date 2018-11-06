public class A007_ReverseInteger {
    public static void main(String[] args) {
        A007_ReverseInteger solution = new A007_ReverseInteger();
        int myResult = solution.reverse(1534236469);
        System.out.println("The result is: " + myResult);
    }

    public int reverse(int x) {
        int result = 0;

        //iteratively get last digit of the rest of number 
        for (; x != 0; x /= 10) {
            int lastDigit = x % 10;
            //new number is equal to previous * 10 + current last digit
            int newNumber = result * 10 + lastDigit;

            //check if new integer over than bound
            if ((newNumber - lastDigit) / 10 != result) {
                return 0;
            }
            result = newNumber;
        }

        return result;
    }
}
