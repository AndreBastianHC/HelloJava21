package preview;

import org.junit.jupiter.api.Test;

import static java.lang.StringTemplate.STR;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTemplatesTest {
    @Test
    void printHelloJava21WithStringTemplatesTest() {
        String name = "Java 21";
        String message = STR."Hello, \{name}";
        assertEquals("Hello, Java 21", message);
        System.out.println(message);
    }
}
