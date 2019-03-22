import java.util.*;

public class A126_WordLadderII {
    public static void main(String[] args) {
        A126_WordLadderII solution = new A126_WordLadderII();
        List<String> input = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        List<List<String>> res = solution.findLadders("hit", "cog", input);
        for (List<String> curLsit : res) {
            for (String str : curLsit) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }


    /**
     * High level design: BFS + DFS
     *
     * Step 1: use BFS to build graph (adjacency list of each word), as well as calculating distance from beginWord to
     * each node in the graph (should store minimum distance)
     *
     * Step 2: use DFS to traverse and record path from beginWord to endWord with shortest path. We can use distance map
     * to control every next word.
     * */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return new ArrayList<>();
        }

        /**
         * @param result: result list to store final return list
         * @param graph: adjacency list of key - store all neighbors of each word (neighbor means all words in dictionary
         *             that only has one character difference with key)
         * @param distance: distance between beginWord and current key word, used for tracing path when we do DFS
         * @param dict: word dictionary, efficient for searching purpose
         * */
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);

        bfs(beginWord, endWord, dict, graph, distance);
        dfs(result, graph, distance, endWord, beginWord, new ArrayList<>());
        return result;
    }

    // step 1
    public void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Set<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            boolean reachEnd = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();

                // try all possible substitution (26 characters) in every position of current word, if newWord exists in
                // dictionary, we add it to the adjacency list of curWord
                for (int j = 0; j < curWord.length(); j++) {
                    char[] curWordArr = curWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        curWordArr[j] = c;
                        String newWord = new String(curWordArr);
                        if (dict.contains(newWord)) {
                            graph.putIfAbsent(curWord, new HashSet<>());
                            graph.get(curWord).add(newWord);
                        }
                    }
                }

                // traverse all neighbors of current word, update distance map and queue for next ladder (level)
                // WARNING: DO NOT USE visited set, since it is hard to deal with end word if endWord is visited
                for (String neighbor : graph.get(curWord)) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(curWord) + 1);
                        if (neighbor.equals(endWord)) {
                            reachEnd = true;
                        }
                        else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (reachEnd) {
                    break;
                }
            }
        }
    }

    // step 2
    public void dfs(List<List<String>> result, Map<String, Set<String>> graph, Map<String, Integer> distance,
                    String endWord, String curWord, List<String> tempList) {
        if (curWord.equals(endWord)) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (String nextWord : graph.get(curWord)) {
            // only if next node is on the minimum path to the endWord, we can traverse it
            if (distance.get(nextWord) == distance.get(curWord) + 1) {
                tempList.add(nextWord);
                dfs(result, graph, distance, endWord, nextWord, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
