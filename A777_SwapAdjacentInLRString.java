public class A777_SwapAdjacentInLRString {
    public static void main(String[] argd) {
        A777_SwapAdjacentInLRString solution = new A777_SwapAdjacentInLRString();
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        boolean output = solution.canTransform(start, end);
        System.out.println(output);
    }

    /*
    * We can always swap RX to XR, and XL to LX. However, we CANNOT swap RL or LR
    * So we can use two counters to count how many L and R we need to match from start string
    * to end string. Meanwhile, once we see L or R, we need to reset rCount or lCount, respectively.
    * Because L or R cannot pass to each other.
    * */
    public boolean canTransform(String start, String end) {
        int lCount = 0, rCount = 0;
        for (int i = 0; i < start.length(); i++) {
            // count left movement needed
            if (start.charAt(i) == 'L') {
                lCount--;
                rCount = 0;
            }
            // match right movement
            /*
            * eg: if we use rCount-- in start string, we will return false for this case
            * RXX
            * XXR
            * */
            else if (start.charAt(i) == 'R') {
                rCount++;
                lCount = 0;
            }
            // match left movement
            if (end.charAt(i) == 'L') {
                lCount++;
                rCount = 0;
            }
            // count right movement needed
            else if (end.charAt(i) == 'R') {
                rCount--;
                lCount = 0;
            }

            // once we find left movement needed or right movement needed is less than 0
            // return false directly because we don't have enough quota of L or R in end string
            if (lCount < 0 || rCount < 0) {
                return false;
            }
        }
        return lCount == 0 && rCount == 0;
    }
}
