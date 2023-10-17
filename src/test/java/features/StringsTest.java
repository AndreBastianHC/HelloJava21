package features;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsTest {

    @Test
    void indexOfTest(){
        String string1 = "Wir suchen den Index eines erstmalig auftretenden Substrings in einem Teilbereich dieses Strings.";

        int substringIndex = string1.indexOf("Substring", 0, string1.length()-1);
        System.out.println(STR."Substring index: \{substringIndex}");

        assertEquals(-1, string1.indexOf("Substring", 50, 58));
        assertEquals(-1, string1.indexOf("Substring", 51, 59));
        assertEquals(50, string1.indexOf("Substring", 50, 59));
        assertEquals(50, string1.indexOf("Substring", 23, 69));

        substringIndex = string1.indexOf("ring", 30, string1.length()-1);
        System.out.println(STR."First Occurence: \{substringIndex}");

        substringIndex = string1.indexOf("ring", 60, string1.length()-1);
        assertEquals(91,string1.indexOf("ring", 60, string1.length()-1));
        System.out.println(STR."Second Occurence: \{substringIndex}");

        String string2 = "Wir suchen den Index eines erstmalig auftretenden Characters in einem Teilbereich dieses Strings";

        int charIndex = string2.indexOf('C', 0, string2.length()-1);
        System.out.println(STR."Character Index: \{charIndex}");

        assertEquals(-1, string2.indexOf('C', 51, 58));
        assertEquals(-1, string2.indexOf('C', 20, 49));
        assertEquals(50, string2.indexOf('C', 45, 60));
    }

    @Test
    void splitWithDelimitersTest(){
        String string = "Wir spalten diesen String in verschiedene Strings";

        String[] stringParts = string.splitWithDelimiters("t", 4);
        System.out.println(STR."4 splits: \{Arrays.stream(stringParts).toList()}");
        assertEquals(List.of("Wir spal","t", "en diesen S", "t", "ring in verschiedene S", "t", "rings"), Arrays.stream(stringParts).toList());

        stringParts = string.splitWithDelimiters("t", 3);
        System.out.println(STR."3 splits: \{Arrays.stream(stringParts).toList()}");
        assertEquals(List.of("Wir spal","t", "en diesen S", "t", "ring in verschiedene Strings"), Arrays.stream(stringParts).toList());
    }
}