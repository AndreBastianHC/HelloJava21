package records;

public record ParentRecord(ChildRecord childRecord, KidRecord kidRecord) implements ExampleRecord {
}
