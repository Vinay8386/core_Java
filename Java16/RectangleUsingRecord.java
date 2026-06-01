package Java16;

record RectangleUsingRecord(double length, double width) {
    public static void main(String[] args) {
        RectangleUsingRecord record = new RectangleUsingRecord(10, 20);
        System.out.println(record.length());
        System.out.println(record.width);
    }
}
