package Java21.SwitchScenarioCovered;

public class UsingSwitchExpressionAndPatternMatching {
    public static void main(String[] args) {
        Object obj = 20;

        System.out.println(checkTypeAndPerformOperation(obj));
    }

    public static String checkTypeAndPerformOperation(Object obj){

        var result = switch(obj){
            case String str -> "Length: " + str.length();
            case Integer num -> "Square: " + num * num;
            case Double d -> "Abs: " + Math.abs(d);
            default -> "Invalid";
        };
        return result; 
    }
}
