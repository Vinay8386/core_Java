package Basic_concept;

import java.util.ArrayList;
import java.util.Collections;

public class Comparable_Main {
    public static void main(String[] args) {
        ArrayList<Comparable_MovieClass> list = new ArrayList<>();
        list.add(new Comparable_MovieClass("Force", 8.3, 2015));
        list.add(new Comparable_MovieClass("Star Wars", 8.7, 1977));
        list.add(new Comparable_MovieClass("POC", 8.8, 1980));
        list.add(new Comparable_MovieClass("Endgame", 8.4, 1983));

        System.out.println(list);

        Collections.sort(list); //By doing this Collection will check how to compare list and short either by name or year or by rating
        //So I created method compareTo in our object class, and based on our requirement I will give logic

        System.out.println(list);
    }
}
