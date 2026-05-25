# java8 - Java 8 Functional Programming Features

## Overview

This folder contains comprehensive examples of Java 8's major features: the Stream API, lambda expressions, method references, the modern Date/Time API, and default methods in interfaces. Java 8 introduced functional programming paradigm to Java.

## What You'll Learn

- Lambda expressions and functional interfaces
- Stream API for functional data processing
- Method references as lambda alternatives
- Modern Date/Time API (java.time package)
- Default methods in interfaces
- Functional approach to problem solving

## Subfolders

### StreamApiConcept/
Functional programming with Streams for filtering, mapping, and processing collections.

**Files:**
- `PrintEvenNoUsingGivenArray.java` - Stream filtering for even numbers
- `PrintListOfMarksAndAdd5GraceMarks.java` - Stream mapping to add grace marks
- `CountFailedStudent.java` - Stream filtering and counting

**Key Topics:** filter(), map(), count(), reduce(), intermediate vs terminal operations

### DateTimeAPI/
Modern date and time handling replacing old java.util.Date.

**Files:**
- `GetCurrentDateTime.java` - Get current date, time, instant
- `DateToInstant.java` - Convert legacy Date to Instant
- `DateToLDAndLDT.java` - Convert to LocalDate and LocalDateTime
- `InstantToLocalDateTime.java` - Instant to LocalDateTime conversions
- `ChronoDate.java` - Different calendar systems (Chronology)
- `TemporalAdjustor.java` - Adjust dates (next Monday, end of month)
- `ZoneMethod.java` - Time zone operations
- `TestDate.java` - Comprehensive date/time tests

**Key Topics:** LocalDate, LocalTime, LocalDateTime, Instant, ZonedDateTime, ZoneId, temporal adjusters, chronologies

### methodReference/
Method references as concise alternative to lambda expressions.

**Files:**
- `StaticMethodReference.java` - Reference to static methods (ClassName::methodName)
- `ConstructorReference.java` - Reference to constructors (ClassName::new)
- `InstanceMethodReferenceOfParticularObject.java` - Instance method of specific object
- `InstanceMethodReferenceOfArbitraryObject.java` - Instance method of arbitrary object

**Key Topics:** Four types of method references, functional interface implementation, cleaner syntax

### defaultMethod/
Interface evolution with default method implementations.

**Files:**
- `Test.java` - Default method examples and usage

**Key Topics:** Default methods in interfaces, static methods in interfaces, backward compatibility

### Type_Repeating_Annotations/
Custom annotations with repeating capability.

**Files:**
- `CustomAnnotations.java` - Define and use custom repeating annotations

**Key Topics:** Annotation creation, @Repeatable, meta-annotations, annotation processing

## How to Run Examples

### Stream Example
```bash
cd StreamApiConcept
javac PrintEvenNoUsingGivenArray.java
java PrintEvenNoUsingGivenArray
```

### Date/Time Example
```bash
cd DateTimeAPI
javac GetCurrentDateTime.java
java GetCurrentDateTime
```

### Method Reference Example
```bash
cd methodReference
javac StaticMethodReference.java
java StaticMethodReference
```

## Quick Start Learning Path

1. **Start with Streams**: 
   - PrintEvenNoUsingGivenArray.java (simple filtering)
   - PrintListOfMarksAndAdd5GraceMarks.java (mapping)

2. **Learn Date/Time**:
   - GetCurrentDateTime.java (basics)
   - DateToLDAndLDT.java (conversions)
   - TemporalAdjustor.java (date manipulation)

3. **Study Method References**:
   - StaticMethodReference.java (simplest form)
   - ConstructorReference.java (object creation)

4. **Understand Defaults**:
   - defaultMethod/Test.java (interface improvements)

## Key Concepts

### Lambda Expressions
```java
// Traditional approach
Collections.sort(list, new Comparator<String>() {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});

// Lambda approach
Collections.sort(list, (a, b) -> a.compareTo(b));
```

### Stream Operations
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
    .filter(n -> n % 2 == 0)      // Intermediate operation
    .map(n -> n * 2)              // Intermediate operation
    .forEach(System.out::println); // Terminal operation
```

### Method References
```java
// Lambda
list.forEach(x -> System.out.println(x));

// Method reference
list.forEach(System.out::println);
```

### Date/Time API
```java
// Old API (not recommended)
Date date = new Date();

// New API (recommended)
LocalDate today = LocalDate.now();
LocalDateTime now = LocalDateTime.now();
Instant instant = Instant.now();
```

## Performance Tips

| Area | Tip |
|------|-----|
| **Streams** | Avoid intermediate list creation |
| **Parallel Streams** | Use only for large datasets |
| **Date/Time** | Prefer LocalDate for pure date work |
| **Time Zones** | Use ZonedDateTime when needed |

## Important Concepts

1. **Functional Interface**: Interface with single abstract method
2. **Stream Pipeline**: Source → Intermediate ops → Terminal op
3. **Lazy Evaluation**: Streams don't execute until terminal operation
4. **Immutability**: java.time objects are immutable and thread-safe
5. **TimeZone Awareness**: Always consider time zones in applications

## Related Topics

- For advanced streams: See [Java8_code/](../Java8_code/)
- For interview problems: See [Java8_code/Interview_code/](../Java8_code/Interview_code/)
- For collector operations: See [Java8_code/CollectorWithJava8/](../Java8_code/CollectorWithJava8/)

## Prerequisites

- Understanding of Java syntax
- Familiar with collections and loops
- Basic functional programming concepts

## Tips for Learning

1. **Start simple**: FilterEvenNumbers before complex streams
2. **Understand lazy evaluation**: Streams don't run until terminal
3. **Practice method references**: They're concise but must be intuitive
4. **Use LocalDate**: For dates, ZonedDateTime for global applications
5. **Combine operations**: See power of stream chaining

## Common Mistakes to Avoid

1. Forgetting terminal operations in streams
2. Creating intermediate lists (performance hit)
3. Assuming Date/Time APIs are synchronized
4. Using old Date class in new code
5. Not understanding TimeZone implications

## Best Practices

1. **Use Streams** for functional data processing
2. **Use LocalDate** for date-only operations
3. **Use ZonedDateTime** for global/timezone-aware applications
4. **Use Method References** when appropriate for clarity
5. **Avoid parallel streams** unless necessary

## Advanced Topics

- **Collectors**: Complex aggregation and grouping (see Java8_code/)
- **Optional**: Handling null values functionally
- **Parallel Streams**: Multi-threaded stream processing
- **Custom Streams**: Creating your own stream sources
