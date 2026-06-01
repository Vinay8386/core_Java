package Java14;

public class ModernSwitchExpression {
    public static void main(String[] args) {
        int day = 1; 
        String dayName = switch(day){ 
            case 1 -> "Monday"; 
            case 2 -> "Tuesday"; 
            default -> "Invalid Day"; 
        }; 
        System.out.println(dayName);
    }
}
