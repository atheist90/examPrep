package stepic3_3;

public class Robot {
    int x;
    int y;
    Direction dir;

    public Robot (int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {return dir;}

    public int getX() {return x;}

    public int getY() {return y;}

    public void turnLeft() {
        if      (dir == Direction.UP)    {dir = Direction.LEFT;}
        else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
        else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
        else if (dir == Direction.RIGHT) {dir = Direction.UP;}
    }

    public void turnRight() {
        if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
        else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
        else if (dir == Direction.LEFT)  {dir = Direction.UP;}
        else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
    }

    public void stepForward() {
        if (dir == Direction.UP)    {y++;}
        if (dir == Direction.DOWN)  {y--;}
        if (dir == Direction.LEFT)  {x--;}
        if (dir == Direction.RIGHT) {x++;}
    }


    public static void moveRobot(Robot robot, int toX, int toY) {

        // Если toX больше начальной позиции, то должен повернуть направо
        if (toX < robot.getX()) {
            while (robot.getDirection() != Direction.LEFT) robot.turnRight();
            for (int i = 0; i < robot.getX() - toX; i++) robot.stepForward();
        }
        // Если toX меньше начальной позиции, то должен повернуть налево
        if (toX > robot.getX()) {
            while (robot.getDirection() != Direction.RIGHT) robot.turnRight();
            for (int i = 0; i < toX - robot.getX(); i++) robot.stepForward();
        }
        // Если toY больше начальной позиции, то должен повернуть наверх
        if (toY > robot.getY()) {
            while (robot.getDirection() != Direction.UP) robot.turnRight();
            for (int i = 0; i < toY - robot.getY(); i++) robot.stepForward();
        }
        // Если toY меньше начальной позиции, то должен повернуть вниз
        if (toY < robot.getY()) {
            while (robot.getDirection() != Direction.DOWN) robot.turnRight();
            for (int i = 0; i < robot.getY() - toY; i++) robot.stepForward();
        }
    }
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}

