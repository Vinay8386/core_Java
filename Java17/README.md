# Java17 - Sealed Classes

## Overview

Java 17 introduced sealed classes, allowing developers to control which classes can extend or implement a given class or interface. This provides fine-grained control over inheritance hierarchies and enables more precise modeling of domain concepts.

## What You'll Learn

- Sealed class declaration and usage
- Permitted subclasses specification
- Sealed interfaces and their uses
- Pattern matching with sealed classes
- Benefits and constraints of sealed classes
- Sealed class design patterns

## Key Concepts Covered

1. **Sealed Keyword**: Restrict which classes can extend
2. **Permits Clause**: Specify allowed subclasses
3. **Inheritance Control**: Fine-grained access control
4. **Type Safety**: Exhaustiveness checking in switch
5. **Pattern Matching**: Works with sealed hierarchies
6. **Domain Modeling**: Express business constraints

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `PaymentSystem.java` | Payment type sealed class hierarchy | Type-safe payment processing |
| `ShapeAreaCalculator.java` | Shape sealed class with area calculation | Sealed class polymorphism |
| `SealedClasses_Notes` | Detailed documentation on sealed classes | Learning material |

## How to Run

### Payment System Example
```bash
javac PaymentSystem.java
java PaymentSystem
```

### Shape Area Calculator Example
```bash
javac ShapeAreaCalculator.java
java ShapeAreaCalculator
```

## Quick Start

1. Study `PaymentSystem.java` - Sealed payment types
2. Review `ShapeAreaCalculator.java` - Sealed shape hierarchy
3. Understand permits clause
4. See pattern matching integration
5. Check `SealedClasses_Notes` for detailed concepts

## Sealed Class Syntax

### Basic Sealed Class
```java
// Before Java 17 - No inheritance control
public class Payment {
    // Could be extended by anyone
}

// Java 17+ - Sealed Class
public sealed class Payment permits CreditCardPayment, PayPalPayment, BitcoinPayment {
    // Only these three classes can extend
    // ...
}

// Permitted implementations
public final class CreditCardPayment extends Payment {
    // Final - cannot be extended further
}

public non-sealed class PayPalPayment extends Payment {
    // Can be extended by anyone
}

public sealed class BitcoinPayment extends Payment permits SignedBitcoinPayment {
    // Can only be extended by SignedBitcoinPayment
}
```

## Permitted Subclass Rules

```java
// Subclass MUST:
// 1. Be in same package (or use different module rules)
// 2. Have explicit declaration as final, non-sealed, or sealed

// Valid permutations
public sealed class Shape permits Circle, Rectangle, Triangle {}

public final class Circle extends Shape {}       // ✓ Final

public non-sealed class Rectangle extends Shape {} // ✓ Non-sealed

public sealed class Triangle extends Shape 
    permits RightTriangle {}                   // ✓ Sealed

// Invalid
public class Square extends Shape {}            // ✗ Must be final/non-sealed/sealed
```

## Sealed Interfaces

```java
// Sealed interface - controls implementations
public sealed interface Animal permits Dog, Cat, Bird {
    void makeSound();
}

// Implementing classes
public final class Dog implements Animal {
    public void makeSound() { System.out.println("Woof"); }
}

public non-sealed class Cat implements Animal {
    public void makeSound() { System.out.println("Meow"); }
}

public sealed class Bird implements Animal permits Parrot {
    public void makeSound() { System.out.println("Tweet"); }
}
```

## Sealed Class Hierarchy Example

```java
public sealed class Vehicle permits Car, Truck, Motorcycle {
    public abstract String getType();
}

public final class Car extends Vehicle {
    @Override public String getType() { return "Car"; }
}

public final class Truck extends Vehicle {
    @Override public String getType() { return "Truck"; }
}

public sealed class Motorcycle extends Vehicle permits SportsBike {
    @Override public String getType() { return "Motorcycle"; }
}

public final class SportsBike extends Motorcycle {}
```

## Benefits of Sealed Classes

| Benefit | Description |
|---------|------------|
| **Type Safety** | Compiler knows all possible subtypes |
| **Domain Modeling** | Accurately express design intent |
| **Pattern Matching** | Exhaustive switch without default |
| **Maintainability** | Control who extends your class |
| **Security** | Prevent unauthorized subclassing |
| **Optimization** | JVM can optimize knowing possible types |

## Pattern Matching with Sealed Classes

```java
public record PaymentResult(Payment payment, boolean success) {}

// Without sealed classes - need default case
String result = switch (payment) {
    case CreditCardPayment cc -> "Processed credit card";
    case PayPalPayment pp -> "Processed PayPal";
    case BitcoinPayment b -> "Processed Bitcoin";
    default -> "Unknown payment";  // Always needed
};

// With sealed classes - exhaustive matching
String result = switch (payment) {
    case CreditCardPayment cc -> "Processed credit card";
    case PayPalPayment pp -> "Processed PayPal";
    case BitcoinPayment b -> "Processed Bitcoin";
    // Default case NOT needed - compiler knows all types
};
```

## Design Patterns

### Strategy Pattern with Sealed Classes
```java
public sealed interface PaymentStrategy permits CreditCardStrategy, PayPalStrategy {
    void processPayment(double amount);
}

public final class CreditCardStrategy implements PaymentStrategy {
    public void processPayment(double amount) {
        // Credit card processing
    }
}

public final class PayPalStrategy implements PaymentStrategy {
    public void processPayment(double amount) {
        // PayPal processing
    }
}
```

### Template Method with Sealed Classes
```java
public sealed abstract class DataProcessor permits JSONProcessor, XMLProcessor {
    public final void process(String data) {
        validate(data);
        parse(data);
        save(data);
    }
    
    protected abstract void parse(String data);
}
```

## Sealed vs Final vs Non-sealed

| Modifier | Inheritance | Use Case |
|----------|-----------|----------|
| **final** | No subclasses | Leaf nodes, prevent extension |
| **sealed** | Only specified classes | Control hierarchy, domain boundaries |
| **non-sealed** | Any subclass | Intermediate nodes, open for extension |

## Important Concepts

### Permits Clause Location
```java
// Same file (no issue)
public sealed class A permits B {}
public final class B extends A {}

// Different files - must be in same package
// File: com/example/A.java
public sealed class A permits B, C {}

// File: com/example/B.java
public final class B extends A {}

// File: com/example/C.java
public final class C extends A {}
```

### Sealed with Records
```java
public sealed interface Result permits SuccessResult, ErrorResult {}

public record SuccessResult(Object data) implements Result {}

public record ErrorResult(String message) implements Result {}

// Pattern matching
Result result = getResult();
String output = switch (result) {
    case SuccessResult s -> "Success: " + s.data();
    case ErrorResult e -> "Error: " + e.message();
};
```

## Related Topics

- For pattern matching: See [Java21/](../Java21/)
- For records: See [Java16/](../Java16/)
- For switch expressions: See [Java14/](../Java14/)
- For design patterns: See [Singleton_6_Ways](../Singleton_6_Ways)

## Prerequisites

- Understanding of inheritance and polymorphism
- Familiar with design patterns
- Java 17+ compiler required

## Tips for Learning

1. **Model domains carefully**: Use sealed when expressing type boundaries
2. **Combine with records**: Perfect for type hierarchies
3. **Use pattern matching**: Leverage exhaustiveness checking
4. **Think about permits**: Plan class hierarchy before coding
5. **Enable compiler checks**: Use sealed to catch missing cases

## Common Mistakes to Avoid

1. Forgetting permits clause (no inheritance control)
2. Mixing final and sealed in wrong combinations
3. Not planning hierarchy before sealing
4. Using sealed for implementation details (too restrictive)
5. Forgetting to update permits when adding classes

## Best Practices

1. **Use sealed for domain boundaries**: Express valid type hierarchies
2. **Combine with pattern matching**: Maximum type safety
3. **Use records + sealed**: Clean, type-safe data types
4. **Document permits clearly**: Explain design intent
5. **Keep hierarchies shallow**: Avoid deep sealed chains

## Real-World Examples

### Expression Evaluator
```java
public sealed interface Expression 
    permits NumberExpression, BinaryExpression, UnaryExpression {}

public record NumberExpression(double value) implements Expression {}

public record BinaryExpression(Expression left, String op, Expression right) 
    implements Expression {}

public record UnaryExpression(String op, Expression operand) implements Expression {}

// Pattern matching during evaluation
double evaluate(Expression expr) {
    return switch (expr) {
        case NumberExpression(var v) -> v;
        case BinaryExpression(var l, var op, var r) -> 
            evaluateBinary(evaluate(l), op, evaluate(r));
        case UnaryExpression(var op, var e) -> 
            evaluateUnary(op, evaluate(e));
    };
}
```

## Advanced Topics

- **Record Patterns with Sealed**: Destructuring sealed types
- **Sealed Module System**: Module-level sealing
- **Exhaustiveness Checking**: Compiler enforcement
- **Parametric Sealed Classes**: Generic sealed hierarchies
