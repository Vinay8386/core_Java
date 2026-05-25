# Polymorphism - Method Overloading and Overriding

## Overview

This folder demonstrates polymorphism concepts including method overloading (compile-time polymorphism) and method overriding (runtime polymorphism).

## What You'll Learn

- Method overloading and resolution
- Method overriding in inheritance
- Compile-time vs runtime polymorphism
- Virtual method invocation
- Polymorphic behavior with String and StringBuffer

## Key Concepts Covered

1. **Method Overloading**: Same name, different parameters
2. **Method Overriding**: Replacing parent method in child class
3. **Compile-Time Polymorphism**: Resolved during compilation
4. **Runtime Polymorphism**: Resolved during execution
5. **Virtual Method Invocation**: Dynamic method dispatch

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `MethodOverloading.java` | Method overloading examples | Same method name, different signatures |
| `MethodOverriding.java` | Method overriding examples | Child overrides parent methods |
| `RuntimePolymorphismExample.java` | Runtime polymorphism demo | Dynamic method dispatch |
| `RuntimePolymorphismExample2.java` | Advanced polymorphism | Complex inheritance with overriding |
| `String.java` | String manipulation examples | String polymorphic behavior |
| `StringBuffer.java` | StringBuffer examples | Mutable string comparison |

## How to Run

### Method Overloading
```bash
# Compile
javac MethodOverloading.java

# Run
java MethodOverloading
```

### Method Overriding
```bash
# Compile
javac MethodOverriding.java

# Run
java MethodOverriding
```

### Runtime Polymorphism
```bash
# Compile
javac RuntimePolymorphismExample.java

# Run
java RuntimePolymorphismExample
```

## Quick Start

1. Start with `MethodOverloading.java` to understand overloading
2. Move to `MethodOverriding.java` for overriding
3. Study `RuntimePolymorphismExample.java` for dynamic dispatch
4. Compare `String.java` and `StringBuffer.java` for usage patterns

## Method Overloading Reference

### Rules for Overloading
- Same method name
- Different parameter types, count, or order
- Can differ in return type (but not alone)
- Resolved at compile time

### Overloading Example
```java
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c) { return a + b + c; }
}
```

## Method Overriding Reference

### Rules for Overriding
- Must be in child class
- Same method signature
- Same or compatible return type (covariant)
- Cannot be private or static
- Cannot narrow access modifiers

### Overriding Example
```java
class Animal {
    public void sound() { System.out.println("Generic sound"); }
}

class Dog extends Animal {
    @Override
    public void sound() { System.out.println("Bark"); }
}
```

## Important Concepts

### Compile-Time vs Runtime Polymorphism

**Compile-Time (Method Overloading)**
```java
add(5, 10);        // Calls add(int, int)
add(5.0, 10.0);    // Calls add(double, double)
add(5, 10, 15);    // Calls add(int, int, int)
```

**Runtime (Method Overriding)**
```java
Animal a = new Dog();    // Declared as Animal
a.sound();              // Calls Dog.sound() at runtime
```

### Virtual Method Invocation
- JVM determines actual method at runtime
- Based on object's runtime type, not declared type
- Enables polymorphic behavior

## Polymorphism Benefits

| Benefit | Example |
|---------|---------|
| **Code Reuse** | Use parent class methods |
| **Flexibility** | Change behavior in subclasses |
| **Extensibility** | Add new types easily |
| **Maintainability** | Centralized logic |
| **Loose Coupling** | Depend on abstractions |

## Related Topics

- For inheritance details: See [Inheritance/](../Inheritance/)
- For OOP fundamentals: See [Basic_concept/](../Basic_concept/)
- For string operations: See [StringEx/](../StringEx/)
- For modern polymorphism: See [Java21/](../Java21/) - Pattern Matching

## Prerequisites

- Understanding of inheritance
- Familiar with method definitions
- Basic OOP knowledge

## Tips for Learning

1. **Distinguish overloading from overriding**: Same name but different purposes
2. **Use @Override annotation**: Catch errors at compile time
3. **Test polymorphic calls**: See which method actually runs
4. **Use debugger**: Trace method execution
5. **Experiment with types**: Try different parameter combinations

## Common Mistakes to Avoid

1. Confusing method overloading with overriding
2. Accidentally creating overload instead of override
3. Changing return type only (not valid overloading)
4. Forgetting @Override annotation
5. Overriding static methods (creates shadowing, not overriding)

## Best Practices

1. **Always use @Override** annotation for clarity and error detection
2. **Make methods final** only if you have good reason
3. **Use overloading judiciously** - too many overloads reduce readability
4. **Maintain Liskov Substitution Principle** - derived class should be usable as parent
5. **Document polymorphic behavior** - explain which method runs when

## Advanced Topics

- **Abstract Methods**: Force subclasses to implement
- **Interfaces**: Multiple polymorphism through interface implementation
- **Sealed Classes** (Java 17): Restrict which classes can override
- **Pattern Matching** (Java 21): Type-safe polymorphic dispatch
