package Basic_concept;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        ArrayList<Test> list=new ArrayList<>();
        list.add(new Test(1,"Saloni",10000));
        list.add(new Test(2,"Vinay",20000));
        list.add(new Test(3,"Aman",30000));
        list.add(new Test(4,"Raju",40000));

        System.out.println("list1 is "+list);

        ArrayList<Test> list2=new ArrayList<>();
        list2.add(new Test(1,"Saloni"));
        list2.add(new Test(2,"Vinay"));
        list2.add(new Test(3,"Aman"));
        list2.add(new Test(4,"Raju"));
        System.out.println("list2 is "+list2);

        ArrayList<Test> list3=new ArrayList<>();
        list3.add(new Test(1));
        list3.add(new Test(2));
        list3.add(new Test(3));
        list3.add(new Test(4));
        System.out.println("list3 is "+list3);
    }
}
