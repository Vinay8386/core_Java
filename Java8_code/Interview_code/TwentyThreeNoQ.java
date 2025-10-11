package Java8.InterviewQuestion;

import java.util.*;
import java.util.stream.Collectors;

//How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
public class TwentyThreeNoQ {
    public static void main(String[] args) {
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));
        noteLst.add(new Notes(6, "note4", 66));


    }
}