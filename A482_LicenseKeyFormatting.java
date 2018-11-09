public class A482_LicenseKeyFormatting {
    public static void main(String[] args) {
        A482_LicenseKeyFormatting solution = new A482_LicenseKeyFormatting();
        String input = "--a-a-a-a--";
        String output = solution.licenseKeyFormatting(input, 2);
        System.out.println(output);
    }

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        //build a string from end to start, delete original dash, add new dash
        //when length of current string % (K + 1) == K
        for(int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (sb.length() % (K + 1) == K) {
                    sb.append('-');
                }
                sb.append(S.charAt(i));
            }
        }
        //reverse string, and convert all to upper case
        return sb.reverse().toString().toUpperCase();
    }
}
