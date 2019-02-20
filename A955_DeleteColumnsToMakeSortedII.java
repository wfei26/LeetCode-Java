import java.util.HashSet;
import java.util.Set;

public class A955_DeleteColumnsToMakeSortedII {
    public static void main(String[] args) {
        A955_DeleteColumnsToMakeSortedII solution = new A955_DeleteColumnsToMakeSortedII();
        String[] input = {"cya", "cza", "cxa", "dba"};
        int output = solution.minDeletionSize(input);
        System.out.println(output);
    }

    /**
     * Traverse every column, check whether each column is valid or invalid
     * 1. Invalid: if there exists a pair of character with wrong order, result++, since we need to delete the entire column
     * 2. Valid: if there does not exist any antiOrder pair, we need to use greedy algorithm to mark all rows that
     * already been "sorted." In other words, we ONLY filter the rows that have equal characters, and then ONLY
     * check pairs of characters from these rows in next column.
     * -------------------------------------------------------------------------------------------------------------
     *
     * For example, if we have {ab, ac, bc}, when we traverse the first column, second row will be added into set,
     * which means we do not have to compare second row and third row in later iterations.
     *
     * Here, we should EMPHASIZE that, we add second row into set DOES NOT MEAN the second row is sorted, it
     * actually means third row is sorted. Because in every iteration, we ACTUALLY compare i and i+1, if we put
     * second row into set, it infers that we will never access the third row later, because the third row is already
     * been sorted. But when we access first row, we will still need to compare first row and second row, even though
     * the second row is in set.
     *
     * -------------------------------------------------------------------------------------------------------------
     * -------------------------------------------------------------------------------------------------------------
     * 翻译：题目意思大概就是尽可能少的删除一些列来达到满足alien dictionary的结果。
     * 这题的思路就是从所有单词的第一列开始，遍历每一列字母，检查当前列是否合法。那么我们分两种情况讨论
     * 1. 不合法：当前列一旦出现某一行的字母顺序大于后一行，当前列即为不合法列，那么我们就需要删除整列，result++
     * 2. 合法：如果当前列遍历到最后一行都没有发现不合法的行，说明当前列只会存在前一行小于或等于后一行的情况，这个时候我们就需要用greedy
     * 的思想找到所有"sorted"的行加到set中去（所谓"sorted"的行就是指前一行的字母顺序小于后一行）。那么剩下来不在set中的行就是在当前列
     * 拥有相同字母关系的很多pair，对于这些行，我们就要检查他们后面一列的字母关系。这样以后凡是在set里面的行，我们在之后的iterations中
     * 都可以skip，只需要检查不在set中的行就可以。
     * -------------------------------------------------------------------------------------------------------------
     *
     * 这里，我们需要强调一点比较trick的地方：当我们把每一行加到set中去的时候，其实并不是当前行被mark了，而且它的后一行被mark了。造成
     * 这样的原因是因为我们每次check每一对pair的时候是check i 和 i+1 行
     * 举个例子，假设我们有 {ab, ac, bc} 这个数组（第一行ab，第二行ac，第三行bc），当我们扫第一列的时候，我们会把第二行"ac"加到set中
     * 去，因为第二行比第三行字母顺序小。
     *
     * 换成表达式就是 A[1].charAt(0) < A[2].charAt(0)。那我们不难发现，这个时候并不是第二行已经被sorted了，而是第三行。因为第二行
     * 的"ac"和第一行的"ab"在当前列的字母是相同的，我们还需要在之后进行比较来判断后续的列是否为valid。
     * 比较关键的点就是：当我们把第 i 行加到set中去的时候，我们再也不会compare第 i 行和第 i+1 行了，相当于第 i+1 行已经被mark了。但是
     * 由于第 i-1 行并没有被mark，所以我们之后还是会比较第 i-1 行和第 i 行。
     *
     * 总而言之，每遍历一列，我们就有可能排除一些合法的行，之后留给我们需要check的行就会越来越少。当我们发现set的size等于array的
     * 总长度减一的时候，我们所有的行就已经被mark为sorted了，这样我们就可以返回当前的counter了
     * */
    public int minDeletionSize(String[] A) {
        if (A.length == 0) {
            return 0;
        }

        // set represented rows that already sorted
        Set<Integer> set = new HashSet<>();
        int col, row;
        int result = 0;
        for (col = 0; col < A[0].length(); col++) {
            // if all rows is marked as "sorted", we do not need to go through the rest of columns again
            // just return current result directly
            if (set.size() == A.length - 1) {
                return result;
            }

            // traverse every row to check whether current column is a valid or invalid
            for (row = 0; row < A.length - 1; row++) {
                if (!set.contains(row) && A[row].charAt(col) > A[row + 1].charAt(col)) {
                    result++;
                    break;
                }
            }

            // if current column is INVALID (current column exists < = and > relationships), we cannot conduct adding
            // set operations, but we need to delete the entire column, so we have to go to next iteration to check next column
            if (row != A.length - 1) {
                continue;
            }

            // if current column is VALID (current column only exists < or = relationships)
            for (int k = 0; k < A.length - 1; k++) {
                if (A[k].charAt(col) < A[k + 1].charAt(col)) {
                    set.add(k);
                }
            }
        }
        return result;
    }
}
