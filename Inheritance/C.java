package Inheritance;

interface B {
    default void sum(){
        System.out.println("sum B");
    }
    void test();
}
interface A {
    default void sum(){
        System.out.println("sum A");
    }
    void test();
}
public class C implements B, A{
    @Override
    public void sum() {
        System.out.println("implemented common default method");
    }

    @Override
    public void test() {

    }
}
