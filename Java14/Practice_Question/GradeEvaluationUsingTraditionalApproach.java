package Java14.Practice_Question;


//Write a Java program that accepts a student's grade (A, B, C, or D) and displays the corresponding performance message.
public class GradeEvaluationUsingTraditionalApproach {
    public static void main(String[] args) {
        
        //create an array 
        /* 
        char[] gradeArray = {'A', 'B', 'C', 'D'};
        for(var ch: gradeArray){
            System.out.println(getPerformance(ch));
        }*/

        //to see switch with break
        System.out.println(getPerformance('B'));

        printStudentPerformance('C');
    }

    private static void printStudentPerformance(char ch){
        switch(ch){
            case 'A':
                System.out.println("Good Student");
                break;
            case 'B':
                System.out.println("Average Student");
                break;
            case 'C':
                System.out.println("Below Average");
                break;
            default:
                System.out.println("Enter valid Grade");
                break;
        }
    }

    private static String getPerformance(char ch){
        switch(ch){
            case 'A':
                return "Grade is A and Student is perfect";
            case 'B':
                return "Grade is B and Student is Ok";
            case 'C':
                return "Grade is C and Student is Average";
            case 'D':
                return "Grade is D and Student is below average";
            default:
                return "Invalid Grade";
        }
    }
}
