public class A984_StringWithoutAAAOrBBB {
    public static void main(String[] args) {
        A984_StringWithoutAAAOrBBB solution = new A984_StringWithoutAAAOrBBB();
        String output = solution.strWithout3a3b(1, 3);
        System.out.println(output);
    }

    /**
     * We have three main conditions:
     * 1. when A == B, we must concat 'a' and 'b' one by one
     * 2. when A < B, we should concat one 'a' with two 'b' by greedy algorithm, since we can at most have two
     * consecutive alphabet, then we need a blocker following the consecutive two alphabets.
     * Similarly, when A > B, we should concat two 'a' with one 'b' by greedy algorithm.
     * 3. when A == 0 or B == 0, we use put the rest of 'b' or the rest of 'a' in the string
     * */
    public String strWithout3a3b(int A, int B) {
        if (A == 0 && B == 0) {
            return "";
        }

        if (A == 0) {
            return "b" + strWithout3a3b(A, B - 1);
        }
        else if (B == 0) {
            return "a" + strWithout3a3b(A - 1, B);
        }
        else if (A == B) {
            return "ab" + strWithout3a3b(A - 1, B - 1);
        }
        else if (A > B) {
            return "aab" + strWithout3a3b(A - 2, B - 1);
        }
        else {
            // WARNING: must be "bba", not "abb"
            return "bba" + strWithout3a3b(A - 1, B - 2);
        }
    }
}
