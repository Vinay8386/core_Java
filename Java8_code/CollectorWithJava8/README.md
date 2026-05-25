# Java8_code/CollectorWithJava8 - Advanced Data Aggregation and Analysis

## Overview

This folder demonstrates advanced Stream API collector patterns for real-world data analysis. Features employee data examples with grouping, partitioning, filtering, sorting, and multi-level aggregations.

## What You'll Learn

- Grouping data by single and multiple criteria
- Partitioning collections by predicates
- Aggregating and calculating statistics
- Sorting by multiple fields
- Finding maximum and minimum elements
- Custom filtering and transformations
- Practical business logic patterns

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `Employee.java` | Employee domain model | Data class with fields |
| `CountByGender.java` | Count employees by gender | Collectors.groupingBy with counting |
| `DeptWiseAvgSalary.java` | Average salary per department | Collectors.groupingBy with averaging |
| `EmpNameStartWith.java` | Filter by name prefix | Custom filtering patterns |
| `FetchSalryLessThanThirdHighest.java` | Complex salary comparison | Advanced stream operations |
| `FetchTop3SalaryEmpDetails.java` | Top N elements | Sorting and limiting streams |
| `FilterEmpByDeptAndCity.java` | Multi-field filtering | Chained filter conditions |
| `FilterEmployeeUsingAge.java` | Age-based filtering | Range filtering patterns |
| `GroupByCityAndCalAvgAge.java` | Multi-level grouping | Nested grouping patterns |
| `MaxAndMinSalaryEmp.java` | Find extremes | Collectors.maxBy/minBy |
| `PartitionBasedOnGender.java` | Partition by predicate | Collectors.partitioningBy |
| `SalaryPerDepartment.java` | Sum salary by department | Collectors.groupingBy with summing |
| `SortByName.java` | Sort by name field | Comparator usage |
| `SortBySalary.java` | Sort by salary field | Custom comparator |
| `SortListInBothAscDesc.java` | Ascending and descending | Sort order control |

## How to Run

### Count By Gender
```bash
javac Employee.java CountByGender.java
java CountByGender
```
Output:
```
Male: 5
Female: 3
```

### Department-wise Average Salary
```bash
javac Employee.java DeptWiseAvgSalary.java
java DeptWiseAvgSalary
```

### Max and Min Salary Employees
```bash
javac Employee.java MaxAndMinSalaryEmp.java
java MaxAndMinSalaryEmp
```

### Partition By Gender
```bash
javac Employee.java PartitionBasedOnGender.java
java PartitionBasedOnGender
```

### Salary Per Department
```bash
javac Employee.java SalaryPerDepartment.java
java SalaryPerDepartment
```

## Quick Learning Path

1. **Start**: `CountByGender.java` - Basic grouping
2. **Progress**: `DeptWiseAvgSalary.java` - Aggregation functions
3. **Learn**: `PartitionBasedOnGender.java` - Partitioning pattern
4. **Master**: `GroupByCityAndCalAvgAge.java` - Multi-level grouping
5. **Practice**: `FetchTop3SalaryEmpDetails.java` - Complex queries

## Common Patterns

### Grouping by Single Attribute
```java
// Group employees by department
Map<String, List<Employee>> byDept = employees.stream()
    .collect(groupingBy(Employee::getDepartment));

// Group by gender
Map<String, List<Employee>> byGender = employees.stream()
    .collect(groupingBy(Employee::getGender));
```

### Grouping with Aggregation
```java
// Count by department
Map<String, Long> deptCounts = employees.stream()
    .collect(groupingBy(
        Employee::getDepartment,
        counting()
    ));

// Average salary by department
Map<String, Double> avgSalaries = employees.stream()
    .collect(groupingBy(
        Employee::getDepartment,
        averagingDouble(Employee::getSalary)
    ));

// Sum salary by department
Map<String, Integer> totalSalary = employees.stream()
    .collect(groupingBy(
        Employee::getDepartment,
        summingInt(Employee::getSalary)
    ));
```

### Partitioning By Predicate
```java
// Partition into high and low earners
Map<Boolean, List<Employee>> partition = employees.stream()
    .collect(partitioningBy(e -> e.getSalary() > 50000));

List<Employee> highEarners = partition.get(true);
List<Employee> lowEarners = partition.get(false);

// Partition with counting
Map<Boolean, Long> counts = employees.stream()
    .collect(partitioningBy(
        e -> e.getSalary() > 50000,
        counting()
    ));
```

### Finding Max and Min
```java
// Find highest salary employee
Employee maxSalaryEmp = employees.stream()
    .max(comparingInt(Employee::getSalary))
    .orElse(null);

// Find lowest salary employee
Employee minSalaryEmp = employees.stream()
    .min(comparingInt(Employee::getSalary))
    .orElse(null);

// Using collectors
Employee maxEmp = employees.stream()
    .collect(maxBy(comparingInt(Employee::getSalary)))
    .orElse(null);
```

### Sorting Operations
```java
// Sort by name ascending
employees.stream()
    .sorted(comparingInt(Employee::getAge))
    .forEach(System.out::println);

// Sort by salary descending
employees.stream()
    .sorted(comparingInt(Employee::getSalary).reversed())
    .forEach(System.out::println);

// Sort by multiple fields
employees.stream()
    .sorted(comparing(Employee::getDepartment)
        .thenComparing(Employee::getName))
    .forEach(System.out::println);
```

### Filtering Patterns
```java
// Single condition
employees.stream()
    .filter(e -> e.getSalary() > 50000)
    .collect(toList());

// Multiple conditions
employees.stream()
    .filter(e -> e.getDepartment().equals("Engineering"))
    .filter(e -> e.getAge() > 25)
    .collect(toList());

// Complex predicates
Predicate<Employee> highSalary = e -> e.getSalary() > 50000;
Predicate<Employee> engineeringDept = e -> e.getDepartment().equals("Engineering");

employees.stream()
    .filter(highSalary.and(engineeringDept))
    .collect(toList());
```

### Multi-level Grouping
```java
// Group by department, then by city
Map<String, Map<String, List<Employee>>> byDeptAndCity = 
    employees.stream()
    .collect(groupingBy(
        Employee::getDepartment,
        groupingBy(Employee::getCity)
    ));

// Group by department, then count by gender
Map<String, Map<String, Long>> byDeptThenGender = 
    employees.stream()
    .collect(groupingBy(
        Employee::getDepartment,
        groupingBy(
            Employee::getGender,
            counting()
        )
    ));
```

## Employee Class Structure

```java
public class Employee {
    private int id;
    private String name;
    private String department;
    private String city;
    private String gender;
    private int age;
    private double salary;
    
    // Constructor, getters, toString
}
```

## Collectors Cheat Sheet

| Collector | Purpose | Example |
|-----------|---------|---------|
| `toList()` | Collect to list | `.collect(toList())` |
| `toSet()` | Collect to set | `.collect(toSet())` |
| `counting()` | Count elements | `.collect(counting())` |
| `summingInt()` | Sum integers | `.collect(summingInt(e -> e))` |
| `averagingInt()` | Average integers | `.collect(averagingInt(e -> e))` |
| `maxBy()` | Find maximum | `.collect(maxBy(comparing(e -> e)))` |
| `minBy()` | Find minimum | `.collect(minBy(comparing(e -> e)))` |
| `groupingBy()` | Group elements | `.collect(groupingBy(e -> e))` |
| `partitioningBy()` | Partition elements | `.collect(partitioningBy(e -> e > 0))` |

## Related Topics

- Main folder: [Java8_code/](../)
- Stream API: [java8/StreamApiConcept/](../../java8/StreamApiConcept/)
- Interview preparation: [Java8_code/Interview_code/](../Interview_code/)
- Map operations: [Java8_code/MapQuestion/](../MapQuestion/)

## Prerequisites

- Understanding of lambda expressions
- Familiar with streams
- Comfortable with comparators
- Java 8+ required

## Tips for Learning

1. **Run examples**: See output firsthand
2. **Modify data**: Change Employee instances
3. **Experiment with collectors**: Try different aggregations
4. **Trace execution**: Step through the logic
5. **Compare outputs**: Understand differences
6. **Combine patterns**: Chain multiple operations
7. **Time performance**: Large datasets reveal efficiency

## Common Mistakes to Avoid

1. Forgetting import statements (static imports for collectors)
2. Using wrong collector for the task
3. Not handling empty collections (NullPointerException)
4. Creating intermediate lists (performance issue)
5. Mutating source list (unexpected results)
6. Assuming order in grouping results (use LinkedHashMap if needed)
7. Not closing streams for file operations

## Best Practices

1. **Use collectors**: Don't implement aggregation manually
2. **Chain properly**: Build logical groups
3. **Handle empty results**: Use Optional or defaults
4. **Test edge cases**: Empty lists, single elements, nulls
5. **Document complex queries**: Explain unusual logic
6. **Use LinkedHashMap**: When order matters in grouping
7. **Prefer immutability**: Don't modify source data

## Performance Considerations

| Operation | Time | Space |
|-----------|------|-------|
| filter() | O(n) | O(1) |
| map() | O(n) | O(1) |
| groupingBy() | O(n) | O(k) k=groups |
| sorted() | O(n log n) | O(n) |
| distinct() | O(n) | O(n) |

## Advanced Topics

- **Custom Collectors**: Building domain-specific aggregations
- **Parallel Collectors**: Distributed aggregation
- **Mutable Reduction**: Collectors.toCollection()
- **Finisher Functions**: Custom collection assembly
- **Lazy Evaluation**: When collectors execute
