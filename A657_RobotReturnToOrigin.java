public class A657_RobotReturnToOrigin {
    public static void main(String[] args) {
        A657_RobotReturnToOrigin solution = new A657_RobotReturnToOrigin();
        String inputs = "UD";
        boolean output = solution.judgeCircle(inputs);
        System.out.println(output);
    }

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }

        int countLR = 0, countUD = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                countUD++;
            }
            else if (move == 'D') {
                countUD--;
            }
            else if (move == 'L') {
                countLR++;
            }
            else {
                countLR--;
            }
        }
        return countLR == 0 && countUD == 0;
    }
}
