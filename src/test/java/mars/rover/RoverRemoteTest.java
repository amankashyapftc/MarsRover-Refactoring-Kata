package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoverRemoteTest {
    @Test
    public void testMultipleDirectionMove() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(1,2,Direction.N,plateau);
        RoverRemote roverRemote = new RoverRemote(rover);
        String result = roverRemote.execute("LMLMLMLMM");
        assertEquals("1 3 N", result);
    }

    @Test
    public void testTwoWithMultipleDirectionMove() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(3,3,Direction.E,plateau);
        RoverRemote roverRemote = new RoverRemote(rover);
        String result = roverRemote.execute("MMRMMRMRRM");
        assertEquals("5 1 E", result);
    }

    @Test
    public void testTryToExecuteUnsupportedMoveShouldThrowAnError() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(3,3,Direction.E,plateau);
        RoverRemote roverRemote = new RoverRemote(rover);
        assertThrows(IllegalArgumentException.class, ()->roverRemote.execute("MMRMMJKMRRM"));
    }
}
