package features;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SequencedCollectionsTest {

    @Test
    void listTest(){

        List<String> list = List.of("a", "b", "c", "d", "e", "f");

        assertEquals("a", list.getFirst());
        System.out.println(list.getFirst());

        assertEquals("f", list.getLast());
        System.out.println(list.getLast());
    }

    @Test
    void linkedHashSetTest(){

        List<String> list = List.of("a", "b", "c", "d", "e", "f");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(list);

        assertEquals("a", linkedHashSet.getFirst());
        System.out.println(linkedHashSet.getFirst());
        //Old
        assertEquals("a", linkedHashSet.iterator().next());

        assertEquals("f", linkedHashSet.getLast());
        System.out.println(linkedHashSet.getLast());
        //Old
        assertEquals("f", linkedHashSet.toArray()[linkedHashSet.toArray().length-1]);

        linkedHashSet.removeFirst();
        linkedHashSet.removeLast();

        assertEquals("b", linkedHashSet.getFirst());
        System.out.println(linkedHashSet.getFirst());

        assertEquals("e", linkedHashSet.getLast());
        System.out.println(linkedHashSet.getLast());

    }

    @Test
    void linkedHashMapTest(){
        SequencedMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"a");
        linkedHashMap.put(2,"b");
        linkedHashMap.put(3,"c");
        linkedHashMap.put(4,"d");
        linkedHashMap.put(5,"e");
        linkedHashMap.put(6,"f");

        assertEquals(1, linkedHashMap.firstEntry().getKey());
        assertEquals("a", linkedHashMap.firstEntry().getValue());
        System.out.println(STR."First Entry: \{linkedHashMap.firstEntry()}");

        assertEquals(6, linkedHashMap.lastEntry().getKey());
        assertEquals("f", linkedHashMap.lastEntry().getValue());
        System.out.println(STR."Last Entry: \{linkedHashMap.lastEntry()}");


        assertEquals("a", linkedHashMap.pollFirstEntry().getValue());
        assertEquals("b", linkedHashMap.firstEntry().getValue());
        System.out.println(STR."After pollFirstEntry: \{linkedHashMap}");

        linkedHashMap.putFirst(1,"a");
        linkedHashMap.putFirst(2,"b");
        linkedHashMap.putFirst(3,"c");
        linkedHashMap.putFirst(4,"d");
        linkedHashMap.putFirst(5,"e");
        linkedHashMap.putFirst(6,"f");
        assertEquals(List.of("f", "e", "d", "c", "b", "a"),linkedHashMap.sequencedValues().stream().toList());
        assertEquals(List.of(6,5,4,3,2,1),linkedHashMap.sequencedKeySet().stream().toList());
        System.out.println(STR."After putFirst: \{linkedHashMap}");

        linkedHashMap.putLast(0,"");
        assertEquals(List.of("f", "e", "d", "c", "b", "a",""),linkedHashMap.sequencedValues().stream().toList());
        assertEquals(List.of(6,5,4,3,2,1,0),linkedHashMap.sequencedKeySet().stream().toList());
        System.out.println(STR."After putLast: \{linkedHashMap}");

        assertEquals(List.of(0,1,2,3,4,5,6), linkedHashMap.reversed().sequencedKeySet().stream().toList());
        assertEquals(List.of("","a", "b", "c", "d", "e", "f"),linkedHashMap.reversed().sequencedValues().stream().toList());
        System.out.println(STR."Reversed: \{linkedHashMap.reversed()}");
    }
}
