# Java8_code - Advanced Java 8 Examples and Interview Preparation

## Overview

This folder contains advanced Java 8 examples, interview questions, and practical solutions demonstrating stream API operations, collectors, functional programming patterns, and real-world use cases.

## What You'll Learn

- Advanced collector patterns (grouping, partitioning, custom collectors)
- Stream operations for data analysis
- Interview coding problems and solutions
- Map transformation patterns
- Stream utilities and helper functions
- Parallel stream processing
- Optional and Supplier patterns
- Performance optimization with streams

## Repository Structure

### [CollectorWithJava8/](CollectorWithJava8/)
Advanced collector patterns with employee data analysis. 30+ files demonstrating grouping, partitioning, multi-level aggregations, and salary calculations.

### [Interview_code/](Interview_code/)
32 interview questions with solutions. Algorithmic problems, string manipulation, list operations, and stream-based solutions.

### [MapQuestion/](MapQuestion/)
Map transformation and filtering examples. Converting, sorting, and transforming maps and collections.

### [random_que/](random_que/)
Stream utilities and functional programming patterns. FlatMap, parallel streams, Optional usage, Supplier patterns.

## Quick Navigation

| Folder | Focus | Best For |
|--------|-------|----------|
| CollectorWithJava8 | Data aggregation | Learning collectors and grouping |
| Interview_code | Problem solving | Interview preparation |
| MapQuestion | Map operations | Data transformation |
| random_que | Stream utilities | Functional programming |

## Key Topics Covered

### 1. Collectors and Aggregation
```java
// Grouping by department
Map<String, List<Employee>> byDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment));

// Partitioning by salary threshold
Map<Boolean, List<Employee>> highEarners = employees.stream()
    .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
```

### 2. Stream Operations
```java
// Filter, map, reduce pattern
int totalSalary = employees.stream()
    .filter(e -> e.getDepartment().equals("Engineering"))
    .mapToInt(Employee::getSalary)
    .sum();
```

### 3. Interview Problem Patterns
```java
// FizzBuzz pattern
Stream.rangeClosed(1, 100)
    .map(n -> n % 15 == 0 ? "FizzBuzz" : 
              n % 3 == 0 ? "Fizz" :
              n % 5 == 0 ? "Buzz" : String.valueOf(n))
    .forEach(System.out::println);
```

### 4. Map Transformations
```java
// Sort map by value
map.entrySet().stream()
    .sorted(Map.Entry.comparingByValue())
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (e1, e2) -> e1,
        LinkedHashMap::new
    ));
```

### 5. Stream Utilities
```java
// FlatMap for nested collections
List<List<Integer>> nested = Arrays.asList(
    Arrays.asList(1, 2),
    Arrays.asList(3, 4)
);

List<Integer> flattened = nested.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
```

## How to Run Examples

### Collector Examples
```bash
cd CollectorWithJava8
javac EmployeeGroupingExample.java
java EmployeeGroupingExample
```

### Interview Solutions
```bash
cd Interview_code
javac Q1_TwoSum.java
java Q1_TwoSum
```

### Map Operations
```bash
cd MapQuestion
javac SortMapExample.java
java SortMapExample
```

### Stream Utilities
```bash
cd random_que
javac FlatMapExample.java
java FlatMapExample
```

## Learning Path

1. **Start with Collectors**: Understand grouping and partitioning
2. **Master Stream Operations**: Filter, map, reduce patterns
3. **Practice Interview Problems**: Q1-Q10 (basic), Q11-Q20 (intermediate), Q21-Q32 (advanced)
4. **Learn Map Transformations**: Sorting, filtering maps
5. **Explore Utilities**: FlatMap, parallel streams, Optional

## Important Patterns

### Grouping Pattern
```java
// Group employees by department
Map<String, List<Employee>> byDept = employees.stream()
    .collect(groupingBy(Employee::getDepartment));

// Count by department
Map<String, Long> deptCounts = employees.stream()
    .collect(groupingBy(Employee::getDepartment, counting()));

// Average salary by department
Map<String, Double> avgSalary = employees.stream()
    .collect(groupingBy(
        Employee::getDepartment,
        averagingInt(Employee::getSalary)
    ));
```

### Partitioning Pattern
```java
// Split by predicate
Map<Boolean, List<Employee>> partition = employees.stream()
    .collect(partitioningBy(e -> e.getSalary() > 50000));

List<Employee> highEarners = partition.get(true);
List<Employee> lowEarners = partition.get(false);
```

### Optional Pattern
```java
// Safe null handling
Optional<Employee> emp = employees.stream()
    .filter(e -> e.getId() == 5)
    .findFirst();

// Handle presence
emp.ifPresent(e -> System.out.println(e.getName()));

// Default value
String name = emp.map(Employee::getName).orElse("Unknown");
```

## Stream vs Loop Performance

| Scenario | Stream | Loop |
|----------|--------|------|
| Small dataset | Slower (overhead) | Faster |
| Large dataset | Faster (parallel) | Slower |
| Readability | Excellent | Good |
| Maintainability | Better | Adequate |

## Related Resources

- Main folder: [java8/](../java8/)
- Stream API: [java8/StreamApiConcept/](../java8/StreamApiConcept/)
- Method References: [java8/methodReference/](../java8/methodReference/)
- DateTime API: [java8/DateTimeAPI/](../java8/DateTimeAPI/)

## Prerequisites

- Strong understanding of Java streams
- Familiar with lambda expressions
- Comfortable with collections
- Java 8+ required
- Basic problem-solving skills

## Tips for Success

1. **Run examples**: Execute and see output
2. **Modify code**: Experiment with variations
3. **Trace execution**: Understand flow step by step
4. **Compare approaches**: Stream vs traditional loops
5. **Time performance**: See when streams excel
6. **Solve problems**: Practice interview questions
7. **Understand patterns**: Reusable solutions

## Common Mistakes to Avoid

1. Creating intermediate lists (performance hit)
2. Modifying source collections in streams (side effects)
3. Using streams for single operations (overhead)
4. Forgetting terminal operations (nothing executes)
5. Assuming order in parallel streams
6. Using forEach for collection building (use collect)
7. Not closing resources (for file operations)

## Best Practices

1. **Chain operations**: Don't create intermediate lists
2. **Use proper collectors**: For aggregations
3. **Handle Optional**: Don't use Optional for everything
4. **Prefer immutability**: Work with unmodified originals
5. **Use parallelStream sparingly**: When really needed
6. **Document complex streams**: Explain non-obvious logic
7. **Test edge cases**: Empty lists, nulls, etc.

## Interview Preparation

### Question Categories

1. **Basic Streams** (Q1-Q5): filter, map, collect
2. **String Manipulation** (Q6-Q10): string operations
3. **Collections** (Q11-Q15): list and set operations
4. **Advanced Streams** (Q16-Q20): grouping, reducing
5. **Complex Problems** (Q21-Q26): multi-step solutions
6. **Edge Cases** (Q27-Q32): null handling, performance

### Difficulty Levels

| Level | Questions | Concepts |
|-------|-----------|----------|
| Easy | Q1-Q10 | filter, map, collect, basic operations |
| Medium | Q11-Q20 | grouping, partitioning, reducing |
| Hard | Q21-Q32 | complex transformations, optimization |

## Advanced Topics

- **Custom Collectors**: Building aggregation logic
- **Parallel Streams**: Multi-threaded processing
- **Mutable Accumulation**: StringBuilder in streams
- **Lazy Evaluation**: Understanding when execution happens
- **Stream vs Iterator**: Performance and use cases
- **Functional Composition**: Combining operations
- **Type Inference**: Complex generic scenarios

## Common Interview Questions

- "What's the difference between map and flatMap?"
- "How do you collect stream results into a Map?"
- "Explain partitioningBy vs groupingBy"
- "Why use streams over traditional loops?"
- "How do parallel streams work?"
- "What are common collector patterns?"
- "How to handle null in streams?"
