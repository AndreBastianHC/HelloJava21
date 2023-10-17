package preview;

import org.junit.jupiter.api.Test;

import static java.lang.StringTemplate.STR;

class StringTemplatesTest {
    @Test
    void printHelloJava21WithStringTemplatesTest() {
        String name = "Java 21";
        String message = STR."Hello \{name}";
        System.out.println(message);
    }
}
