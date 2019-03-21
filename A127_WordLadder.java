import java.util.*;

public class A127_WordLadder {
    public static void main(String[] args) {
        A127_WordLadder solution = new A127_WordLadder();
        List<String> input = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int output = solution.ladderLength("hit", "cog", input);
        System.out.println(output);
    }

    /** use BFS to traverse every level with all possible words that only need to replace one character from previous
     * level, once we found the endWord, return current ladder + 1 */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return 0;
        }

        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        // WARNING: ladder MUST start at 1
        int ladder = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();

                // try all possible substitution (26 characters) in every position of current word
                for (int j = 0; j < curWord.length(); j++) {
                    char[] curWordArr = curWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        curWordArr[j] = c;

                        String newWord = new String(curWordArr);
                        if (newWord.equals(endWord) && dict.contains(endWord)) {
                            return ladder + 1;
                        }

                        // add possible word for next ladder (level)
                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            ladder++;
        }
        return 0;
    }
}
