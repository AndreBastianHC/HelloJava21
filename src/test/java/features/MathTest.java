package features;

import org.junit.jupiter.api.Test;

import static java.lang.Math.clamp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathTest {

    @Test
    void clampTest(){
        int number = clamp(5,10,20);
        assertEquals(10, number);
        System.out.println(STR."Clamp min: \{number}");

        number = clamp(25,10,20);
        assertEquals(20, number);
        System.out.println(STR."Clamp max: \{number}");

        number = clamp(15,10,20);
        assertEquals(15, number);
        System.out.println(STR."Clamp in interval: \{number}");

        assertThrows(IllegalArgumentException.class, () -> clamp(5,20,10));
        try{
            clamp(5,20,10);
        }catch (IllegalArgumentException e ){
            System.out.println(e);
        }

    }

    @Test
    void clampOldTest(){
        int number = clampOld(5,10,20);
        assertEquals(10, number);
        System.out.println(STR."Clamp min: \{number}");

        number = clampOld(25,10,20);
        assertEquals(20, number);
        System.out.println(STR."Clamp max: \{number}");

        number = clampOld(15,10,20);;
        assertEquals(15, number);
        System.out.println(STR."Clamp in interval: \{number}");
    }

    int clampOld(int value, int min, int max){
        if(value < min)
            value = min;
        if(value > max)
            value = max;
        return value;
    }
}
