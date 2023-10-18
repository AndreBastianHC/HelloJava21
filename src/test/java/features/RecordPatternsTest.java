package features;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import records.*;

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

    String patternMatchingInstanceofOld(Object object) {
        if(object instanceof ChildRecord childRecord)
            return childRecord.string();
        return "no match";
    }

    @Test
    void recordPatternMatchingForSwitchTest(){

        ChildRecord childRecord = new ChildRecord(10, "Child", true);
        KidRecord kidRecord = new KidRecord(20, "Kid");
        ParentRecord parentRecord = new ParentRecord(childRecord, kidRecord);

        assertEquals("Child", recordPatternMatchingForSwitch(childRecord));
        System.out.println(recordPatternMatchingForSwitch(childRecord));

        assertEquals("Kid", recordPatternMatchingForSwitch(kidRecord));
        System.out.println(recordPatternMatchingForSwitch(kidRecord));

        assertEquals("ChildKid", recordPatternMatchingForSwitch(parentRecord));
        System.out.println(recordPatternMatchingForSwitch(parentRecord));

        assertEquals("no match", recordPatternMatchingForSwitch(5));
        System.out.println(recordPatternMatchingForSwitch(5));
    }

    String recordPatternMatchingForSwitch(@NotNull Object object){
        switch (object) {
            case ChildRecord(int number, String string, boolean bool) -> { return string; }
            case KidRecord(int number, String string) -> {return string; }
            case ParentRecord(ChildRecord(int childNumber, String childString, boolean childBool), KidRecord(int kidNumber, String kidString)) -> { return childString+kidString; }
            //case ParentRecord(ChildRecord(_,var childString,_),_) -> {return childString + "unnamed variable"; }
            default -> { return "no match"; }
        }
    }

    String recordPatternMatchingForSwitchOld(@NotNull Object object){
        switch (object) {
            case ChildRecord childRecord -> { return childRecord.string(); }
            default -> { return "no match"; }
        }
    }

    @Test
    void recordPatternMatchingForSwitchInterfaceTest(){

        ChildRecord childRecord = new ChildRecord(10, "Child", true);
        KidRecord kidRecord = new KidRecord(20, "Kid");
        ParentRecord parentRecord = new ParentRecord(childRecord, kidRecord);

        assertEquals("Child", recordPatternMatchingForSwitchInterface(childRecord));
        System.out.println(recordPatternMatchingForSwitchInterface(childRecord));

        assertEquals("Kid", recordPatternMatchingForSwitchInterface(kidRecord));
        System.out.println(recordPatternMatchingForSwitchInterface(kidRecord));

        assertEquals("ChildKid", recordPatternMatchingForSwitchInterface(parentRecord));
        System.out.println(recordPatternMatchingForSwitchInterface(parentRecord));
    }

    String recordPatternMatchingForSwitchInterface(ExampleRecord exampleRecord){
        switch (exampleRecord) {
            case ChildRecord(int number, String string, boolean bool) -> { return string; }
            case KidRecord(int number, String string) -> {return string; }
            case ParentRecord(ChildRecord(int childNumber, String childString, boolean childBool), KidRecord(int kidNumber, String kidString)) -> { return childString+kidString; }
            /*case ParentRecord(ChildRecord(_,var childString,_),_) -> { return childString + " unnamed variable"; }*/
        }
    }

    @Test
    void recordPatternMatchingForSwitchInterfaceOfChildrenTest(){
        Mammal dog = new Dog();
        Mammal cat = new Cat();
        Mammal horse = new Horse();
        PetOwner dogOwner = new PetOwner(dog);
        PetOwner catOwner = new PetOwner(cat);
        PetOwner horseOwner = new PetOwner(horse);

        assertEquals("wuff",recordPatternMatchingForSwitchInterfaceOfChildren(dogOwner));
        System.out.println(recordPatternMatchingForSwitchInterfaceOfChildren(dogOwner));

        assertEquals("miau",recordPatternMatchingForSwitchInterfaceOfChildren(catOwner));
        System.out.println(recordPatternMatchingForSwitchInterfaceOfChildren(catOwner));

        assertEquals("wieher",recordPatternMatchingForSwitchInterfaceOfChildren(horseOwner));
        System.out.println(recordPatternMatchingForSwitchInterfaceOfChildren(horseOwner));

    }

    String recordPatternMatchingForSwitchInterfaceOfChildren(PetOwner petOwner){
       switch (petOwner){
           case PetOwner(Dog dog) -> { return "wuff"; }
           case PetOwner(Cat cat) -> { return "miau"; }
           case PetOwner(Horse horse) -> { return "wieher"; }
       }
    }
}
