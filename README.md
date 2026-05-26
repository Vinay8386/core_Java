# Core Java Learning Repository

A comprehensive educational Java repository covering foundational concepts through modern Java features (Java 8-25). This project contains working code examples, interview questions, and focused learning modules organized by topic to help developers master Java programming.

## Table of Contents

- [Project Overview](#project-overview)
- [Repository Structure](#repository-structure)
- [Core Java Fundamentals](#core-java-fundamentals)
- [Object-Oriented Programming Concepts](#object-oriented-programming-concepts)
- [Collections & Iterators](#collections--iterators)
- [Java 8: Functional Programming](#java-8-functional-programming)
- [Java 9 Features](#java-9-features)
- [Java 10-11 Features](#java-10-11-features)
- [Java 14: Switch Expressions](#java-14-switch-expressions)
- [Java 15: Text Blocks](#java-15-text-blocks)
- [Java 16: Records](#java-16-records)
- [Java 17: Sealed Classes](#java-17-sealed-classes)
- [Java 21: Pattern Matching](#java-21-pattern-matching)
- [Java 22: Unnamed Variables](#java-22-unnamed-variables)
- [Java 25: Compact Source Files](#java-25-compact-source-files)
- [Multithreading & Concurrency](#multithreading--concurrency)
- [Design Patterns](#design-patterns)
- [String & Wrapper Classes](#string--wrapper-classes)
- [Supporting Documentation](#supporting-documentation)
- [Learning Path](#learning-path)
- [Getting Started](#getting-started)

## Project Overview

This repository serves as a complete reference guide for Java developers, featuring:
- **500+ code examples** across all Java concepts from basics to advanced
- **30+ interview questions** with working solutions
- **Progressive learning** from Java fundamentals to Java 25 features
- **Real-world scenarios** and practical implementations
- **Deep-dive tutorials** on complex topics (multithreading, concurrency, executors)
- **Best practices** and modern Java patterns

## Repository Structure

```
core_Java/
├── Basic_concept/              # OOP fundamentals and inheritance
├── Collection/                 # Collections framework basics
├── Constructor/                # Constructor patterns and practices
├── Inheritance/                # Inheritance implementation examples
├── Iterator/                   # Iterator patterns (Fail-Fast, Fail-Safe)
├── Polymorphism/               # Method overloading/overriding
├── Sample/                     # Custom implementations (e.g., CustomArrayList)
├── StringEx/                   # String manipulation examples
├── WrapperClassEx/             # Wrapper class usage
├── java8/                      # Java 8 features (streams, lambdas, dates)
├── Java8_code/                 # Advanced Java 8 examples and interviews
├── Java9/                      # Java 9 enhancements
├── Java10_11/                  # Type inference and other features
├── Java14/                     # Switch expressions
├── Java15/                     # Text blocks
├── Java16/                     # Records
├── Java17/                     # Sealed classes
├── Java21/                     # Pattern matching with switch
├── Java22/                     # Unnamed variables
├── Java25/                     # Compact source files and instance main
├── MultiThreading/             # Basic threading and synchronization
├── Singleton_6_Ways/           # Design pattern implementations
├── (Documentation files)       # .one files for specific topics
└── README.md                   # This file
```

---

## Core Java Fundamentals

### Basic Syntax & OOP Concepts

**Location:** [Basic_concept/](Basic_concept/)

This folder contains foundational Java concepts needed for all developers:

- **`Base.java`** - Base class demonstrating class definition and properties
- **`DeriveFromBaseClass.java`** - Inheritance patterns and derived class implementation
- **`Parent.java`** & **`DerivedMain.java`** - Parent-child class relationships
- **`SuperKeyword.java`** - Using the `super` keyword for parent class access
- **`NewClass.java`**, **`Test.java`**, **`TestMain.java`** - Test and example implementations
- **`Comparable_Main.java`** & **`Comparable_MovieClass.java`** - Implementing the Comparable interface
- **`ComparatorClass.java`** & **`ComparatorMain.java`** - Custom Comparator implementations

**Key Topics:** Inheritance, access specifiers, method overriding, object creation, super keyword usage

### Constructor Patterns

**Location:** [Constructor/](Constructor/)

- **`CopyValueInConstructor.java`** - Copy constructor pattern for creating objects with existing object's values

**Key Topics:** Constructor overloading, copy constructors, initialization

### Polymorphism & Method Resolution

**Location:** [Polymorphism/](Polymorphism/)

- **`MethodOverloading.java`** - Same method name with different parameters
- **`MethodOverriding.java`** - Override parent class methods in child classes
- **`RuntimePolymorphismExample.java`** & **`RuntimePolymorphismExample2.java`** - Compile-time and runtime polymorphism
- **`String.java`** & **`StringBuffer.java`** - String comparison examples

**Key Topics:** Method overloading, method overriding, compile-time vs runtime polymorphism

### Inheritance Examples

**Location:** [Inheritance/](Inheritance/)

- **`C.java`** - Multi-level inheritance example

**Key Topics:** Single inheritance, multi-level inheritance, method inheritance

---

## Object-Oriented Programming Concepts

### Comparison Implementations

Compare objects using standard Java interfaces:

**Location:** [Basic_concept/](Basic_concept/)

**Comparable Interface** - Natural ordering
- `Comparable_Main.java` - Main entry point
- `Comparable_MovieClass.java` - Comparable implementation

**Comparator Interface** - Custom ordering
- `ComparatorClass.java` - Custom comparator
- `ComparatorMain.java` - Comparator usage examples

---

## Collections & Iterators

### Collections Framework

**Location:** [Collection/](Collection/)

- **`ArrayListSizeCheck.java`** - ArrayList operations and size management

**Key Topics:** ArrayList operations, collection sizing, basic collection usage

### Iterator Patterns

**Location:** [Iterator/](Iterator/)

Understanding iterator behavior when collections are modified during iteration:

- **`Fail_Fast_Example.java`** - Demonstrates ConcurrentModificationException when list is modified during iteration
- **`Fail_Safe_Example.java`** - Demonstrates safe iteration using CopyOnWriteArrayList

**Key Topics:** Collection modification safety, concurrent collections, iterator behavior

### Custom Collections

**Location:** [Sample/](Sample/)

- **`CustomArrayList.java`** - Custom ArrayList implementation from scratch
- **`Test.java`** - Testing custom collection

**Key Topics:** Collection interface, generics, dynamic array implementation

---

## Java 8: Functional Programming

### Streams & Filtering

**Location:** [java8/StreamApiConcept/](java8/StreamApiConcept/)

- **`PrintEvenNoUsingGivenArray.java`** - Filter stream for even numbers
- **`PrintListOfMarksAndAdd5GraceMarks.java`** - Map operation to add grace marks
- **`CountFailedStudent.java`** - Filtering and counting with streams

**Key Topics:** Stream API, filter(), map(), intermediate operations

### Date/Time API

**Location:** [java8/DateTimeAPI/](java8/DateTimeAPI/)

Modern java.time API for date/time operations:

- **`GetCurrentDateTime.java`** - Get current date, time, and instant
- **`DateToInstant.java`** - Convert legacy Date to modern Instant
- **`DateToLDAndLDT.java`** - Convert to LocalDate and LocalDateTime
- **`InstantToLocalDateTime.java`** - Instant to LocalDateTime conversion
- **`ChronoDate.java`** - Different calendar systems using Chronology
- **`TemporalAdjustor.java`** - Adjust dates (e.g., next Monday, end of month)
- **`ZoneMethod.java`** - Time zone operations and conversions
- **`TestDate.java`** - Test suite for date/time operations

**Key Topics:** LocalDate, LocalTime, LocalDateTime, Instant, ZonedDateTime, temporal adjusters

### Method References

**Location:** [java8/methodReference/](java8/methodReference/)

Different types of method references as an alternative to lambdas:

- **`StaticMethodReference.java`** - Reference to static methods (ClassName::methodName)
- **`ConstructorReference.java`** - Reference to constructors (ClassName::new)
- **`InstanceMethodReferenceOfParticularObject.java`** - Reference to instance methods of specific object
- **`InstanceMethodReferenceOfArbitraryObject.java`** - Reference to instance methods of arbitrary object

**Key Topics:** Method reference syntax, functional interface usage, lambda alternatives

### Default Methods

**Location:** [java8/defaultMethod/](java8/defaultMethod/)

- **`Test.java`** - Default method implementation in interfaces

**Key Topics:** Interface evolution, default implementations, backward compatibility

### Annotations

**Location:** [java8/Type_Repeating_Annotations/](java8/Type_Repeating_Annotations/)

- **`CustomAnnotations.java`** - Custom annotation definitions and repeating annotations

**Key Topics:** Annotation creation, repeating annotations, meta-annotations

### Advanced Java 8 Examples

**Location:** [Java8_code/](Java8_code/)

Organized into four specialized subfolders:

#### CollectorWithJava8/

Complex data aggregation, grouping, and partitioning:

- **Employee Analysis**
  - `Employee.java` - Employee data model
  - `CountByGender.java` - Count employees by gender
  - `DeptWiseAvgSalary.java` - Average salary per department
  - `SalaryPerDepartment.java` - Total salary per department
  - `MaxAndMinSalaryEmp.java` - Find max/min salary employees

- **Filtering & Selection**
  - `FilterEmployeeUsingAge.java` - Filter by age criteria
  - `FilterEmpByDeptAndCity.java` - Filter by department and city
  - `EmpNameStartWith.java` - Filter employees by name pattern
  - `FetchTop3SalaryEmpDetails.java` - Get top 3 employees by salary
  - `FetchSalryLessThanThirdHighest.java` - Complex salary filtering

- **Sorting & Grouping**
  - `SortByName.java` - Sort employees by name
  - `SortBySalary.java` - Sort by salary
  - `SortListInBothAscDesc.java` - Ascending and descending sorts
  - `GroupByCityAndCalAvgAge.java` - Group by city, calculate average age
  - `PartitionBasedOnGender.java` - Partition into male/female groups

**Key Topics:** Collectors, groupingBy(), partitioningBy(), reducing(), custom aggregations

#### Interview_code/

30+ Java interview problems covering various topics:

- **String & Character Problems**
  - `MaxOccuranceCharacter.java` - Find most frequent character
  - `FirstQ.java` through `TwentyNine.java` - Coded interview questions

- **Algorithmic Problems**
  - `FibonacciNumber.java` - Fibonacci sequence generation
  - `EmployeeFilter.java` - Filter employee records
  - `Notes.java` - Additional problem notes

- **Complete Coverage**
  - Questions 1-32 covering: list filtering, string manipulation, number processing, collection operations

**Key Topics:** Problem-solving patterns, stream operations, string processing, functional interfaces

#### MapQuestion/

Map-specific operations and transformations:

- **`MapToList.java`** - Convert Map to List
- **`MaxValueInHashMap.java`** - Find maximum value in map
- **`SortByValueAndKey.java`** - Sort map by value or key
- **`CountKeyStartWithSpecificLetter.java`** - Filter and count keys
- **`FilterEntriesBasedOnKeyLength.java`** - Filter by key length
- **`FilterEntriesBasedOnValueLength.java`** - Filter by value length

**Key Topics:** Map operations, sorting maps, filtering entries, transformations

#### random_que/

Miscellaneous Java 8 utilities and features:

- **Stream Operations**
  - `FlatMap.java` - Flattening nested structures
  - `LimitAndSkipMethodExample.java` - Stream limiting and skipping
  - `IteratingOverList.java` - Various iteration techniques
  - `MapReduceExample.java` - Map-reduce pattern

- **Functional Interfaces & Advanced Features**
  - `GenerateOtpUsingSupplierPFI.java` - Supplier functional interface
  - `ListToOptional.java` - Converting lists to Optional
  - `ParallelStreamExample.java` - Parallel stream processing
  - `ActionListnerImplementation.java` - GUI action handling
  - `RunnableImplementation.java` - Runnable with lambdas

**Key Topics:** Optional, Supplier, parallel streams, functional patterns

**Related Documentation:** [Java8_code/README_JAVA8.md](Java8_code/README_JAVA8.md)

---

## Java 9 Features

**Location:** [Java9/](Java9/)

Enhancements and new features introduced in Java 9:

- **`DiamondAnonymousJava7.java`** vs **`DiamondAnonymousJava9.java`** - Diamond operator improvements for anonymous classes
- **`UnderscoreExample.java`** - Underscore as reserved keyword (cannot be used as variable name)
- **`SafeVarargsDemo.java`** - `@SafeVarargs` annotation for variable argument methods
- **`TryWithResourcesExample.java`** - Enhanced try-with-resources statements
- **`Car.java`** - Example class for demonstrations

**Key Topics:** Diamond operator, reserved keywords, varargs handling, try-with-resources

---

## Java 10-11 Features

**Location:** [Java10_11/](Java10_11/)

Local Variable Type Inference and other enhancements:

- **`TypeInferenceExample.java`** - Local variable type inference using `var` keyword
- **`LambdaVarExample.java`** - Using `var` in lambda parameter declarations
- **`ForEachWithVarExample.java`** - Enhanced for-each loops with `var`
- **`StringRepeatExample.java`** - New `String.repeat()` method
- **`TryWithResourcesExample.java`** - Further enhancements to try-with-resources

**Key Topics:** `var` keyword, type inference, String methods, resource management

---

## Java 14: Switch Expressions

**Location:** [Java14/](Java14/)

Switch statements as expressions with multiple return values:

- **`SwitchEnhancementDemo.java`** - Basic switch expression syntax
- **`SwitchReturnDemo.java`** - Switch returning values
- **`SwitchYieldDemo.java`** - Using `yield` keyword in switch blocks

**Key Topics:** Switch expressions, arrow syntax (->), yield keyword, pattern matching introduction

---

## Java 15: Text Blocks

**Location:** [Java15/](Java15/)

- **`TextBlocksDemo.java`** - Multi-line string literals without concatenation

**Key Topics:** Text blocks, escape sequences, formatting multi-line strings

---

## Java 16: Records

**Location:** [Java16/](Java16/)

Records provide a compact way to define immutable data carriers:

- **`RecordClass.java`** - Record class definition
- **`Rectangle.java`** - Regular class for comparison
- **`RectangleUsingRecord.java`** - Same functionality using records
- **`RecordClassNotes`** - Documentation about records
- **`README_Java16.md`** - Detailed guide to Java 16 features

**Key Topics:** Records, immutability, canonical constructors, compact constructors, accessor methods

---

## Java 17: Sealed Classes

**Location:** [Java17/](Java17/)

Sealed classes restrict inheritance to specified classes:

- **`PaymentSystem.java`** - Payment type example with sealed classes
- **`ShapeAreaCalculator.java`** - Shape hierarchy with sealed classes
- **`SealedClasses_Notes`** - Detailed documentation

**Key Topics:** Sealed classes, permitted subclasses, exhaustiveness checking, pattern matching

---

## Java 21: Pattern Matching

**Location:** [Java21/](Java21/)

Advanced pattern matching capabilities:

- **`SwitchExample.java`** - Basic switch patterns
- **`PatternMatchingInstanceOfExample.java`** - Pattern matching with instanceof
- **`AdvancedPatternMatchingSwitch.java`** - Complex pattern matching scenarios
- **`TypePatternExamples.java`** - Type patterns and type tests
- **`RecordPatternExample.java`** - Destructuring records in patterns
- **`Pattern_Matching_with_switch_Notes`** - Comprehensive documentation

**Key Topics:** Record patterns, type patterns, pattern matching in switch, destructuring

---

## Java 22: Unnamed Variables

**Location:** [Java22/](Java22/)

Unnamed variables and patterns for unused values:

- **`UnnamedVariableAndPatternExample.java`** - Using `_` for unused variables
- **`Unnamed_Variable_And_Pattern_Notes`** - Documentation

**Key Topics:** Unnamed variables, underscore syntax, readability improvements

---

## Java 25: Compact Source Files & Instance Main

**Location:** [Java25/](Java25/)

Write simple Java programs without boilerplate class definitions:

- **`ClassUsingInstanceMain.java`** - Simple program with instance main method
- **`FlexibleConstructorBodies.java`** - Flexible constructor initialization
- **`ModuleImportDeclarationExample.java`** - Simplified import declarations
- **`Compact_Source_Files_And_Instance_Main_Notes`** - Complete documentation
- **`Flexible_Constructor_Bodies_Notes`** - Constructor body documentation
- **`Module_Import_Declarations_Notes`** - Import documentation

**Key Topics:** Instance main methods, compact source files, simplified syntax, educational focus

---

## Multithreading & Concurrency

### Basic Threading

**Location:** [MultiThreading/](MultiThreading/)

Fundamental threading concepts and synchronization:

- **Creating Threads**
  - `CreateThreadUsingThreadClass.java` - Extend Thread class
  - `CreateThreadUsingRunnable.java` - Implement Runnable interface
  - `ThreadUsingLambda.java` - Create threads with lambda expressions
  - `ThreadUsingAnonymousInnerClass.java` - Anonymous inner class approach

- **Synchronization & Coordination**
  - `Synchronization.java` - Synchronized blocks and methods
  - `SharedResource.java` - Resource sharing between threads
  - `DeadlockCondition.java` - Deadlock scenarios and prevention

- **Executor Framework**
  - `ExecutorFrameworkEx.java` - Introduction to ExecutorService
  - `CallableTask.java` - Callable interface with return values
  - `RunnableTask.java` - Runnable task implementation
  - `Main.java` - Integration examples

**Key Topics:** Thread creation, synchronization, thread safety, executor basics

### Deep-Dive Multithreading Tutorials

Advanced multithreading topics with comprehensive documentation:

- **`DD_Multithreading_Concurrency`** - Concurrency patterns, synchronization mechanisms, race conditions
- **`DD_Multithreading__ExecutorService`** - ExecutorService lifecycle, thread pool management, task submission
- **`DD_Multithreading_Executors_ExecutorHierarchy_Future`** - Executor hierarchy, Future objects, task completion, callbacks
- **`DD_Multithreading_TaskQueue`** - Queue-based task management, producer-consumer pattern, blocking queues

**Key Topics:** Thread pools, concurrent collections, Future API, CompletableFuture, deadlock prevention, performance optimization

---

## Design Patterns

### Singleton Pattern

**Location:** [Singleton/](Singleton/)

Six different implementations of the Singleton design pattern with detailed documentation and trade-offs:

**Implementations:**

1. **`StaticEagerSingleton.java`** - Singleton created at class loading
   - Simple and thread-safe by default
   - No runtime initialization overhead
   - Best for always-used singletons

2. **`DynamicLazySingleton.java`** - Singleton created on first use (non-thread-safe)
   - Lazy initialization
   - **Not suitable for multi-threaded applications**
   - Educational purposes only

3. **`DynamicLazyImprovedSingleton.java`** - Thread-safe lazy initialization
   - Uses synchronized keyword
   - Thread-safe but with lock contention overhead
   - Best for low to medium concurrency

4. **`DoubleCheckedLockingSingleton.java`** - Optimized thread-safe singleton
   - Lock acquired only during initialization
   - Better performance in high concurrency
   - Requires volatile keyword and careful implementation
   - **Complex pattern - avoid unless necessary**

5. **`BillPughSingleton.java`** - Using static inner helper class (Recommended)
   - Thread-safe without synchronization overhead
   - Lazy initialization by design
   - **Best choice for most applications**
   - Perfect balance of safety, performance, and simplicity

6. **`EnumSingleton.java`** - Serialization and reflection-safe approach
   - Maximum security against reflection and serialization attacks
   - Most robust implementation
   - **Best for production systems where security is critical**
   - Enum construction controlled by JVM

7. **`SingletonWithFunction.java`** - Modern Java functional approach
   - Combines singleton pattern with Java 8+ lambdas
   - Contemporary implementation style

**Additional Files:**
- **`Main.java`** - Demo program showing all implementations and usage patterns
- **`Singleton_Notes`** - Additional documentation and discussion

**Key Topics:** Singleton pattern, thread safety, serialization attacks, reflection attacks, lazy vs eager initialization, design pattern trade-offs

**Recommended Reading:** Start with [Singleton/README.md](Singleton/README.md) for comprehensive comparison and selection guide for each implementation.

---

## String & Wrapper Classes

### String Operations

**Location:** [StringEx/](StringEx/)

- **`StringAndStringBuffer.java`** - Comparison of String (immutable) vs StringBuffer (mutable)

**Key Topics:** String immutability, StringBuffer, StringBuilder, performance implications

### Wrapper Classes

**Location:** [WrapperClassEx/](WrapperClassEx/)

- **`WrapperToString.java`** - Converting wrapper classes to String and vice versa

**Key Topics:** Wrapper class conversions, auto-boxing, unboxing, null handling

### Documentation Files

- **`String.one`** - Comprehensive String concepts documentation
- **`Wrapper class.one`** - Wrapper class detailed guide

---

## Supporting Documentation

The repository includes several comprehensive reference documents in .one format (OneNote files):

### Fundamental Concepts

- **`Basic Java 1.one`** - Java syntax fundamentals, data types, operators
- **`Basic Java 2.one`** - Advanced basic concepts, control structures
- **`Control Flow Statement.one`** - If/else, switch, loops (for, while, do-while)
- **`Enumeration.one`** - Enum types, enum constants, enum methods
- **`PackageAndModifier.one`** - Package organization, access modifiers (public, private, protected, default)
- **`String.one`** - String API, String vs StringBuffer vs StringBuilder
- **`Wrapper class.one`** - Wrapper classes for primitives, boxing/unboxing

### Advanced Topics

- **`Git Branching & Merging Workflow`** - Version control best practices used in team development
- **`Modern Java Features (Java 9–25)`** - Comprehensive guide to all modern features
- **`Preview_VS_Permanent_Feature_Notes`** - Understanding Java feature lifecycle
- **`Work_With_Multiple_Java_Version.txt`** - Managing multiple JDK installations
- **`Interface+OOPS Concept.7z`** - Compressed archive of interface and OOP materials

### Utilities

- **`switch-java.bat`** - Batch script for switching between Java versions
- **`Interface+OOPS Concept.7z`** - Compressed reference materials

---

## Learning Path

### Beginner Level (2-3 weeks)

Start with Java fundamentals before moving to advanced concepts:

1. **Week 1: Java Basics**
   - [Basic_concept/](Basic_concept/) - OOP fundamentals
   - [Constructor/](Constructor/) - Object creation
   - [Inheritance/](Inheritance/) - Code reuse
   - Review: `Basic Java 1.one`, `Basic Java 2.one`

2. **Week 2: Control & Collections**
   - [Polymorphism/](Polymorphism/) - Method overloading/overriding
   - [Collection/](Collection/) & [Iterator/](Iterator/) - Collections framework
   - Review: `Control Flow Statement.one`

3. **Week 3: String & Wrappers**
   - [StringEx/](StringEx/) - String operations
   - [WrapperClassEx/](WrapperClassEx/) - Primitive wrappers
   - Review: `String.one`, `Wrapper class.one`

### Intermediate Level (3-4 weeks)

Build practical skills with design patterns and basic concurrency:

1. **Week 1: Design Patterns**
   - `Singleton_6_Ways` - Learn different implementation strategies
   - [Sample/](Sample/) - Custom collection implementations

2. **Week 2: Threading Basics**
   - [MultiThreading/](MultiThreading/) - Thread creation and synchronization
   - Learn about thread safety and race conditions

3. **Week 3-4: Java 8 Functional Programming**
   - [java8/StreamApiConcept/](java8/StreamApiConcept/) - Stream API basics
   - [java8/methodReference/](java8/methodReference/) - Functional programming
   - [java8/DateTimeAPI/](java8/DateTimeAPI/) - Modern date/time handling

### Advanced Level (4+ weeks)

Master modern Java features and advanced concurrency:

1. **Week 1-2: Advanced Java 8**
   - [Java8_code/CollectorWithJava8/](Java8_code/CollectorWithJava8/) - Complex streams
   - [Java8_code/Interview_code/](Java8_code/Interview_code/) - Interview problems

2. **Week 3: Java 9-25 Features**
   - [Java9/](Java9/) - Diamond operator, varargs
   - [Java10_11/](Java10_11/) - Type inference with `var`
   - [Java14/](Java14/) - Switch expressions
   - [Java15/](Java15/) - Text blocks
   - [Java16/](Java16/) - Records
   - [Java17/](Java17/) - Sealed classes
   - [Java21/](Java21/) - Pattern matching
   - [Java22/](Java22/) - Unnamed variables
   - [Java25/](Java25/) - Compact source files

3. **Week 4+: Advanced Concurrency**
   - `DD_Multithreading_Concurrency` - Concurrency patterns
   - `DD_Multithreading__ExecutorService` - Thread pool management
   - `DD_Multithreading_Executors_ExecutorHierarchy_Future` - Future API
   - `DD_Multithreading_TaskQueue` - Queue-based patterns

### Interview Preparation Track (2-3 weeks)

Focus on practical coding problems:

1. **[Java8_code/Interview_code/](Java8_code/Interview_code/)** - 30+ interview questions
2. **[Java8_code/CollectorWithJava8/](Java8_code/CollectorWithJava8/)** - Real-world data processing
3. **[Java8_code/MapQuestion/](Java8_code/MapQuestion/)** - Collections and Maps
4. **[MultiThreading/](MultiThreading/)** - Concurrency interview topics
5. **Review:** Code examples from all modules for completeness

---

## Getting Started

### Prerequisites

- **JDK 8 or higher** (JDK 25 for latest features)
- **IDE:** IntelliJ IDEA, Eclipse, or VS Code with Java extensions
- **Git** for version control

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd core_Java
   ```

2. **Verify Java installation**
   ```bash
   javac -version
   java -version
   ```

3. **Navigate to a topic folder**
   ```bash
   cd java8/StreamApiConcept
   ```

4. **Compile and run an example**
   ```bash
   javac PrintEvenNoUsingGivenArray.java
   java PrintEvenNoUsingGivenArray
   ```

### Running Examples

#### Basic Compilation
```bash
# Compile a single file
javac FileName.java

# Run the compiled class
java FileName
```

#### Compiling with Packages
```bash
# For Java8_code examples
cd Java8_code
javac -d . CollectorWithJava8/CountByGender.java
java Java8_code.CollectorWithJava8.CountByGender
```

#### Using Modern Java Features (Java 9+)
```bash
# For Java 21-24 (Preview features require --enable-preview)
javac --enable-preview --release 21 FileName.java
java --enable-preview FileName

# For Java 25 (No preview required)
javac FileName.java
java FileName
```

#### IDE Setup

**IntelliJ IDEA:**
1. File → Open → Select core_Java folder
2. Set Project SDK to desired Java version
3. Navigate to any .java file and click Run (▶)

**VS Code:**
1. Install Java Extension Pack
2. Open folder as workspace
3. Click Run on any .java file or use F5 for debugging

### Recommended Study Approach

1. **Choose a topic** from the repository structure
2. **Read the documentation** (this README or specific .one files)
3. **Study the example code** - Start with simpler examples
4. **Run and modify** - Execute code and make changes to understand behavior
5. **Experiment** - Create variations and test your understanding
6. **Challenge yourself** - Try interview questions in the Interview_code folder

### Quick Navigation Guide

**Want to learn about...**

| Topic | Location |
|-------|----------|
| OOP Fundamentals | [Basic_concept/](Basic_concept/) |
| Inheritance & Polymorphism | [Inheritance/](Inheritance/), [Polymorphism/](Polymorphism/) |
| Collections | [Collection/](Collection/), [Iterator/](Iterator/) |
| Lambda & Streams | [java8/StreamApiConcept/](java8/StreamApiConcept/), [java8/methodReference/](java8/methodReference/) |
| Date/Time | [java8/DateTimeAPI/](java8/DateTimeAPI/) |
| Type Inference | [Java10_11/](Java10_11/) |
| Switch Expressions | [Java14/](Java14/) |
| Records | [Java16/](Java16/) |
| Pattern Matching | [Java21/](Java21/) |
| Threading | [MultiThreading/](MultiThreading/) |
| Advanced Concurrency | `DD_Multithreading_*` folders |
| Design Patterns | `Singleton_6_Ways` |
| Interview Problems | [Java8_code/Interview_code/](Java8_code/Interview_code/) |
| Real-world Problems | [Java8_code/CollectorWithJava8/](Java8_code/CollectorWithJava8/) |
| String Operations | [StringEx/](StringEx/) |
| Wrapper Classes | [WrapperClassEx/](WrapperClassEx/) |

---

## Tips for Effective Learning

1. **Build Incrementally:** Start with fundamentals before advanced topics
2. **Understand Concepts:** Don't just memorize - understand the "why" behind code
3. **Practice Regularly:** Run examples multiple times with modifications
4. **Read Javadoc:** Use official Java documentation alongside examples
5. **Write Your Own:** After studying examples, write similar code from scratch
6. **Debug Code:** Use IDE debugger to step through code execution
7. **Explore Variations:** Modify examples and observe results
8. **Interview Practice:** Solve problems without looking at solutions first
9. **Review Regularly:** Revisit fundamentals periodically
10. **Track Progress:** Mark topics as learned and test yourself

---

## Version Compatibility

| Java Version | Key Features | Folder |
|------|-------------|--------|
| Java 8 | Lambdas, Streams, Date/Time API | [java8/](java8/), [Java8_code/](Java8_code/) |
| Java 9 | Module system, Diamond operator | [Java9/](Java9/) |
| Java 10-11 | Local variable type inference (`var`) | [Java10_11/](Java10_11/) |
| Java 14 | Switch expressions | [Java14/](Java14/) |
| Java 15 | Text blocks | [Java15/](Java15/) |
| Java 16 | Records | [Java16/](Java16/) |
| Java 17 | Sealed classes | [Java17/](Java17/) |
| Java 21 | Pattern matching | [Java21/](Java21/) |
| Java 22 | Unnamed variables | [Java22/](Java22/) |
| Java 25 | Compact source files | [Java25/](Java25/) |

---

## File Organization Best Practices

Each topic folder follows this structure:

```
TopicFolder/
├── *.java           # Executable example files
├── *Notes           # Documentation files
└── README.md        # Topic-specific guide (when available)
```

## Contributing Notes

To explore and understand any file:

1. **Check the containing folder** to understand the context
2. **Read class comments** for quick overview
3. **Review method names** - they're usually self-explanatory
4. **Run the examples** to see the output
5. **Refer to this README** for guidance on learning order

---

## Additional Resources

- **Official Java Documentation:** https://docs.oracle.com/en/java/
- **Java Enhancement Proposals (JEPs):** https://openjdk.org/jeps/
- **Java Language Specification:** https://docs.oracle.com/javase/specs/

---

This repository provides a structured, comprehensive learning journey from Java fundamentals to cutting-edge Java 25 features. Use it as both a learning resource and a reference guide throughout your Java development career.