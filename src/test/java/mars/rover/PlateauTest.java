package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlateauTest {

    @Test
    public void testCreatingPlateauWithNegativeIntegerInput_ExpectException() {
        assertThrows(IllegalArgumentException.class, () -> new Plateau(4,-9));
    }

    @Test
    public void testCreatingPlateauWithValidInput_ExpectNoException() {
        assertDoesNotThrow(() -> new Plateau(4,6));
    }

}