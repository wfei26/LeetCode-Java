public class A050_PowXN {
    public static void main(String[] args) {
        A050_PowXN solution = new A050_PowXN();
        double base = 2;
        int pow = 10;
        double output = solution.myPow(base, pow);
        System.out.println(output);
    }

    public double myPow(double x, int n) {
        //corner case
        if (n == Integer.MIN_VALUE && x != 1 && x != -1) {
            return 0;
        }
        //recursion exit: when pow is equal to 0
        if (n == 0) {
            return 1;
        }

        //if pow < 0, deal with this special case
        //eg: 2^-3 = (1/2)^3  =>  pow = -pow & base = 1/base
        if (n < 0) {
            n = -n;
            x = 1/x;
        }

        //recursively divide power by 2, which means multiply x^2 in every recursive call
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        //if current pow is odd number, multiply additional base number
        //eg: if pow = 15, pow / 2 = 7, but we need to have the result (base^2)^7 * base
        else {
            return myPow(x * x, n / 2) * x;
        }
    }
}
