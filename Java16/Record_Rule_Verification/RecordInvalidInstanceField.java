package Java16.Record_Rule_Verification;

record RecordInvalidInstanceField(
        int id,
        String name) {

    //private String department; //Error: Instance fields may not be declared in a record class
}
