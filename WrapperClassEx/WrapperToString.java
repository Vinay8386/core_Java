package WrapperClassEx;

public class WrapperToString {
    public static void main(String[] args) {
        int a=2;
        Integer i=Integer.valueOf(4);
        System.out.println(i);
        System.out.println(i.toString());
        System.out.println(a);
        //below will give compilation error because In java we are able to call toString() method only on reference type but not primitive type.
        //System.out.println(a.toString());
    }
}
