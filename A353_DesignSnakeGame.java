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


    Set<Coordinate> set;
    Deque<Coordinate> snakeBody;
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
        snakeBody.offer(new Coordinate(0, 0));
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
        Coordinate curHead = snakeBody.peekFirst();
        int rowIndex = curHead.rowIndex;
        int colIndex = curHead.colIndex;


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
        Coordinate newHead = new Coordinate(rowIndex, colIndex);

        // corner case: before checking whether new head will touch the snake body, we need to temporarily remove current tail
        // because the position of current tail is a valid position for new head
        set.remove(snakeBody.peekLast());

        // check if new head out of boundary or touch the body itself
        if (newHead.rowIndex < 0 || newHead.colIndex < 0 || newHead.rowIndex >= height || newHead.colIndex >= width || set.contains(newHead)) {
            return -1;
        }

        // if current move does not out of boundary, add new head into body no matter normal move or eating food
        set.add(newHead);
        snakeBody.addFirst(newHead);

        // if the position of new head is on the same position of next food
        if (foodIndex < food.length && newHead.rowIndex == food[foodIndex][0] && newHead.colIndex == food[foodIndex][1]) {
            set.add(snakeBody.peekLast());
            foodIndex++;
            return foodIndex;
        }

        // if current move is just a normal move
        snakeBody.pollLast();
        return foodIndex;
    }

    class Coordinate {
        int rowIndex;
        int colIndex;

        public Coordinate(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }
    }
}
