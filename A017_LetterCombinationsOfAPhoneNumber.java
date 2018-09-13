import java.util.ArrayList;
import java.util.List;

public class A017_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        A017_LetterCombinationsOfAPhoneNumber solution = new A017_LetterCombinationsOfAPhoneNumber();
        String input = "23";
        List<String> myResult = solution.letterCombinations(input);
        for (int i = 0; i < myResult.size(); i++) {
            System.out.println(myResult.get(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> myList = new ArrayList<>();
        if (digits.length() == 0) {
            return myList;
        }

        String[] phoneKeys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        myList.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < myList.size(); j++) {
                for (char c : phoneKeys[digits.charAt(i) - '0'].toCharArray()) {
                    tempList.add(myList.get(j) + c);
                }
            }
            myList = tempList;
        }
        return myList;
    }
}
