package Java14.Practice_Question;

public class GradeEvaluationUsingSwitchExpression {

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
            case 'A'-> System.out.println("Good Student");
            case 'B'-> System.out.println("Average Student");
            case 'C'-> System.out.println("Below Average");
            default -> System.out.println("Enter valid Grade");
        }
    }

    private static String getPerformance(char ch){
        String result = switch(ch){
            case 'A' -> "Grade is A and Student is perfect";
            case 'B' -> "Grade is B and Student is Ok";
            case 'C' -> "Grade is C and Student is Average";
            case 'D' -> "Grade is D and Student is below average";
            default -> "Invalid Grade";
        };

        return result;
    }
    
}
