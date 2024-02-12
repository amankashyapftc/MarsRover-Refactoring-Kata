package mars.rover;

public enum Direction {
    N (0, 1) {
        @Override
        Direction turnLeft() {
            return W;
        }

        @Override
        Direction turnRight() {
            return E;
        }
    },
    S (0, -1) {
        @Override
        Direction turnLeft() {
            return E;
        }

        @Override
        Direction turnRight() {
            return W;
        }
    },
    W (-1, 0) {
        @Override
        Direction turnLeft() {
            return S;
        }

        @Override
        Direction turnRight() {
            return N;
        }
    },
    E (1, 0) {
        @Override
        Direction turnLeft() {
            return N;
        }

        @Override
        Direction turnRight() {
            return S;
        }
    };

    private final int coordinateXIncrement;
    private final int coordinateYIncrement;
    abstract Direction turnLeft();
    abstract Direction turnRight();

    private Direction(int coordinateXIncrement, int coordinateYIncrement) {
        this.coordinateXIncrement = coordinateXIncrement;
        this.coordinateYIncrement = coordinateYIncrement;
    }

    public int coordinateXIncrement() {
        return this.coordinateXIncrement;
    }

    public int coordinateYIncrement() {
        return this.coordinateYIncrement;
    }
}












