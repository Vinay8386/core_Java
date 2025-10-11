package Basic_concept;

public class Comparable_MovieClass implements Comparable<Comparable_MovieClass>{

    private double rating;
    private String name;
    private int year;

    public Comparable_MovieClass(String name, double rating, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    //Always remember you can't compare more than one compareTo method in one class otherwise you will get error like below
    //compareTo(Comparable_MovieClass)' is already defined in 'Basic_concept.Comparable_MovieClass'


   /* @Override
    public int compareTo(Comparable_MovieClass m) {
        return this.year - m.year;  //compare based on year
    }*/

    public int compareTo(Comparable_MovieClass m) {  //To compare based on name
        return this.name.compareTo(m.name);  //This compareTo method is String class method which will compare by calculating unicode
    }

    /*public int compareTo(Comparable_MovieClass m) {
        return this.year - m.year;
    }*/

    //Override toString method to print String representation of Comparable_MovieClass class
    @Override
    public String toString() {
        return "Comparable_MovieClass{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    //Getter and setter for accessing private data
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
