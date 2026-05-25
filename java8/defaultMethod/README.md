# java8/defaultMethod - Default and Static Methods in Interfaces

## Overview

Java 8 introduced default methods in interfaces, allowing interface methods to have implementations. This enables interface evolution without breaking existing implementations and introduces static methods in interfaces.

## What You'll Learn

- Default method syntax and implementation
- Static methods in interfaces
- Method resolution order with defaults
- Diamond problem with multiple inheritance
- When to use default methods
- Overriding default methods
- Interface evolution

## Key Concepts Covered

1. **Default Methods**: Interface methods with implementation
2. **Static Methods**: Interface-level utility methods
3. **Multiple Inheritance**: Resolving conflicting defaults
4. **Backward Compatibility**: Extending interfaces safely
5. **Method Resolution Order**: Which default executes

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `Test.java` | Default method examples and usage | Implementation and behavior |

## How to Run

```bash
javac Test.java
java Test
```

## Default Method Syntax

### Basic Default Method
```java
interface Animal {
    // Abstract method (no implementation)
    void eat();
    
    // Default method (with implementation)
    default void sleep() {
        System.out.println("Zzz");
    }
}

class Dog implements Animal {
    public void eat() {
        System.out.println("Dog eats");
    }
    
    // sleep() is inherited from interface
}
```

### Overriding Default Methods
```java
interface Animal {
    default void sleep() {
        System.out.println("Zzz");
    }
}

class Dog implements Animal {
    @Override
    public void sleep() {
        System.out.println("Dog sleeps in kennel");
    }
}
```

## Static Methods in Interfaces

```java
interface StringUtils {
    static String toUpperCase(String str) {
        return str.toUpperCase();
    }
    
    static String toLowerCase(String str) {
        return str.toLowerCase();
    }
}

// Usage - called on interface name
String upper = StringUtils.toUpperCase("hello");  // "HELLO"
```

## Multiple Inheritance and Defaults

### Simple Case - No Conflict
```java
interface A {
    default void test() {
        System.out.println("A");
    }
}

interface B {
    default void hello() {
        System.out.println("B");
    }
}

class C implements A, B {
    // No conflict - different method names
}
```

### Diamond Problem - Conflict
```java
interface A {
    default void test() {
        System.out.println("A");
    }
}

interface B extends A {
    // Inherits test() from A
}

interface C extends A {
    default void test() {
        System.out.println("C");
    }
}

class D implements B, C {
    // ERROR: Conflict - both B and C provide test()
    // MUST override and resolve
    @Override
    public void test() {
        C.super.test();  // Choose C's implementation
    }
}
```

## Benefits of Default Methods

| Benefit | Example |
|---------|---------|
| **Interface Evolution** | Add methods without breaking implementations |
| **Backward Compatibility** | Old code still works |
| **Code Reuse** | Share common logic |
| **Reduce Boilerplate** | Less empty implementation classes |

## Important Concepts

### Method Resolution Order
1. Class's own method
2. Superclass method
3. Interface defaults (if multiple, must resolve)

### Choosing Between Defaults
```java
interface A {
    default void test() { System.out.println("A"); }
}

interface B {
    default void test() { System.out.println("B"); }
}

class C implements A, B {
    @Override
    public void test() {
        A.super.test();  // Explicitly choose A's version
    }
}
```

## Use Cases for Default Methods

### Utility Methods
```java
interface Collection<T> {
    default void forEach(Consumer<T> action) {
        for (T item : this) {
            action.accept(item);
        }
    }
}
```

### Evolution
```java
// Version 1
interface DataService {
    List<User> getUsers();
}

// Version 2 - adding method with default
interface DataService {
    List<User> getUsers();
    
    default List<User> getUsersLimit(int limit) {
        return getUsers().stream().limit(limit).collect(Collectors.toList());
    }
}
// Existing implementations still work!
```

## Related Topics

- For functional interfaces: See [java8/](../)
- For practical usage: See [java8/StreamApiConcept/](../StreamApiConcept/)

## Prerequisites

- Understanding of interfaces
- Familiar with inheritance
- Java 8+ required

## Tips for Learning

1. **Understand motivation**: Why default methods were added
2. **Learn resolution order**: When multiple defaults exist
3. **Practice overriding**: Override defaults when needed
4. **Use static methods**: For utility functions
5. **Maintain backward compatibility**: Design for evolution

## Common Mistakes to Avoid

1. Forgetting to override conflicting defaults
2. Using super incorrectly (A.super vs super)
3. Adding implementation when default needed
4. Not marking methods as default
5. Assuming defaults replace abstract methods

## Best Practices

1. **Use defaults for backward compatibility**: When extending interfaces
2. **Keep defaults simple**: Complex logic belongs in classes
3. **Document behavior**: What default does
4. **Resolve conflicts explicitly**: Be clear which default is used
5. **Use static methods**: For utility/factory methods

## Evolution Strategy

```java
// Initial Interface
public interface List<E> {
    void forEach(Consumer<E> action);  // Abstract
}

// After Java 8
public interface List<E> {
    default void forEach(Consumer<E> action) {
        for (E e : this)
            action.accept(e);
    }
}
// Existing code works without change!
```

## Advanced Topics

- **Interface Inheritance**: Defaults with interface extends
- **Diamond Problem Resolution**: Complex multiple inheritance
- **Functional Interface Defaults**: Combining lambdas with defaults
- **Type Classes with Defaults**: Scala-like patterns in Java
