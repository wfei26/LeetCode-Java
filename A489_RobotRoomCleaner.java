import java.util.HashSet;
import java.util.Set;

public class A489_RobotRoomCleaner {
    public static void main(String[] args) {
        A489_RobotRoomCleaner solution = new A489_RobotRoomCleaner();
        solution.cleanRoom(new Robot());
    }

    public void cleanRoom(Robot robot) {
        backtracking(robot, new HashSet<>(), 0, 0, 0);
    }

    public void backtracking(Robot robot, Set<String> visited, int i, int j, int direction) {
        String curMove = "x" + i + "y" + j;
        // if next point has been visited, return and backtrack (change to another direction)
        if (!visited.add(curMove)) {
            return;
        }
        robot.clean();

        // try four directions, to see which direction the robot can move
        for (int dir = 0; dir < 4; dir++) {
            // if robot can move from current point, move the robot
            if (robot.move()) {
                int nextX = i;
                int nextY = j;

                if (direction % 360 == 0) {
                    nextX = i - 1; // go up
                }
                else if (direction % 360 == 90) {
                    nextY = j + 1; // go right
                }
                else if (direction % 360 == 180) {
                    nextX = i + 1; // go down
                }
                else if (direction % 360 == 270) {
                    nextY = j - 1; // go left
                }

                backtracking(robot, visited, nextX, nextY, direction);
                // if all four directions cannot move, return to here and start backtracking
                // turn 180 degree, move and turn 180 degree again in order to completely recover to previous status
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            // not only call turnRight(), but also add direction by 90 because we need to use this variable to
            // determine which direction the robot wants to move if robot can move in next iteration.
            robot.turnRight();
            direction += 90;
        }
    }
}

class Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move() {
        return true;
    }

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft() {

    }

    public void turnRight() {

    }

    // Clean the current cell.
    public void clean() {

    }
}
