package Java14;

public class TraditionalSwitchExpression {
    public static void main(String[] args) {
        int day = 1;
        String dayName;

        switch(day){
            case 1:
                dayName = "Monday";
                break;

            case 2:
                dayName = "Tuesday";
                break;

            default:
                dayName = "Invalid Day";
        }

        System.out.println(dayName);
    }
}
