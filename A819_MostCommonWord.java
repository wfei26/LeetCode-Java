import java.util.HashMap;
import java.util.HashSet;

public class A819_MostCommonWord {
    public static void main(String[] args) {
        A819_MostCommonWord solution = new A819_MostCommonWord();
        String inputs = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] bannedWords = {"hit"};
        String output = solution.mostCommonWord(inputs, bannedWords);
        System.out.println(output);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph.length() == 0) {
            return "";
        }

        String result = "";
        //use regular expression to delete all punctuations, convert all characters to lower case
        //and then split the updated String by space, save into a new String array
        //IMPORTANT: \\s+ means continuous space
        String[] words = paragraph.replaceAll("[^a-zA-z]", " ").toLowerCase().split("\\s+");

        HashSet<String> banWords = new HashSet<>();
        for (String word : banned) {
            banWords.add(word);
        }

        int maxCount = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            //check if current word is ban word, if not, map.get(word)++ means freq++
            //and update maxCount if necessary
            if (!banWords.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (map.get(word) > maxCount) {
                    maxCount = map.get(word);
                    result = word;
                }
            }
        }
        return result;
    }
}
