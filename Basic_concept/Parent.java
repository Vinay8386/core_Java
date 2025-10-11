package Basic_concept;

public class Parent {
    Parent(int i){
        System.out.println("this is parent class param cons");
    }
    Parent(){
        System.out.println("this is parent class default cons");
    }
}
class Child extends Parent{
    Child(){
        this(10);
        System.out.println("child 0 arg");
    }
    Child(int a){
        super(10);
        System.out.println("child 1 arg");
    }
}
