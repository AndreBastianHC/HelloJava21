package features;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import records.ChildRecord;
import records.ExampleRecord;
import records.KidRecord;
import records.ParentRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordPatternsTest {

    @Test
    void recordPatternMatchingForInstanceOfTest(){

        ChildRecord childRecord = new ChildRecord(10, "Child", true);
        KidRecord kidRecord = new KidRecord(20, "Kid");
        ParentRecord parentRecord = new ParentRecord(childRecord, kidRecord);

        assertEquals("Child", patternMatchingInstanceof(childRecord));
        System.out.println(patternMatchingInstanceof(childRecord));

        assertEquals("Kid", patternMatchingInstanceof(kidRecord));
        System.out.println(patternMatchingInstanceof(kidRecord));

        assertEquals("ChildKid", patternMatchingInstanceof(parentRecord));
        System.out.println(patternMatchingInstanceof(parentRecord));

        assertEquals("no match", patternMatchingInstanceof(5));
        System.out.println(patternMatchingInstanceof(5));
    }

    String patternMatchingInstanceof(Object object){

        if(object instanceof ChildRecord(int number, String string, boolean bool))
            return string;

        if(object instanceof KidRecord(int number, String string))
            return string;

        if(object instanceof ParentRecord(ChildRecord childRecord, KidRecord kidRecord))
            return childRecord.string() + kidRecord.string();

/*        if (object instanceof ParentRecord(ChildRecord(int childNumber, String childString, boolean childBool), KidRecord(int kidNumber, String kidString)))
            return childString + kidString;*/

/*        if (object instanceof ParentRecord(ChildRecord(_, String childString, _), KidRecord(_, String kidString)))
            return childString + kidString;*/

        return "no match";
    }

    @Test
    void recordPatternMatchingForSwitchInterfaceTest(){

        ChildRecord childRecord = new ChildRecord(10, "Child", true);
        KidRecord kidRecord = new KidRecord(20, "Kid");
        ParentRecord parentRecord = new ParentRecord(childRecord, kidRecord);

        assertEquals("Child", patternMatchingForSwitchInterface(childRecord));
        System.out.println(patternMatchingForSwitchInterface(childRecord));

        assertEquals("Kid", patternMatchingForSwitchInterface(kidRecord));
        System.out.println(patternMatchingForSwitchInterface(kidRecord));

        assertEquals("ChildKid", patternMatchingForSwitchInterface(parentRecord));
        System.out.println(patternMatchingForSwitchInterface(parentRecord));
    }

    String patternMatchingForSwitchInterface(ExampleRecord exampleRecord){
        switch (exampleRecord) {
            case ChildRecord(int number, String string, boolean bool) -> { return string; }
            case KidRecord(int number, String string) -> {return string; }
            case ParentRecord(ChildRecord(int childNumber, String childString, boolean childBool), KidRecord(int kidNumber, String kidString)) -> { return childString+kidString; }
            /*case ParentRecord(ChildRecord(_,var childString,_),_) -> { return childString + " unnamed variable"; }*/
        }
    }


    @Test
    void recordPatternMatchingForSwitchTest(){

        ChildRecord childRecord = new ChildRecord(10, "Child", true);
        KidRecord kidRecord = new KidRecord(20, "Kid");
        ParentRecord parentRecord = new ParentRecord(childRecord, kidRecord);

        assertEquals("Child", patternMatchingForSwitchTest(childRecord));
        System.out.println(patternMatchingForSwitchTest(childRecord));

        assertEquals("Kid", patternMatchingForSwitchTest(kidRecord));
        System.out.println(patternMatchingForSwitchTest(kidRecord));

        assertEquals("ChildKid", patternMatchingForSwitchTest(parentRecord));
        System.out.println(patternMatchingForSwitchTest(parentRecord));

        assertEquals("no match", patternMatchingForSwitchTest(5));
        System.out.println(patternMatchingForSwitchTest(5));
    }

    String patternMatchingForSwitchTest(@NotNull Object object){
        switch (object) {
            case ChildRecord(int number, String string, boolean bool) -> { return string; }
            case KidRecord(int number, String string) -> {return string; }
            case ParentRecord(ChildRecord(int childNumber, String childString, boolean childBool), KidRecord(int kidNumber, String kidString)) -> { return childString+kidString; }
            //case ParentRecord(ChildRecord(_,var childString,_),_) -> {return childString + "_"; }
            default -> { return "no match"; }
        }
    }
}
