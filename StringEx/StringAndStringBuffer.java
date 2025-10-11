package StringEx;

public class StringAndStringBuffer {
    public static void main(String[] args)
    {
        String str="Vinay is is a";
        //returns the index (position) of the first occurrence of the substring within the string
        System.out.println(str.indexOf("is"));
        //returns the index (position) of the last occurrence of the substring within the string.
        System.out.println(str.lastIndexOf("is"));
        System.out.println(str.substring(2,4));

        StringBuffer s=new StringBuffer("Vinay is is ");
        System.out.println(s);
        System.out.println(s.delete(1,3));
        System.out.println(s.deleteCharAt(1));
        System.out.println(s.reverse());
        s.reverse();
        System.out.println(s.append("Kumar"));
        System.out.println(s.insert(1,"ina"));
        System.out.println(s.indexOf("is"));
        System.out.println(s.lastIndexOf("is"));
    }
}
