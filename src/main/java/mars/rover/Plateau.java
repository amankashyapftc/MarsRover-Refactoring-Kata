package mars.rover;

public class Plateau {
    private final int maxX;
    private final int maxY;

    public Plateau(int x, int y){
        if(x < 0 || y < 0) throw new IllegalArgumentException("Please Enter positive Integers");
        maxX = x;
        maxY = y;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}