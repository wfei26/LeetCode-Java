import java.util.HashMap;

public class A737_SentenceSimilarityII {
    public static void main(String[] args) {
        A737_SentenceSimilarityII solution = new A737_SentenceSimilarityII();
        String[][] dict = {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
        String[] input1 = {"great", "acting", "skills"};
        String[] input2 = {"fine", "drama", "talent"};
        boolean output = solution.areSentencesSimilarTwo(input1, input2, dict);
        System.out.println(output);
    }

    class UnionFind {
        HashMap<String, String> map;

        public UnionFind(String[][] dict) {
            map = new HashMap<>();
            //initialize disjoint set: set every word as its parent itself in dictionary
            for (String[] pair : dict) {
                String word1 = pair[0];
                String word2 = pair[1];
                map.putIfAbsent(word1, word1);
                map.putIfAbsent(word2, word2);
                //for every pair in dict, union them together, since they have relationship in input dict
                union(word1, word2);
            }
        }

        public String find(String word) {
           if (!map.containsKey(word)) {
               return word;
           }
           //iteratively get its ancestor
           while (word != map.get(word)) {
                word = map.get(word);
           }
           return word;
        }

        //find their parents, and union together
        public void union(String word1, String word2) {
            String parent1 = find(word1);
            String parent2 = find(word2);
            map.put(parent1, parent2);
        }
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        UnionFind unionFind = new UnionFind(pairs);

        //iteratively compare all words in two string arrays
        //once there exists two words with different parent, return false
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];

            String parent1 = unionFind.find(word1);
            String parent2 = unionFind.find(word2);
            //WARNING: STRING COMPARISON!!!
            if (!parent1.equals(parent2)) {
                return false;
            }
        }
        return true;
    }
}
