public class A044_WildcardMatching {
    public static void main(String[] args) {
        A044_WildcardMatching solution = new A044_WildcardMatching();
        String s = "abceb";
        String p = "*a*b";
        boolean output = solution.isMatch(s, p);
        System.out.println(output);
    }

    public boolean isMatch(String s, String p) {
        int sPtr = 0, pPtr = 0;
        // starPos represents the index of last (right most) star that we traversed
        int starPos = 0;
        // matchEndPos represents the index of last character that star matched
        int matchEndPos = 0;
        boolean seenStar = false;

        while (sPtr < s.length()) {
            // if two characters are matching, move both of two pointers
            if (pPtr < p.length() && (p.charAt(pPtr) == '?' || s.charAt(sPtr) == p.charAt(pPtr))) {
                sPtr++;
                pPtr++;
            }
            // if current character in pattern is '*', set star position, next pattern position
            // if there exists some consecutive stars, use the last one's index as starPos
            else if (pPtr < p.length() && p.charAt(pPtr) == '*') {
                seenStar = true;
                starPos = pPtr;
                pPtr = starPos + 1;
                matchEndPos = sPtr;
            }
            // previous character in pattern string is '*'
            else if (seenStar) {
                // reset pattern pointer to star+1 position, just in case if we mismatch, then we need to roll back
                // to re-match the star
                pPtr = starPos + 1;
                matchEndPos++;
                sPtr = matchEndPos;
            }
            // pattern string reach the end, but original string still has characters to match
            // return false directly to avoid infinite loop
            else {
                return false;
            }
        }

        // if pattern string still has '*' left, skip them all, treat them as space
        while (pPtr < p.length() && p.charAt(pPtr) == '*') {
            pPtr++;
        }

        // if pattern string still has non-star characters left, return false
        // else, return true
        return pPtr == p.length();
    }
}
