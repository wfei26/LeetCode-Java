import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A030_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        A030_SubstringWithConcatenationOfAllWords solution = new A030_SubstringWithConcatenationOfAllWords();
        String strA = "barfoobarbarfoothefoobarman";
        String[] strB = {"foo", "bar"};
        List<Integer> myResults = solution.findSubstring(strA, strB);
        for (int i = 0; i < myResults.size(); i++) {
            System.out.println(myResults.get(i));
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return results;
        }

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> curMap = new HashMap<>();
        for (String c : words) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }

        int strLen = s.length();
        int arrLen = words.length;
        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            int count = 0;
            for (int left = i, right = i; right + wordLen <= strLen; right += wordLen) {
                String curWord = s.substring(right, right + wordLen);
                if (map.containsKey(curWord)) {
                    if (!curMap.containsKey(curWord)) {
                        curMap.put(curWord, 1);
                    }
                    else {
                        curMap.put(curWord, curMap.get(curWord) + 1);
                    }

                    if (curMap.get(curWord) <= map.get(curWord)) {
                        count++;
                    }

                    while (curMap.get(curWord) > map.get(curWord)) {
                        String temp = s.substring(left, left + wordLen);
                        curMap.put(temp, curMap.get(temp) - 1);
                        left += wordLen;
                        if (curMap.get(temp) < map.get(temp)) {
                            count--;
                        }
                    }

                    if (count == arrLen) {
                        results.add(left);
                        String firstWord = s.substring(left, left + wordLen);
                        curMap.put(firstWord, curMap.get(firstWord) - 1);
                        count--;
                        left += wordLen;
                    }
                }
                else {
                    count = 0;
                    curMap.clear();
                    left = right + wordLen;
                }
            }
            curMap.clear();
        }

        return results;
    }
}
