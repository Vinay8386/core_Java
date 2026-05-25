# Java16 - Records

## Overview

Java 16 introduced records, a concise way to define immutable data carrier classes. Records automatically generate constructors, getters, toString(), equals(), and hashCode() methods, reducing boilerplate code significantly.

## What You'll Learn

- Record declaration and syntax
- Automatic method generation
- Canonical constructors
- Compact constructors
- Records vs traditional classes
- When to use records vs classes
- Record patterns and destructuring

## Key Concepts Covered

1. **Record Syntax**: Immutable data carriers with minimal syntax
2. **Automatic Methods**: Constructor, getters, toString, equals, hashCode
3. **Canonical Constructor**: Primary constructor with validation
4. **Compact Constructor**: Simplified constructor syntax
5. **Immutability**: Records are inherently immutable
6. **Pattern Matching**: Destructuring support (Java 21+)

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `RecordClass.java` | Record definition and usage | Basic record syntax |
| `Rectangle.java` | Traditional class implementation | Compare with record version |
| `RectangleUsingRecord.java` | Same logic as Rectangle, using record | Record syntax advantages |
| `README_Java16.md` | Detailed Java 16 documentation | Comprehensive reference |
| `RecordClassNotes` | Additional notes on records | Learning material |

## How to Run

### Record Class Example
```bash
javac RecordClass.java
java RecordClass
```

### Traditional vs Record Comparison
```bash
javac Rectangle.java RectangleUsingRecord.java
java Rectangle
java RectangleUsingRecord
```

## Quick Start

1. Study `Rectangle.java` - traditional class with getters, toString, equals
2. Compare with `RectangleUsingRecord.java` - same functionality, record syntax
3. See code reduction and clarity improvement
4. Run both to verify identical behavior
5. Check `README_Java16.md` for detailed explanation

## Record Syntax

### Basic Record Declaration
```java
// Before Java 16 - Traditional Class
public class Point {
    private final int x;
    private final int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int x() { return x; }
    public int y() { return y; }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString() {
        return "Point(x=" + x + ", y=" + y + ")";
    }
}

// Java 16+ - Record
public record Point(int x, int y) {}
```

### Record with Canonical Constructor
```java
public record Person(String name, int age) {
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age must be positive");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
    }
}
```

### Record with Compact Constructor
```java
// Compact constructor syntax (Java 16+)
public record Rectangle(double width, double height) {
    // Compact constructor - parameters automatically assigned
    public Rectangle {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive");
        }
    }
}
```

## Record Features

### Automatic Method Generation

```java
public record Book(String title, String author, int pages) {}

// Generates automatically:
// - Constructor: Book(String title, String author, int pages)
// - Accessor methods: title(), author(), pages()
// - toString(): "Book[title=..., author=..., pages=...]"
// - equals(): Compares all components
// - hashCode(): Computed from all components

// Usage
Book book = new Book("Java Guide", "John Doe", 500);
System.out.println(book.title());      // "Java Guide"
System.out.println(book);              // "Book[title=Java Guide, author=John Doe, pages=500]"
```

### Accessors (not getters)
```java
Point p = new Point(3, 4);
System.out.println(p.x());  // Accessor method (not getX())
System.out.println(p.y());  // Accessor method (not getY())
```

## Traditional Class vs Record Comparison

| Feature | Traditional Class | Record |
|---------|------------------|--------|
| **Lines of Code** | 20+ | 1-2 |
| **Constructor** | Manual | Auto-generated |
| **Getters** | Manual | Auto-generated |
| **toString()** | Manual | Auto-generated |
| **equals()** | Manual | Auto-generated |
| **hashCode()** | Manual | Auto-generated |
| **Mutable** | Yes (by design) | No (immutable) |
| **Inheritance** | Can extend | Extends Record (implicitly) |
| **Fields** | Any | Final components only |

## Record Restrictions

```java
// Records CANNOT:
// 1. Extend other classes (except implicitly extend Record)
public record Bad1(int x) extends Point {}  // ERROR

// 2. Implement initialization blocks
public record Bad2(int x) {
    { System.out.println("Init"); }  // ERROR
}

// 3. Declare instance fields (only components)
public record Bad3(int x) {
    private int y;  // ERROR
}

// 4. Be extended by other records
public record Base(int x) {}
public record Derived(int x, int y) extends Base {}  // ERROR

// Records CAN:
// 1. Implement interfaces
public record Good1(int x) implements Comparable<Good1> {}

// 2. Declare static fields and methods
public record Good2(int x) {
    public static int DEFAULT_X = 0;
    public static Good2 createDefault() { return new Good2(DEFAULT_X); }
}

// 3. Override auto-generated methods
public record Good3(int x) {
    @Override
    public String toString() { return "Custom: " + x; }
}
```

## Record Advantages

1. **Less Boilerplate**: 90% less code for simple data carriers
2. **Safer**: Immutability by design
3. **Clearer Intent**: Purpose is obvious
4. **Proper Defaults**: Automatic equals/hashCode/toString
5. **Easier Maintenance**: Less code to maintain

## Use Cases for Records

✅ **Perfect for:**
- Data transfer objects (DTOs)
- API request/response objects
- Configuration containers
- Value objects
- Database query results
- Immutable data holders

❌ **Not suitable for:**
- Complex domain objects
- Mutable entities
- Classes with many behaviors
- Deep inheritance hierarchies
- Classes requiring complex initialization

## Related Topics

- For pattern matching with records: See [Java21/](../Java21/)
- For sealed classes: See [Java17/](../Java17/)
- For immutable design: See [Java15/](../Java15/) Text Blocks
- For detailed documentation: See `README_Java16.md`

## Prerequisites

- Understanding of classes and immutability
- Familiar with value objects
- Java 16+ compiler required

## Tips for Learning

1. **Compare with traditional class**: Appreciate the reduction
2. **Use for DTOs**: Perfect use case
3. **Try custom constructor**: Add validation
4. **Implement interface**: Add behavior while keeping data structure
5. **Pattern matching** (Java 21+): Destructure in switch

## Common Mistakes to Avoid

1. Adding mutable fields to records
2. Trying to add instance initialization blocks
3. Extending records (impossible)
4. Using records for complex objects
5. Forgetting records are immutable

## Best Practices

1. **Use records for data carriers**: When class is mostly data
2. **Add validation in constructor**: Ensure consistency
3. **Implement interfaces when needed**: Add behavior
4. **Use pattern matching** (Java 21+): When destructuring
5. **Keep records simple**: Move complex logic to services

## Code Comparison Example

### Employee Class - Before Record
```java
public class Employee {
    private final String id;
    private final String name;
    private final double salary;
    
    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public String id() { return id; }
    public String name() { return name; }
    public double salary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', salary=" + salary + "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        return salary == emp.salary && id.equals(emp.id) && name.equals(emp.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
```

### Employee Record - After Java 16
```java
public record Employee(String id, String name, double salary) {}
```

## Advanced Topics

- **Sealed Records**: Combine with sealed classes for type hierarchies
- **Record Patterns** (Java 21): Destructure in pattern matching
- **Generic Records**: Records with type parameters
- **Record Serialization**: Special serialization considerations
