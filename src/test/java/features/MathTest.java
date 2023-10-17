package features;

import org.junit.jupiter.api.Test;

import static java.lang.Math.clamp;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MathTest {

    @Test
    void clampTest(){
        int number = clamp(5,10,20);
        System.out.println(STR."Clamp min: \{number}");
        assertEquals(10, number);

        number = clamp(25,10,20);
        System.out.println(STR."Clamp max: \{number}");
        assertEquals(20, number);

        number = clamp(15,10,20);
        System.out.println(STR."Clamp in interval: \{number}");
        assertEquals(15, number);
    }
}
