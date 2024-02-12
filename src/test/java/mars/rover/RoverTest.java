package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class RoverTest {

    @Test
    public void testTryToCreateRoverWithNegativeValuesShouldThrowAnError() {
        assertThrows(IllegalArgumentException.class, () -> new Rover(-1,7,Direction.S,new Plateau(9,9)));
    }

    @Test
    public void testCreatingRoverWithInvalidCo_ordinatesOutsideOfPlateau_ExpectException() {
        Plateau plateau = new Plateau(5,5);
        assertThrows(IllegalArgumentException.class, () -> new Rover(8,7,Direction.S,plateau));
    }

    @Test
    public void testCreatingRoverWithValidCo_ordinatesOutsideOfPlateauDoesNotThrowAnError() {
        Plateau plateau = new Plateau(5,5);
        assertDoesNotThrow(() -> new Rover(2,3,Direction.S,plateau));
    }

    @Test
    public void testLeftTurnOfRoverFromCurrentPosition() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(2,3,Direction.E,plateau);
        String result = rover.move("L");
        assertEquals("2 3 N", result);
    }

    @Test
    public void testRightTurnOfRoverFromCurrentPosition() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(1,1,Direction.S,plateau);
        String result = rover.move("R");
        assertEquals("1 1 W", result);
    }

    @Test
    public void testMoveForwardOfRoverFromCurrentPositionWhileFacingNorth() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(3,3,Direction.N,plateau);
        String result = rover.move("M");
        assertEquals("3 4 N", result);
    }

    @Test
    public void testMoveForwardOfRoverFromCurrentPositionWhileFacingEast() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(2,1,Direction.E,plateau);
        String result = rover.move("M");
        assertEquals("3 1 E", result);
    }

    @Test
    public void testMoveForwardOfRoverFromCurrentPositionWhileFacingWest() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(1,1,Direction.W,plateau);
        String result = rover.move("M");
        assertEquals("0 1 W", result);
    }

    @Test
    public void testMoveForwardOfRoverFromCurrentPositionWhileFacingSouth() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(3,1,Direction.S,plateau);
        String result = rover.move("M");
        assertEquals("3 0 S", result);
    }

    @Test
    public void testMultipleDirectionMove() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(1,2,Direction.N,plateau);
        String result = rover.move("LMLMLMLMM");
        assertEquals("1 3 N", result);
    }

    @Test
    public void testTwoWithMultipleDirectionMove() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(3,3,Direction.E,plateau);
        String result = rover.move("MMRMMRMRRM");
        assertEquals("5 1 E", result);
    }
}