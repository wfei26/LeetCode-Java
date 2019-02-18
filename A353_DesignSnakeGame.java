import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class A353_DesignSnakeGame {
    public static void main(String[] args) {
        int[][] food = {{2,0}, {0,0}, {0,2}, {0,1}, {2,2}, {0,1}};
        A353_DesignSnakeGame solution = new A353_DesignSnakeGame(3, 3, food);
        System.out.println(solution.move("D"));
        System.out.println(solution.move("D"));
        System.out.println(solution.move("R"));
        System.out.println(solution.move("U"));
        System.out.println(solution.move("U"));
        System.out.println(solution.move("L"));
        System.out.println(solution.move("D"));
        System.out.println(solution.move("R"));
        System.out.println(solution.move("R"));
        System.out.println(solution.move("U"));
        System.out.println(solution.move("L"));
        System.out.println(solution.move("L"));
        System.out.println(solution.move("D"));
        System.out.println(solution.move("R"));
        System.out.println(solution.move("U"));
    }


    /**
     * @param set - store all positions of snake body, in order to quickly check whether snake would touch itself
     * @param snakeBody - also store all positions of snake body, in order to conveniently add or remove any points
     *                  from either starting or ending of the body
     * @param foodIndex - record current index of food array, can also be current score (return value)
     *
     * Main idea: maintain a deque and a hash set to store all coordinates of snake body. Operate every move firstly,
     * and then check if new head is out of boundary or touching the body. If not, check if current move is eating food
     * or just a normal move.
     * */
    Set<Integer> set;
    Deque<Integer> snakeBody;
    int width;
    int height;
    int[][] food;
    int foodIndex;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public A353_DesignSnakeGame(int width, int height, int[][] food) {
        set = new HashSet<>();
        snakeBody = new LinkedList<>();
        // WARNING: DO NOT FORGET to add initial point into snake body
        snakeBody.offer(0);
        this.width = width;
        this.height = height;
        this.food = food;
        foodIndex = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int curHead = snakeBody.peekFirst();
        int rowIndex = curHead / width;
        int colIndex = curHead % width;


        if (direction.equals("U")) {
            rowIndex--;
        }
        else if (direction.equals("D")) {
            rowIndex++;
        }
        else if (direction.equals("L")) {
            colIndex--;
        }
        else if (direction.equals("R")) {
            colIndex++;
        }

        // create a new head with updated coordinate
        // IMPORTANT: to pack a coordinate to an integer value, we do not need to create a class object, we can use
        // row * totalWidth + col to get an integer, since col will ALWAYS smaller than totalWidth. Then we can use
        // modular to get colIndex later
        int newHead = rowIndex * width + colIndex;

        // corner case: before checking whether new head will touch the snake body, we need to temporarily remove current tail
        // because the position of current tail is a valid position for new head
        set.remove(snakeBody.peekLast());

        // check if new head out of boundary or touch the body itself
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= height || colIndex >= width || set.contains(newHead)) {
            return -1;
        }

        // if current move does not out of boundary, add new head into body no matter normal move or eating food
        set.add(newHead);
        snakeBody.addFirst(newHead);

        // if the position of new head is on the same position of next food
        if (foodIndex < food.length && rowIndex == food[foodIndex][0] && colIndex == food[foodIndex][1]) {
            set.add(snakeBody.peekLast());
            foodIndex++;
            return foodIndex;
        }

        // if current move is just a normal move
        snakeBody.pollLast();
        return foodIndex;
    }
}
