package Java14.Practice_Question;

//Write a Java program that accepts a day number (1-7) and prints the corresponding day name.
public class DayFinderUsingSwitchExpression {
    public static void main(String[] args) {
        getDayName(5);
        System.out.println(returnDay(6));
    }

    private static String returnDay(int day){
        
        return switch(day){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 ->  "Wednesday";
            case 4 ->  "Thursday";
            case 5 ->  "Friday";
            case 6 ->  "Saturday";
            case 7 ->  "Sunday";
            default -> "Invalid Day";
        };
    
    }

    private static void getDayName(int day){
        switch(day){
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 ->  System.out.println("Wednesday");
            case 4 ->  System.out.println("Thursday");
            case 5 ->  System.out.println("Friday");
            case 6 ->  System.out.println("Saturday");
            case 7 ->  System.out.println("Sunday");
            default -> System.out.println("Invalid Day");
        }
    }
    
}
