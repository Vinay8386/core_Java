import java.util.Objects;

// Basic record with components
public record Person(String name, int age) implements Comparable<Person> {

    // Compact constructor for validation
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

    // Custom constructor
    public Person(String name) {
        this(name, 0);
    }

    // Instance method
    public boolean isAdult() {
        return age >= 18;
    }

    // Static method
    public static Person create(String name, int age) {
        return new Person(name, age);
    }

    // Overriding toString for custom representation
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    // Implementing Comparable
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    // Nested record
    public record Address(String street, String city) {
        // Compact constructor
        public Address {
            Objects.requireNonNull(street);
            Objects.requireNonNull(city);
        }
    }
}

// Generic record
public record Pair<T, U>(T first, U second) {
    // Static factory method
    public static <T, U> Pair<T, U> of(T first, U second) {
        return new Pair<>(first, second);
    }
}

// Record with annotations (example with @Deprecated)
@Deprecated
public record LegacyData(String value) {}

// Record implementing an interface with default methods
interface Displayable {
    default String display() {
        return "Displayable";
    }
}

public record Item(String name, double price) implements Displayable {
    @Override
    public String display() {
        return name + ": $" + price;
    }
}