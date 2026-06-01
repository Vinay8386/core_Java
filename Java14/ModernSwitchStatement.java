package Java14;

public class ModernSwitchStatement {
    public static void main(String[] args) {
        int day = 1;

        switch(day){
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            default -> System.out.println("Invalid Day");
        }
    }
}
