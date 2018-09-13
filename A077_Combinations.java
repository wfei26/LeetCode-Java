import java.util.ArrayList;
import java.util.List;

public class A077_Combinations {
    public static void main(String[] args){
        A077_Combinations solution = new A077_Combinations();
        int input1 = 4;
        int input2 = 2;
        List<List<Integer>> myResults = solution.combine(input1, input2);
        for (int i = 0; i < myResults.size(); i++) {
            for (int j = 0; j < myResults.get(i).size(); j++) {
                System.out.print(myResults.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> myList = new ArrayList<>();
        backtracking(myList, new ArrayList<>(), n, k, 1);
        return myList;
    }

    public void backtracking(List<List<Integer>> myList, List<Integer> tempList, int n, int k, int pos) {
        if (tempList.size() == k) {
            myList.add(new ArrayList<>(tempList));
        }

        for (int i = pos; i <= n; i++) {
            tempList.add(i);
            backtracking(myList, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
