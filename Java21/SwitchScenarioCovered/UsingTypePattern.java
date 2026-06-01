package Java21.SwitchScenarioCovered;

public class UsingTypePattern {
    public static void main(String[] args) {
        Object obj = 20;

        if(obj instanceof String str){
            System.out.println(str.length());
        }

        else if(obj instanceof Integer num){
            System.out.println(num*num);
        }

        else if(obj instanceof Double num){
            System.out.println(Math.abs(num));
        }

        else{
            System.out.println("Unsupported Type");
        }
    }
}
