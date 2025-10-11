package Java8.InterviewQuestion;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//How will you get the current date and time using Java 8 Date and Time API?
public class EighteenthQ {
    public static void main(String[] args) {
        System.out.println("Current date is : "+LocalDate.now());
        System.out.println("Current time is : "+ LocalTime.now());
        System.out.println("Current date & time is : "+ LocalDateTime.now());
    }
}
