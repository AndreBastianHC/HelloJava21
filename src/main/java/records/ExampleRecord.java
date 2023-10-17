package records;

public sealed interface ExampleRecord permits ChildRecord, KidRecord, ParentRecord {
}
