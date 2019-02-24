public class A717_1BitAnd2BitCharacters {
    public static void main(String[] args) {
        A717_1BitAnd2BitCharacters solution = new A717_1BitAnd2BitCharacters();
        int[] input = {1,1,1,0};
        boolean output = solution.isOneBitCharacter(input);
        System.out.println(output);
    }

    /** The rule is that for every starting 1, we need to pair it; but for every starting 0, we cannot pair it.
     * We can traverse the array until reach the last number. If the pointer stays on last position, then it must
     * be true. Otherwise, it must over the boundary because of executing i += 2 statement at the last iteration */
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        // two possible exit condition: i == n - 1 or i == n
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i += 1;
            }
            else {
                i += 2;
            }
        }
        return i == bits.length - 1;
    }
}
