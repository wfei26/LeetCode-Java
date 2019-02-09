public class A855_ExamRoom {
    public static void main(String[] args) {
        A855_ExamRoom solution = new A855_ExamRoom(10);
        solution.seat();
        solution.seat();
        solution.seat();
        solution.seat();
        solution.leave(4);
        solution.seat();
    }

    TrieNode examRoom;
    public A855_ExamRoom(int N) {
        examRoom = new TrieNode(' ');
    }

    public int seat() {
        return 0;
    }

    public void leave(int p) {

    }

    class TrieNode {
        char val;
        boolean isCorrectWord;
        TrieNode[] chilren;

        public TrieNode(char val) {
            this.val = val;
            this.isCorrectWord = false;
            this.chilren = new TrieNode[26];
        }
    }
}
