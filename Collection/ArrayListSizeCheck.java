package Collection;

import java.util.ArrayList;

public class ArrayListSizeCheck {
    public static void main(String[] args) {

        ArrayList<Integer> list=new ArrayList<>(); //capacity or default_size is 10
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(list);
        System.out.println(list.size()); //size() return number of an element
        list.add(9); //now the capacity will be 20
    }
}
