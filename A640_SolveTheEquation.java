public class A640_SolveTheEquation {
    public static void main(String[] args) {
        A640_SolveTheEquation solution = new A640_SolveTheEquation();
        String res = solution.solveEquation("2x+3x-6x=x+2");
        System.out.println(res);
    }

    /** call helper function to get total count of x and sum of value on the left side of equation and right side of
     * equation, respectively. Then move all x to left side, move all num values to right side of equation.
     * The final calculation result will be rightRes[1] / leftRes[0]. eg: for 5x = 30 -> x = 30/5 */
    public String solveEquation(String equation) {
        // leftRes[0] and rightRes[0] store x count, leftRes[1] and rightRes[1] store num values
        int[] leftRes = evaluateExpression(equation.split("=")[0]);
        int[] rightRes = evaluateExpression(equation.split("=")[1]);

        // move all x to left of equation
        leftRes[0] -= rightRes[0];
        // move all number to right of equation
        rightRes[1] -= leftRes[1];

        // corner case: eg: x = x
        if (leftRes[0] == 0 && rightRes[1] == 0) {
            return "Infinite solutions";
        }

        // corner case: eg: x = x + 2
        if (leftRes[0] == 0) {
            return "No solution";
        }
        return "x=" + (rightRes[1] / leftRes[0]);
    }

    private int[] evaluateExpression(String exp) {
        // separate by + or - but include + or -, ? means one spot,
        String[] tokens = exp.split("(?=[-+])");

        // res[0] store x count, res[1] stores sum value of all numbers
        int[] res =  new int[2];

        for (String token : tokens) {
            // single x, positive
            if (token.equals("+x") || token.equals("x")) {
                res[0] += 1;
            }
            // single x, negative
            else if (token.equals("-x")) {
                res[0] -= 1;
            }
            // multiple x, eg: 2x, 5x
            else if (token.contains("x")) {
                res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            }
            // all other number values
            else {
                res[1] += Integer.parseInt(token);
            }
        }
        return res;
    }
}
