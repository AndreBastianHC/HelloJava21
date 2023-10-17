package features;

import org.junit.jupiter.api.Test;

import java.util.List;

class SequencedCollectionsTest {

    @Test
    void getFirstAndLastTest(){

        List<String> list = List.of("a", "b", "c", "d", "e", "f");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

    }
}
