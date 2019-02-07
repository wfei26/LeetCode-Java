public class A365_WaterAndJugProblem {
    public static void main(String[] args) {
        A365_WaterAndJugProblem solution = new A365_WaterAndJugProblem();
        boolean output = solution.canMeasureWater(2, 6, 8);
        System.out.println(output);
    }

    /**
     * The basic idea is to use the property of Bézout's identity and check if z is a multiple of GCD(x, y)
     * eg: x = 4, y = 6, z = 8.
     * GCD(4, 6) = 2, and 8 is multiple of 2, so this input is valid and we have:
     * -1 * 4 + 6 * 2 = 8
     * In this case, there is a solution obtained by filling the 6 gallon jug twice and emptying the 4 gallon jug once.
     * (Solution. Fill the 6 gallon jug and empty 4 gallons to the 4 gallon jug. Empty the 4 gallon jug. Now empty the
     * remaining two gallons from the 6 gallon jug to the 4 gallon jug. Next refill the 6 gallon jug. This gives 8
     * gallons in the end)
     * */
    public boolean canMeasureWater(int x, int y, int z) {
        // sum of two barrels must greater than or equal to z
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        // check if z is divisible by GCD of x and y
        return z % GCD(x, y) == 0;
    }

    /**
     * IMPORTANT: calculate GCD
     * Basic Euclidean Algorithm for GCD: the algorithm is based on below facts.
     * If we subtract smaller number from larger (we reduce larger number), GCD doesn’t change. So if we keep
     * subtracting repeatedly the larger of two, we end up with GCD.
     * Now instead of subtraction, if we divide smaller number, the algorithm stops when we find remainder 0.
     * */
    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
