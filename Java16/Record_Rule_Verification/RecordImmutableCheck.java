package Java16.Record_Rule_Verification;

record RecordImmutableCheck(
        int id,
        String name) {

    public void updateName() {
        //name = "Rahul";         //cannot assign a value to final variable name
    }
}
