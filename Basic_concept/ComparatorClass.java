package Basic_concept;

public class ComparatorClass {

    private double rating;
    private String name;
    private int year;

    public ComparatorClass(String name, double rating, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

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
