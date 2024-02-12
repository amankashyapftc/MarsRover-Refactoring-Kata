package mars.rover;

public class Rover {
    private int x;
    private int y;

    private Direction direction;

    private final Plateau plateau;

    public Rover(int x,int y, Direction direction,Plateau plateau) {
        if (!plateau.isValidPosition(x,y)) throw new IllegalArgumentException("Please enter valid co-ordinates");
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
    }


    public String move(String instructions) {
        for(char instruction : instructions.toCharArray()) {
            if (instruction == 'L') turnLeft();
            else if(instruction == 'R') turnRight();
            else if(instruction == 'M') moveForward();
        }
        return x + " " + y + " " + direction;
    }

    private void moveForward() {
        switch (direction) {
            case N:
                if(plateau.isValidPosition(x,y+1)) y++;
                break;
            case E:
                if(plateau.isValidPosition(x+1,y)) x++;
                break;
            case S:
                if(plateau.isValidPosition(x,y-1)) y--;
                break;
            case W:
                if(plateau.isValidPosition(x-1,y)) x--;
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case N:
                direction = Direction.E;
                break;
            case E:
                direction = Direction.S;
                break;
            case S:
                direction = Direction.W;
                break;
            case W:
                direction = Direction.N;
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case N:
                direction = Direction.W;
                break;
            case E:
                direction = Direction.N;
                break;
            case S:
                direction = Direction.E;
                break;
            case W:
                direction = Direction.S;
                break;
        }
    }
}