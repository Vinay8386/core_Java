package Java16.Record_Rule_Verification;

record RecordInvalidInstanceBlock(
        int id,
        String name) {

    /* 
    {
        System.out.println("Instance Block"); //compilation error
    }*/
}
