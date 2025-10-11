package Basic_concept;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorMain {
    public static void main(String[] args) {
        //// Create a list of ComparatorClass objects
        ArrayList<ComparatorClass> list = new ArrayList<>();
        list.add(new ComparatorClass("Force", 8.3, 2015));
        list.add(new ComparatorClass("Star Wars", 8.7, 1977));
        list.add(new ComparatorClass("POC", 8.8, 1980));
        list.add(new ComparatorClass("Endgame", 8.4, 1983));

        System.out.println(list);

        System.out.println("=======compare by name============");
        list.sort(Comparator.comparing(ComparatorClass::getName));
        System.out.println(list);
        System.out.println("============================================");

        System.out.println("=======compare by name and rating============");
        list.sort(Comparator.comparing(ComparatorClass::getName)
                .thenComparing(ComparatorClass::getRating));
        System.out.println(list);
        System.out.println("============================================");

        //create a custom comparator to compare via name
        Comparator<ComparatorClass> viaName=Comparator.comparing(ComparatorClass::getName);

        //create a custom comparator to compare via rating
        Comparator<ComparatorClass> viaRating=Comparator.comparing(ComparatorClass::getRating);

        //create a custom comparator to compare via year
        Comparator<ComparatorClass> viaYear=Comparator.comparing(ComparatorClass::getYear);

        //sort by using name
        list.sort(viaName);
        System.out.println(list);

        //sort by using rating
        list.sort(viaRating);
        System.out.println(list);

        //sort by using year
        list.sort(viaYear);
        System.out.println(list);

        // Sort by name, then rating, then year
        list.sort(viaName
                .thenComparing(viaRating)
                .thenComparing(viaYear));

        System.out.println(list);
    }
}
/*
Certainly! Let’s break down the flow of sorting using the thenComparing method step by step:

Initial List:
You start with a list of ComparatorClass objects containing four elements:
“Force” (Rating: 8.3, Year: 2015)
“Star Wars” (Rating: 8.7, Year: 1977)
“POC” (Rating: 8.8, Year: 1980)
“Endgame” (Rating: 8.4, Year: 1983)
Sort by Name (viaName comparator):
The list is sorted alphabetically by movie name:
“Endgame”
“Force”
“POC”
“Star Wars”
Sort by Rating (viaRating comparator):
The list is sorted by movie rating (ascending order):
“Force” (8.3)
“Endgame” (8.4)
“Star Wars” (8.7)
“POC” (8.8)
Sort by Year (viaYear comparator):
The list is sorted by release year (ascending order):
“Star Wars” (1977)
“POC” (1980)
“Endgame” (1983)
“Force” (2015)
Final Sort (thenComparing method):
You combine the sorting criteria:
First, sort by name (alphabetically).
If names are the same, sort by rating (ascending).
If ratings are also the same, sort by year (ascending).
The resulting sorted list:
“Endgame” (8.4, 1983)
“Force” (8.3, 2015)
“POC” (8.8, 1980)
“Star Wars” (8.7, 1977)
And that’s how the thenComparing method works to achieve multi-level sorting!
 */