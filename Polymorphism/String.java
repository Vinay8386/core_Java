package Polymorphism;

//we will override equals method of object class and will give custom implementation
public class String {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||
                getClass() != o.getClass())
            return false;
        return false;
        //we have custom implemantation and it will compare content
    }
}
