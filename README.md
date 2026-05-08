# Core Java Learning Repository

A comprehensive educational Java repository covering foundational concepts through modern Java features (Java 8-25). This project contains working code examples, interview questions, and focused learning modules organized by topic to help developers master Java programming.

## Table of Contents

- [Project Overview](#project-overview)
- [Core Java Fundamentals](#core-java-fundamentals)
- [Java 8 Features (Functional Programming)](#java-8-features-functional-programming)
- [Java 10-15 Modern Features](#java-10-15-modern-features)
- [Advanced Concurrency & Multithreading](#advanced-concurrency--multithreading)
- [String & Data Types](#string--data-types)
- [Design Patterns & Advanced Topics](#design-patterns--advanced-topics)
- [Additional Learning Resources](#additional-learning-resources)
- [Learning Path](#learning-path)
- [Getting Started](#getting-started)

## Project Overview

This repository serves as a complete reference guide for Java developers, featuring:
- **300+ code examples** across various Java concepts
- **Interview preparation** materials with 30+ coded questions
- **Progressive learning** from basics to advanced topics
- **Real-world scenarios** and practical implementations
- **Modern Java features** up to Java 25

## Core Java Fundamentals

### Basic Concepts
- **Object-Oriented Programming**: Inheritance, polymorphism, encapsulation
- **Classes and Objects**: Base classes, derived classes, super keyword usage
- **Comparison**: Comparable and Comparator interfaces with practical examples

*Location: [Basic_concept/](Basic_concept/)*
- `DeriveFromBaseClass.java` - Inheritance patterns
- `Comparable_Main.java`, `ComparatorClass.java` - Comparison implementations
- `SuperKeyword.java` - Super keyword usage

### Polymorphism
- Method overloading and overriding
- Runtime polymorphism examples
- Dynamic method dispatch

*Location: [Polymorphism/](Polymorphism/)*
- `MethodOverloading.java`, `MethodOverriding.java`
- `RuntimePolymorphismExample.java`, `RuntimePolymorphismExample2.java`

### Collections Framework
- Array operations and basic collections
- Collection interfaces and implementations

*Location: [Collection/](Collection/)*
- `ArrayListSizeCheck.java` - ArrayList operations

### Constructors
- Constructor patterns and copy constructors

*Location: [Constructor/](Constructor/)*
- `CopyValueInConstructor.java` - Constructor value copying

## Java 8 Features (Functional Programming)

### Date/Time API
Modern date and time handling with java.time package.

*Location: [java8/DateTimeAPI/](java8/DateTimeAPI/)*
- `ChronoDate.java` - Chronology operations
- `DateToInstant.java` - Date to Instant conversions
- `DateToLDAndLDT.java` - LocalDate/LocalDateTime conversions
- `TemporalAdjustor.java` - Date adjustments
- `ZoneMethod.java` - Time zone operations

### Stream API
Functional programming with streams for data processing.

*Location: [java8/StreamApiConcept/](java8/StreamApiConcept/)*
- `PrintEvenNoUsingGivenArray.java` - Stream filtering
- `PrintListOfMarksAndAdd5GraceMarks.java` - Stream mapping

### Method References
Different types of method references in functional programming.

*Location: [java8/methodReference/](java8/methodReference/)*
- `StaticMethodReference.java` - Static method references
- `ConstructorReference.java` - Constructor references
- `InstanceMethodReference*` - Instance method references

### Default Methods
Interface evolution with default methods.

*Location: [java8/defaultMethod/](java8/defaultMethod/)*
- `Test.java` - Default method implementations

### Advanced Collectors
Complex data aggregation and grouping operations.

*Location: [Java8_code/CollectorWithJava8/](Java8_code/CollectorWithJava8/)*
- Employee data analysis with collectors
- Salary calculations, grouping, and partitioning

### Interview Questions
30+ practical coding interview questions covering Java 8 features.

*Location: [Java8_code/Interview_code/](Java8_code/Interview_code/)*
- Stream operations, lambda expressions
- Real-world problem solving scenarios

## Java 10-15 Modern Features

### Java 10-11 Enhancements
*Location: [Java10_11/](Java10_11/)*
- `TypeInferenceExample.java` - Local variable type inference (var)
- `LambdaVarExample.java` - Lambda parameters with var
- `ForEachWithVarExample.java` - Enhanced for-each loops
- `StringRepeatExample.java` - String repeat methods
- `TryWithResourcesExample.java` - Improved resource management

### Java 14: Switch Enhancements
*Location: [Java14/](Java14/)*
- `SwitchEnhancementDemo.java` - Switch expressions
- `SwitchReturnDemo.java` - Switch with return
- `SwitchYieldDemo.java` - Switch with yield

### Java 15: Text Blocks
*Location: [Java15/](Java15/)*
- `TextBlocksDemo.java` - Multi-line string literals

### Java 9 Features
*Location: [Java9/](Java9/)*
- `DiamondAnonymousJava7.java` vs `DiamondAnonymousJava9.java` - Diamond operator improvements
- `SafeVarargsDemo.java` - Safe varargs usage
- `TryWithResourcesExample.java` - Enhanced try-with-resources
- `UnderscoreExample.java` - Underscore as reserved keyword

## Advanced Concurrency & Multithreading

### Basic Threading
*Location: [MultiThreading/](MultiThreading/)*
- `CreateThreadUsingThreadClass.java` - Direct Thread class usage
- `CreateThreadUsingRunnable.java` - Runnable interface implementation
- `ThreadUsingLambda.java` - Lambda expressions for threads
- `ThreadUsingAnonymousInnerClass.java` - Anonymous inner classes
- `DeadlockCondition.java` - Deadlock scenarios
- `Synchronization.java` - Thread synchronization
- `ExecutorFrameworkEx.java` - Executor framework basics
- `CallableTask.java`, `RunnableTask.java` - Task implementations

### Deep Dive Multithreading Tutorials
Comprehensive tutorials with detailed documentation:

- **DD_Multithreading_Concurrency**: Concurrency vs parallelism, executor framework, synchronized blocks, deadlock prevention
- **DD_Multithreading__ExecutorService**: Thread pool management and lifecycle
- **DD_Multithreading_Executors_ExecutorHierarchy_Future**: Future objects and task completion
- **DD_Multithreading_TaskQueue**: Queue-based task management

## String & Data Types

### String Operations
*Location: [StringEx/](StringEx/)*
- `StringAndStringBuffer.java` - String vs StringBuffer comparisons

### Wrapper Classes
*Location: [WrapperClassEx/](WrapperClassEx/)*
- `WrapperToString.java` - Wrapper class conversions

*Documentation: `String.one`, `Wrapper class.one`*

## Design Patterns & Advanced Topics

### Singleton Pattern
Six different implementations of the Singleton design pattern.

*Location: `Singleton_6_Ways`*

### Iterator Patterns
*Location: [Iterator/](Iterator/)*
- `Fail_Fast_Example.java` - Fail-fast iteration
- `Fail_Safe_Example.java` - Fail-safe iteration

### Custom Implementations
*Location: [Sample/](Sample/)*
- `CustomArrayList.java` - Custom ArrayList implementation

## Additional Learning Resources

- **JPA**: Java Persistence API for database operations
- **Git Workflow**: Branching and merging strategies
- **Modern Java Features**: Comprehensive guide to Java 9-25
- **Package and Modifiers**: Access modifiers and package structure
- **Enumeration**: Enum usage and best practices

## Learning Path

### Beginner Level
1. Basic Java syntax and OOP concepts
2. Control flow statements
3. Classes, objects, and inheritance
4. Basic collections and arrays

### Intermediate Level
1. Polymorphism and method overriding
2. String manipulation and wrapper classes
3. Basic multithreading concepts
4. Exception handling

### Advanced Level
1. Functional programming (Java 8 streams, lambdas)
2. Advanced concurrency patterns (ExecutorService, Callable, Future)
3. Modern Java syntax (switch expressions, text blocks)
4. Design patterns and custom implementations

### Interview Preparation
- 30+ coded interview questions
- Practical problems with data filtering and analysis
- Real-world streaming and collection scenarios

## Getting Started

1. **Prerequisites**: JDK 8+ installed
2. **Clone the repository**: `git clone <repository-url>`
3. **Navigate to topics**: Each folder contains focused examples
4. **Run examples**: Compile and run individual Java files
5. **Study patterns**: Review code comments and documentation

### Running Examples
```bash
# Compile Java file
javac filename.java

# Run the program
java filename
```

### Recommended IDE
- Visual Studio Code with Java extensions
- IntelliJ IDEA
- Eclipse IDE

This repository provides a structured learning journey from Java fundamentals to advanced modern features, making it an excellent resource for both learning and reference.