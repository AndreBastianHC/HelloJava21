package features;

import org.junit.jupiter.api.Test;
import records.ChildRecord;
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

        assertEquals("no match", patternMatchingInstanceof(null));
        System.out.println(patternMatchingInstanceof(null));
    }

    String patternMatchingInstanceof(Object object){

        if(object instanceof ChildRecord(int number, String string, boolean bool))
            return string;

        if(object instanceof KidRecord(int number, String string))
            return string;

        if(object instanceof ParentRecord(ChildRecord childRecord, KidRecord kidRecord))
            return childRecord.string() + kidRecord.string();

        if (object instanceof ParentRecord(ChildRecord(int childNumber, String childString, boolean childBool), KidRecord(int kidNumber, String kidString)))
            return childString + kidString;

        if (object instanceof ParentRecord(ChildRecord(_, String childString, _), KidRecord(_, String kidString)))
            return childString + kidString;

        return "no match";
    }
}
