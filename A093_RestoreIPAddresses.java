import java.util.ArrayList;
import java.util.List;

public class A093_RestoreIPAddresses {
    public static void main(String[] args) {
        A093_RestoreIPAddresses solution = new A093_RestoreIPAddresses();
        String input = "010010";
        List<String> output = solution.restoreIpAddresses(input);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if (s == null) {
            return results;
        }

        // try all possible separations for four sub-domains
        // kind of brute force, but in O(1) since four loops are all in constant boundary
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    for (int h = 1; h <= 3; h++) {
                        // if total length of four sub-domains are same as string length
                        if (i + j + h + k == s.length()) {
                            int A = Integer.valueOf(s.substring(0, i));
                            int B = Integer.valueOf(s.substring(i, i + j));
                            int C = Integer.valueOf(s.substring(i + j, i + j + h));
                            int D = Integer.valueOf(s.substring(i + j + h, i + j + h + k));

                            // if four numbers are all less than or equal to 255
                            if (A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(Integer.toString(A));
                                sb.append(".").append(Integer.toString(B));
                                sb.append(".").append(Integer.toString(C));
                                sb.append(".").append(Integer.toString(D));
                                // DO NOT FORGET to check string length again to avoid adding invalid corner case
                                // eg: 0.01.001.0 cannot have preceding 0
                                if (sb.toString().length() == s.length() + 3) {
                                    results.add(sb.toString());
                                }
                            }
                        }
                    }
                }
            }
        }
        return results;
    }
}
