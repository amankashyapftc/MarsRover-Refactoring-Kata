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

    public void moveForward() {
        int newXCoordinate = this.x+this.direction.coordinateXIncrement();
        int newYCoordinate = this.y+this.direction.coordinateYIncrement();

        if(this.plateau.isValidPosition(newXCoordinate,newYCoordinate)){
            this.x = newXCoordinate;
            this.y = newYCoordinate;
        }else{
            throw new UnsupportedOperationException("Try to move out of range.");
        }

    }

    public void turnRight() {
        this.direction=this.direction.turnRight();
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }
    @Override
    public String toString(){
        return x + " " + y + " " + direction;
    }
}