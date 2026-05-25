# Inheritance - Inheritance Hierarchy Patterns

## Overview

This folder demonstrates inheritance implementation patterns and multi-level class hierarchies in Java.

## What You'll Learn

- Inheritance basics and class hierarchies
- Single inheritance patterns
- Method overriding in inheritance
- Parent-child relationships
- Inheritance design principles

## Key Concepts Covered

1. **Single Inheritance**: One class extending another
2. **Multi-level Inheritance**: Classes forming chains
3. **Method Overriding**: Replacing parent behavior
4. **Access Modifiers**: Controlling inheritance visibility
5. **Super Keyword**: Accessing parent class members

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `C.java` | Multi-level inheritance example | Inheritance chains, method resolution |

## How to Run

```bash
# Compile
javac C.java

# Run
java C
```

## Expected Output

The program demonstrates:
- Class hierarchy structure
- Method overriding behavior
- Member access in inheritance chain
- Inheritance method resolution order

## Quick Start

1. Run the example to see inheritance in action
2. Study the class hierarchy
3. Modify methods to understand overriding
4. Add new methods to demonstrate extension

## Inheritance Hierarchy Concepts

### Class Hierarchy Diagram
```
Object (implicit parent)
  ↓
Class A (explicit class)
  ↓
Class B extends A
  ↓
Class C extends B
```

### Method Resolution Order (MRO)
1. Current class method
2. Parent class method
3. Grandparent class method
4. Continue up to Object

## Related Topics

- For OOP fundamentals: See [Basic_concept/](../Basic_concept/)
- For polymorphism: See [Polymorphism/](../Polymorphism/)
- For interface inheritance: See [java8/defaultMethod/](../java8/defaultMethod/)

## Prerequisites

- Understanding of classes and objects
- Familiar with method definitions
- Basic OOP knowledge

## Tips for Learning

1. **Draw diagrams**: Visualize the class hierarchy
2. **Trace method calls**: Follow which method gets executed
3. **Experiment with super**: Call parent methods explicitly
4. **Test overriding**: See what happens when method is redefined
5. **Use debugger**: Step through inheritance chain

## Common Mistakes to Avoid

1. Forgetting that all classes extend Object
2. Not understanding method overriding vs overloading
3. Missing `super()` call in derived constructors
4. Making classes final unintentionally
5. Creating circular inheritance (not possible in Java, but conceptually)

## Best Practices

1. **Use inheritance for "is-a" relationships**
2. **Prefer composition for "has-a" relationships**
3. **Keep hierarchies shallow** (avoid deep chains)
4. **Follow Liskov Substitution Principle** (derived class should be usable as parent)
5. **Document inheritance contracts** in javadoc

## Advanced Topics

- **Abstract Classes**: Force implementation in subclasses
- **Interfaces**: Multiple inheritance of type
- **Sealed Classes** (Java 17): Restrict which classes can extend
- **Pattern Matching** (Java 21): Type-safe casting in inheritance hierarchies
