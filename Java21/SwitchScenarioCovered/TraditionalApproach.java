package Java21.SwitchScenarioCovered;

public class TraditionalApproach {

    public static void main(String[] args) {
        
        Object obj = 20;

        if(obj instanceof String){
            String str = (String)obj;
            System.out.println(str.length());
        }

        else if(obj instanceof Integer){
            Integer num = (Integer)obj;
            System.out.println(num*num);
        }

        else if(obj instanceof Double){
            Double num = (Double)obj;
            System.out.println(Math.abs(num));
        }

        else{
            System.out.println("Unsupported Type");
        }
    }
}
