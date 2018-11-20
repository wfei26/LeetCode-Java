import java.util.*;

public class A127_WordLadder {
    public static void main(String[] args) {
        A127_WordLadder solution = new A127_WordLadder();
        List<String> input = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int output = solution.ladderLength("hit", "cog", input);
        System.out.println(output);
    }

    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        // corner case: if wordList does not contain end word, return 0 directly
        if (!dict.contains(end)) {
            return 0;
        }

        // visited set can mark all visited words in dict
        Set<String> visited = new HashSet<>();
        visited.add(start);

        // use BFS to traverse and find the correct path
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        queue.offer(null);

        int level = 1;
        while (!queue.isEmpty()) {
            String curStr = queue.poll();

            // if current level still has elements
            if (curStr != null) {
                for (int i = 0; i < curStr.length(); i++) {
                    // MUST declare str array inside of loop, because we have to re-initialize this
                    // char array at the beginning of every iteration
                    char[] curStrArr = curStr.toCharArray();

                    // try all 26 alphabets to substitute current index of curStr
                    for (char c = 'a'; c <= 'z'; c++) {
                        curStrArr[i] = c;
                        String curWord = new String(curStrArr);

                        // found the destination word, return level++
                        if (curWord.equals(end)) {
                            return level + 1;
                        }

                        // if dict contains current trying word, and has not been visited yet
                        if (dict.contains(curWord) && !visited.contains(curWord)) {
                            queue.offer(curWord);
                            visited.add(curWord);
                        }
                    }
                }
            }

            // if all strings at current level have already been traversed, add level number by 1
            // and add a level separator if queue is not empty
            else {
                level++;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        return 0;
    }
}
