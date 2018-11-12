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
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
        }

        public String find(int x) {
            if (x == parent[x])
        }
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {

    }
}
