# Java14 - Switch Expressions

## Overview

Java 14 introduced switch expressions, allowing switch to return values and use modern syntax with arrow operators. This represents a significant evolution from traditional switch statements.

## What You'll Learn

- Switch expressions as statements
- Arrow operator (`->`) syntax
- Multiple case labels in single statement
- Switch with yield keyword
- Traditional switch vs modern switch
- Type safety and pattern compatibility

## Key Concepts Covered

1. **Switch Expressions**: Return values from switch
2. **Arrow Syntax**: Modern case syntax with `->`
3. **Yield Keyword**: Explicit value return in switch blocks
4. **Case Grouping**: Multiple labels, single action
5. **Exhaustiveness**: Compiler checks all cases

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `SwitchEnhancementDemo.java` | Basic switch expression syntax | Arrow operator and return values |
| `SwitchReturnDemo.java` | Switch returning different types | Expression evaluation |
| `SwitchYieldDemo.java` | Using yield keyword | Explicit returns in blocks |

## How to Run

### Switch Enhancements
```bash
javac SwitchEnhancementDemo.java
java SwitchEnhancementDemo
```

### Switch Return Values
```bash
javac SwitchReturnDemo.java
java SwitchReturnDemo
```

### Switch with Yield
```bash
javac SwitchYieldDemo.java
java SwitchYieldDemo
```

## Quick Start

1. Start with `SwitchEnhancementDemo.java` to understand arrow syntax
2. Review `SwitchReturnDemo.java` for returning values
3. Study `SwitchYieldDemo.java` for yield keyword

## Traditional vs Modern Switch

### Traditional Switch (Before Java 14)
```java
String day = "MONDAY";
String dayType = "";

switch (day) {
    case "SATURDAY":
    case "SUNDAY":
        dayType = "Weekend";
        break;
    case "MONDAY":
    case "TUESDAY":
    case "WEDNESDAY":
    case "THURSDAY":
    case "FRIDAY":
        dayType = "Weekday";
        break;
    default:
        dayType = "Unknown";
}
```

### Modern Switch Expression (Java 14+)
```java
String day = "MONDAY";

String dayType = switch (day) {
    case "SATURDAY", "SUNDAY" -> "Weekend";
    case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> "Weekday";
    default -> "Unknown";
};
```

## Arrow Operator Syntax

```java
// Single action
case "A" -> System.out.println("Letter A");

// Multiple actions with braces
case "A" -> {
    System.out.println("Letter A");
    System.out.println("First letter");
}

// With yield for return value
case "A" -> {
    int value = 1;
    yield value;
}
```

## Switch Expression Examples

### Simple Value Return
```java
int day = 3;
String dayName = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    case 4 -> "Thursday";
    case 5 -> "Friday";
    case 6, 7 -> "Weekend";
    default -> "Unknown";
};
```

### Complex Logic with Yield
```java
String result = switch (value) {
    case 1, 2 -> {
        // Complex logic
        int calc = value * 10;
        yield "Result: " + calc;
    }
    case 3 -> {
        // Different logic
        yield "Three";
    }
    default -> "Other";
};
```

## Important Concepts

### Exhaustiveness
- Switch must cover all possible cases
- Use `default` case for safety
- Compile-time checking for enums

### No Fall-through
- Arrow syntax eliminates fall-through
- No need for break statements
- Clearer intent and fewer bugs

### Return Type Consistency
```java
// All branches must have compatible return types
int result = switch (value) {
    case 1 -> 10;
    case 2 -> 20;
    default -> 0;  // Must be int
};
```

## Comparison: Traditional vs Modern

| Aspect | Traditional | Modern |
|--------|-----------|--------|
| **Return Value** | No (set variable) | Yes (expression) |
| **Fall-through** | Accidental bugs | None by default |
| **Case Syntax** | case/break | case -> |
| **Multiple Cases** | Stacked | case 1, 2, 3 -> |
| **Readability** | Verbose | Concise |
| **Type Safety** | Manual | Compiler-checked |

## Yield Keyword

```java
// Simple arrow - direct return
case 1 -> 10;

// Block with yield - for complex logic
case 1 -> {
    int x = calculate();
    if (x > 0) yield x;
    else yield -1;
}

// Yield required for flow control
case 1 -> {
    if (condition) yield "yes";
    else yield "no";
}
```

## Related Topics

- For pattern matching: See [Java21/](../Java21/)
- For traditional control flow: See [Control Flow Statement.one](../Control%20Flow%20Statement.one)
- For language evolution: See [Modern Java Features (Java 9–25)](../Modern%20Java%20Features%20%28Java%209–25%29)

## Prerequisites

- Understanding of traditional switch statements
- Familiar with expressions vs statements
- Java 14+ compiler required

## Tips for Learning

1. **Start with simple switches**: Single-line arrows first
2. **Compare traditional vs modern**: See improvements
3. **Use in assignments**: Switch as expression
4. **Test exhaustiveness**: Let compiler guide you
5. **Avoid fall-through**: Cleaner code

## Common Mistakes to Avoid

1. Forgetting case values in switch expression
2. Using break in arrow syntax (not needed)
3. Missing default case (compiler warns)
4. Inconsistent return types
5. Fall-through bugs (not possible with ->)

## Best Practices

1. **Use switch expressions** instead of traditional switch
2. **Group related cases** with commas
3. **Use arrow syntax** for clarity
4. **Include default case** for safety
5. **Keep cases concise** or use yield for complexity
6. **Leverage compiler checking** for exhaustiveness

## Code Evolution Example

### Before (Pre-Java 14)
```java
int daysInMonth;
switch (month) {
    case JANUARY:
    case MARCH:
    case MAY:
    case JULY:
    case AUGUST:
    case DECEMBER:
        daysInMonth = 31;
        break;
    case APRIL:
    case JUNE:
    case SEPTEMBER:
    case NOVEMBER:
        daysInMonth = 30;
        break;
    case FEBRUARY:
        daysInMonth = 28;
        break;
    default:
        daysInMonth = -1;
}
```

### After (Java 14+)
```java
int daysInMonth = switch (month) {
    case JANUARY, MARCH, MAY, JULY, AUGUST, DECEMBER -> 31;
    case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
    case FEBRUARY -> 28;
};
```

## Advanced Topics

- **Pattern Matching in Switch** (Java 21): Type patterns and destructuring
- **Sealed Classes** (Java 17): Exhaustiveness with restricted hierarchies
- **Record Patterns** (Java 21): Destructuring records in switch
