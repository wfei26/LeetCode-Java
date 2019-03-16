import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        A438_FindAllAnagramsInAString solution = new A438_FindAllAnagramsInAString();
        String strA = "cbbaebabacd";
        String strB = "abc";
        List<Integer> myResults = solution.findAnagrams(strA, strB);
        for (int i = 0; i < myResults.size(); i++) {
            System.out.println(myResults.get(i));
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> myList = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return myList;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (char c : p.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
                count++;
            }
        }
        for (int left = 0, right = 0; right < s.length(); right++) {
            char curKey = s.charAt(right);
            if (map.containsKey(curKey)) {
                map.put(curKey, map.get(curKey) - 1);
                if (map.get(curKey) == 0) {
                    count--;
                }
                while (count == 0) {
                    char leftMostKey = s.charAt(left);
                    if (map.containsKey(leftMostKey)) {
                        map.put(leftMostKey, map.get(leftMostKey) + 1);
                        if (map.get(leftMostKey) > 0) {
                            count++;
                        }
                    }
                    if (right - left + 1 == p.length()) {
                        myList.add(left);
                    }
                    left++;
                }
            }


        }
        return myList;
    }
}
