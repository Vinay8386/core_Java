# Basic_concept - Object-Oriented Programming Fundamentals

## Overview

This folder contains foundational Object-Oriented Programming (OOP) concepts that form the basis of all Java programs. Covers inheritance, polymorphism, encapsulation, and comparison mechanisms.

## What You'll Learn

- Object-oriented design principles
- Class inheritance and hierarchies
- Method overriding and super keyword usage
- Comparable interface for natural ordering
- Comparator interface for custom ordering
- Polymorphic behavior and object relationships

## Key Concepts Covered

1. **Inheritance**: Extending base classes and creating derived classes
2. **Polymorphism**: Method overriding in inheritance hierarchies
3. **Encapsulation**: Data hiding and controlled access
4. **Comparison**: Object comparison using Comparable and Comparator
5. **Super Keyword**: Accessing parent class methods and constructors

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `Base.java` | Base class definition | Class structure, fields, methods |
| `Parent.java` | Parent class example | Inheritance base class |
| `DeriveFromBaseClass.java` | Derived class implementation | Single inheritance patterns |
| `DerivedMain.java` | Demonstrates inheritance | Parent-child relationships |
| `SuperKeyword.java` | Super keyword usage | Accessing parent class members |
| `NewClass.java` | Additional example class | Class design patterns |
| `Test.java` | Test/demo class | Basic testing patterns |
| `TestMain.java` | Main entry point | Running test examples |
| `Comparable_Main.java` | Comparable interface example | Natural ordering implementation |
| `Comparable_MovieClass.java` | Movie class with Comparable | Comparing custom objects |
| `ComparatorClass.java` | Custom Comparator implementation | Multiple sorting strategies |
| `ComparatorMain.java` | Comparator usage examples | Using custom comparators |

## How to Run

### Basic Inheritance Example
```bash
# Compile
javac DeriveFromBaseClass.java

# Run
java DeriveFromBaseClass
```

### Comparable Example (Natural Ordering)
```bash
# Compile
javac Comparable_MovieClass.java Comparable_Main.java

# Run
java Comparable_Main
```

### Comparator Example (Custom Ordering)
```bash
# Compile
javac ComparatorClass.java ComparatorMain.java

# Run
java ComparatorMain
```

## Quick Start

1. Start with `DeriveFromBaseClass.java` to understand single inheritance
2. Review `SuperKeyword.java` to see parent class access
3. Study `Comparable_MovieClass.java` for natural ordering
4. Explore `ComparatorClass.java` for custom sorting

## Important Concepts

### Inheritance Hierarchy
```
Object (parent of all classes)
  ↓
Base Class
  ↓
Derived Class
```

### Comparable vs Comparator
- **Comparable**: Single natural ordering (implements within class)
- **Comparator**: Multiple sorting strategies (external implementation)

## Related Topics

- For polymorphism details: See [Polymorphism/](../Polymorphism/)
- For more inheritance: See [Inheritance/](../Inheritance/)
- For practical collections: See [Collection/](../Collection/)

## Prerequisites

- Understanding of Java syntax and data types
- Basic knowledge of classes and objects
- Familiar with method definitions

## Tips for Learning

1. **Study in order**: Start with Base → Derive → Super usage
2. **Run examples**: Execute and modify to understand behavior
3. **Compare interfaces**: Understand Comparable vs Comparator differences
4. **Experiment**: Create your own classes extending provided ones
5. **Trace execution**: Use IDE debugger to step through inheritance chains

## Common Mistakes to Avoid

1. Forgetting to use `super` keyword when calling parent methods
2. Confusing Comparable (internal) with Comparator (external)
3. Not implementing required methods from interfaces
4. Mixing up method overloading with overriding
5. Creating circular inheritance relationships
