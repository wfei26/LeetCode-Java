import java.util.Arrays;

public class A455_AssignCookies {
    public static void main(String[] args) {
        A455_AssignCookies solution = new A455_AssignCookies();
        int[] children = {1,2};
        int[] cookie = {1,2,3};
        int output = solution.findContentChildren(children, cookie);
        System.out.println(output);
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        for (int i = 0; i < s.length && result < g.length; i++) {
            // if candy[i] >= children[result]
            if (s[i] >= g[result]) {
                result++;
            }
        }
        return result;
    }
}
