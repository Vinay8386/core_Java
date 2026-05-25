# java8/StreamApiConcept - Stream API Fundamentals

## Overview

This folder demonstrates the Stream API introduced in Java 8, enabling functional programming with collections through fluent, pipeline-based operations like filter, map, and reduce.

## What You'll Learn

- Stream creation from collections
- Filter for selecting elements
- Map for transforming elements
- Terminal operations (collect, forEach, count)
- Intermediate vs terminal operations
- Lazy evaluation in streams
- Chaining operations

## Key Concepts Covered

1. **Stream Creation**: From lists, arrays, values
2. **Filter**: Select elements matching criteria
3. **Map**: Transform elements to different values
4. **Intermediate Operations**: Lazy, chainable
5. **Terminal Operations**: Trigger execution
6. **Collectors**: Accumulating results
7. **Reduce**: Combining elements

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `PrintEvenNoUsingGivenArray.java` | Filter for even numbers | Basic filtering |
| `PrintListOfMarksAndAdd5GraceMarks.java` | Map to transform values | Element transformation |
| `CountFailedStudent.java` | Filter and count operations | Combining filters with counting |

## How to Run

### Filter Even Numbers
```bash
javac PrintEvenNoUsingGivenArray.java
java PrintEvenNoUsingGivenArray
```

### Map Grace Marks
```bash
javac PrintListOfMarksAndAdd5GraceMarks.java
java PrintListOfMarksAndAdd5GraceMarks
```

### Count Failed Students
```bash
javac CountFailedStudent.java
java CountFailedStudent
```

## Quick Start

1. Run `PrintEvenNoUsingGivenArray.java` for filtering
2. Run `PrintListOfMarksAndAdd5GraceMarks.java` for mapping
3. Run `CountFailedStudent.java` for combined operations
4. Modify examples and experiment

## Stream Pipeline

### Basic Structure
```
Source → Intermediate Ops → Terminal Op
```

### Example
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

numbers.stream()
    .filter(n -> n % 2 == 0)      // Intermediate: filter
    .map(n -> n * 2)              // Intermediate: transform
    .forEach(System.out::println); // Terminal: execute
```

## Filter Operation

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

// Filter for even numbers
List<Integer> evens = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
// Result: [2, 4, 6]

// Multiple filters
numbers.stream()
    .filter(n -> n > 2)     // n > 2
    .filter(n -> n < 6)     // AND n < 6
    .forEach(System.out::println);
// Result: 3, 4, 5
```

## Map Operation

```java
List<String> words = Arrays.asList("hello", "world");

// Transform to uppercase
words.stream()
    .map(String::toUpperCase)
    .forEach(System.out::println);
// Result: HELLO, WORLD

// Transform to length
words.stream()
    .map(String::length)
    .forEach(System.out::println);
// Result: 5, 5
```

## Terminal Operations

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// forEach - perform action
numbers.stream().forEach(System.out::println);

// collect - gather results
List<Integer> evens = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());

// count - count elements
long count = numbers.stream()
    .filter(n -> n > 2)
    .count();

// findFirst - get first element
Optional<Integer> first = numbers.stream()
    .filter(n -> n > 2)
    .findFirst();

// reduce - combine elements
int sum = numbers.stream()
    .reduce(0, Integer::sum);
```

## Important Concepts

### Lazy Evaluation
- Intermediate operations don't execute until terminal operation
- Terminal operation triggers entire pipeline execution
- Efficient for large datasets

### Stateless vs Stateful
- **Stateless**: filter, map (process one element)
- **Stateful**: distinct, sorted, limit (need to track state)

### Performance
- **Short-circuit**: findFirst stops after first match
- **Avoid intermediate lists**: Chain operations
- **Use parallel()**: For large datasets with expensive operations

## Related Topics

- For advanced collectors: See [Java8_code/CollectorWithJava8/](../../Java8_code/CollectorWithJava8/)
- For interview problems: See [Java8_code/Interview_code/](../../Java8_code/Interview_code/)
- For method references: See [java8/methodReference/](../methodReference/)

## Prerequisites

- Understanding of lambda expressions
- Familiar with collections
- Java 8+ required

## Tips for Learning

1. **Start with filter**: Easiest to understand
2. **Learn map**: Data transformation
3. **Understand lazy evaluation**: Key insight
4. **Use method references**: Cleaner than lambdas
5. **Chain operations**: Power of streams

## Common Mistakes to Avoid

1. Forgetting terminal operation (stream not executed)
2. Modifying source list (unexpected behavior)
3. Creating intermediate lists (performance hit)
4. Assuming order in parallel streams
5. Using streams for side effects (use foreach instead)

## Best Practices

1. **Chain operations**: Don't create intermediate lists
2. **Use method references**: Over lambda expressions
3. **Prefer declarative**: What to do, not how
4. **Avoid side effects**: Keep streams functional
5. **Use parallel() sparingly**: When really needed

## Stream Collectors

```java
List<String> words = Arrays.asList("apple", "banana", "cherry");

// To List
List<String> result = words.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());

// To Set
Set<String> unique = words.stream()
    .collect(Collectors.toSet());

// Join as String
String joined = words.stream()
    .collect(Collectors.joining(", "));

// Count occurrences
Map<String, Long> counts = words.stream()
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
```

## Advanced Topics

- **FlatMap**: Flattening nested structures
- **Reduce**: Combining elements
- **Parallel Streams**: Multi-threaded processing
- **Custom Collectors**: Building aggregations
