package Java14.Practice_Question;

//Write a Java program that accepts a day number (1-7) and prints the corresponding day name.
public class DayFinderTraditionalApproach {
    public static void main(String[] args) {
        getDayName(5);
        System.out.println(returnDay(6));
    }

    private static String returnDay(int day){
        
        switch(day){
            case 1:
                return "Monday";

            case 2:
                return "Tuesday";

            case 3:
                return "Wednesday";

            case 4:
                return "Thursday";

            case 5:
                return "Friday";

            case 6:
                return "Saturday";

            case 7:
                return "Sunday";
            default:
                return "Invalid Day";
        }
    
    }

    private static void getDayName(int day){
        switch(day){
            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            case 4:
                System.out.println("Thursday");
                break;

            case 5:
                System.out.println("Friday");
                break;

            case 6:
                System.out.println("Saturday");
                break;

            case 7:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Day is Invalid");
                break;
        }
    }
    
}
