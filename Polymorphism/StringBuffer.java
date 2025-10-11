package Polymorphism;

//we will override equals method of object class and will use same implementation
public class StringBuffer {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
        //no custom implementation (so it will compare reference like object class)
    }
}
