package Constructor;

public class CopyValueInConstructor {
    //take 3 variable of a student
    int sid;
    String sname;
    int smarks;
    CopyValueInConstructor(int sid,String sname,int smarks)
    {
        this.sid=sid; this.sname=sname; this.smarks=smarks;
    }
    CopyValueInConstructor(CopyValueInConstructor s) //constructor expected CopyValueInConstructor object
    {
        this.sid=s.sid; this.sname=s.sname; this.smarks=s.smarks;
    }
    void disp()
    {
        System.out.println("****student Details****");
        System.out.println("student name = "+sname);
        System.out.println("student id = "+sid);
        System.out.println("student mrks = "+smarks);
    }
    public static void main(String[] args)
    {
        CopyValueInConstructor s = new CopyValueInConstructor(111,"ratan",100);
        CopyValueInConstructor s1 = new CopyValueInConstructor(s); //constructor is taking Student object
        s.disp();
        s1.disp();
    }
}
