# Java21 - Pattern Matching

## Overview

Java 21 significantly enhances pattern matching capabilities, allowing destructuring of complex objects including records, array patterns, and refined type patterns. This represents a major step toward fully realizing Java's functional programming support.

## What You'll Learn

- Record patterns for destructuring
- Type patterns and instance checks
- Array patterns for element extraction
- Guard conditions in patterns
- Pattern matching in switch expressions
- Composing complex patterns
- Pattern matching best practices

## Key Concepts Covered

1. **Record Patterns**: Destructuring sealed types and records
2. **Type Patterns**: Safe type checking with automatic casting
3. **Array Patterns**: Pattern matching on arrays
4. **Guard Conditions**: Additional conditions in patterns
5. **Nested Patterns**: Composing patterns for complex structures
6. **Exhaustiveness**: Compiler checking all cases

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `SwitchExample.java` | Basic pattern matching in switch | Introduction to pattern syntax |
| `PatternMatchingInstanceOfExample.java` | Pattern matching with instanceof | Type-safe object checking |
| `TypePatternExamples.java` | Various type pattern examples | Pattern matching techniques |
| `RecordPatternExample.java` | Record destructuring patterns | Extracting record components |
| `AdvancedPatternMatchingSwitch.java` | Complex pattern matching | Nested and guard patterns |
| `Pattern_Matching_with_switch_Notes` | Detailed documentation | Learning material |

## How to Run

### Basic Switch Patterns
```bash
javac SwitchExample.java
java SwitchExample
```

### Type Patterns
```bash
javac PatternMatchingInstanceOfExample.java
java PatternMatchingInstanceOfExample
```

### Record Patterns
```bash
javac RecordPatternExample.java
java RecordPatternExample
```

### Advanced Patterns
```bash
javac AdvancedPatternMatchingSwitch.java
java AdvancedPatternMatchingSwitch
```

## Quick Start

1. Start with `SwitchExample.java` - Basic pattern syntax
2. Review `PatternMatchingInstanceOfExample.java` - Type patterns
3. Study `RecordPatternExample.java` - Record destructuring
4. Explore `AdvancedPatternMatchingSwitch.java` - Complex patterns
5. Check `Pattern_Matching_with_switch_Notes` for concepts

## Pattern Matching Evolution

### Java 16-20: Type Patterns
```java
Object obj = "Hello";
if (obj instanceof String s) {
    System.out.println(s.length());  // s is automatically String
}
```

### Java 21: Enhanced Patterns
```java
// Record patterns - destructuring
record Point(int x, int y) {}
Object obj = new Point(3, 4);

if (obj instanceof Point(int x, int y)) {
    System.out.println(x + ", " + y);  // Extract components
}
```

## Record Patterns

### Simple Record Pattern
```java
record Person(String name, int age) {}

// Before - manual destructuring
if (obj instanceof Person) {
    Person p = (Person) obj;
    String name = p.name();
    int age = p.age();
}

// Java 21 - Automatic destructuring
if (obj instanceof Person(String name, int age)) {
    System.out.println(name + ": " + age);
}
```

### Nested Record Patterns
```java
record Address(String street, String city) {}
record Person(String name, Address address) {}

// Destructure nested records
if (obj instanceof Person(String name, Address(String street, String city))) {
    System.out.println(name + " lives on " + street);
}
```

### Record Patterns in Switch
```java
Object obj = getPerson();

String result = switch (obj) {
    case Person(String name, int age) when age >= 18 -> 
        name + " is an adult";
    case Person(String name, int age) -> 
        name + " is a minor";
    default -> "Unknown";
};
```

## Type Patterns

### Basic Type Pattern
```java
// Automatic casting after pattern match
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}

// In switch
switch (obj) {
    case String s -> System.out.println(s.length());
    case Integer i -> System.out.println(i + 1);
    case Boolean b -> System.out.println(!b);
}
```

### Nested Type Patterns
```java
interface Shape { }
record Circle(int radius) implements Shape { }
record Rectangle(int width, int height) implements Shape { }

// Pattern matching on nested types
String describe(Object obj) {
    return switch (obj) {
        case Circle(int r) -> "Circle with radius " + r;
        case Rectangle(int w, int h) -> "Rectangle " + w + "x" + h;
        default -> "Unknown";
    };
}
```

## Guard Conditions

```java
// Guard with 'when' clause
String classify(Object obj) {
    return switch (obj) {
        case Integer i when i > 0 -> "Positive";
        case Integer i when i < 0 -> "Negative";
        case Integer i -> "Zero";
        default -> "Not integer";
    };
}

// Complex guards
String describe(Person p) {
    return switch (p) {
        case Person(String name, int age) 
            when age >= 18 && name.length() > 3 -> 
            name + " is an adult with long name";
        case Person(String name, int age) 
            when age >= 18 -> 
            name + " is an adult";
        default -> "Other";
    };
}
```

## Array Patterns

```java
// Java 21 array patterns
int[] arr = {1, 2, 3};

if (arr instanceof int[] { length: 3 }) {
    System.out.println("Array has 3 elements");
}

// Match first two elements
if (arr instanceof int[] { 1, 2, 3 }) {
    System.out.println("Matches pattern");
}
```

## Pattern Composition

### Combining Patterns
```java
// Sum type matching with sealed classes
sealed interface Result permits Success, Error {}
record Success(int value) implements Result {}
record Error(String message) implements Result {}

int process(Result result) {
    return switch (result) {
        case Success(int v) -> v;
        case Error(String msg) -> {
            System.out.println("Error: " + msg);
            yield -1;
        }
    };
}
```

### Wildcard Patterns
```java
// Using _ for ignored values
String describe(Object obj) {
    return switch (obj) {
        case Person(var name, _) -> "Person named " + name;
        case Point(var x, _) -> "Point with x=" + x;
        default -> "Unknown";
    };
}
```

## Important Concepts

### Exhaustiveness Checking
```java
sealed interface Color permits Red, Green, Blue {}
record Red() implements Color {}
record Green() implements Color {}
record Blue() implements Color {}

// Compiler checks all cases are covered
String getHex(Color c) {
    return switch (c) {
        case Red() -> "#FF0000";
        case Green() -> "#00FF00";
        case Blue() -> "#0000FF";
        // No default needed - exhaustive!
    };
}
```

### Pattern Precedence
```java
Object obj = 5;

String result = switch (obj) {
    case Integer i when i > 0 -> "Positive int";  // Checked first
    case Integer i -> "Any int";                  // Checked second
    case Object o -> "Any object";                // Fallback
};
```

## Pattern Matching Use Cases

| Use Case | Pattern Type | Benefit |
|----------|-------------|---------|
| **Polymorphism** | Type patterns | Safe casting |
| **Data Extraction** | Record patterns | Auto-destructuring |
| **Validation** | Guard conditions | Complex checks |
| **Type Hierarchies** | Sealed patterns | Exhaustive matching |
| **Collections** | Array patterns | Element access |

## Related Topics

- For sealed classes: See [Java17/](../Java17/)
- For records: See [Java16/](../Java16/)
- For switch expressions: See [Java14/](../Java14/)

## Prerequisites

- Understanding of records (Java 16+)
- Familiar with sealed classes (Java 17+)
- Switch expression knowledge (Java 14+)
- Java 21+ compiler required

## Tips for Learning

1. **Start with type patterns**: Simplest form
2. **Progress to record patterns**: Most powerful
3. **Use guards for conditions**: Additional validation
4. **Test exhaustiveness**: Leverage compiler checks
5. **Combine patterns**: Build complex matchers

## Common Mistakes to Avoid

1. Forgetting 'var' or explicit type in record pattern
2. Not using guards when conditions are needed
3. Missing cases in switch (rely on compiler)
4. Nested patterns without proper parentheses
5. Assuming patterns work in all contexts (they don't yet)

## Best Practices

1. **Use pattern matching** instead of instanceof casts
2. **Leverage exhaustiveness** for type safety
3. **Guard conditions** for complex validation
4. **Record patterns** for data extraction
5. **Combine with sealed** for maximum type safety

## Advanced Examples

### Expression Evaluator
```java
sealed interface Expr 
    permits NumberExpr, BinaryExpr, VariableExpr {}

record NumberExpr(double value) implements Expr {}
record BinaryExpr(Expr left, String op, Expr right) implements Expr {}
record VariableExpr(String name) implements Expr {}

double evaluate(Expr e, Map<String, Double> vars) {
    return switch (e) {
        case NumberExpr(double v) -> v;
        case VariableExpr(String name) -> vars.getOrDefault(name, 0.0);
        case BinaryExpr(Expr l, String op, Expr r) -> {
            double lv = evaluate(l, vars);
            double rv = evaluate(r, vars);
            yield switch (op) {
                case "+" -> lv + rv;
                case "-" -> lv - rv;
                case "*" -> lv * rv;
                case "/" -> lv / rv;
                default -> 0;
            };
        }
    };
}
```

## Advanced Topics

- **Pattern Matching on Records**: Deep destructuring
- **Exhaustiveness Analysis**: Compiler implementation
- **Any Pattern**: Pattern matching flexibility
- **Context-Specific Patterns**: Record/Array patterns in different contexts
- **Pattern Inference**: Reducing explicit type declarations
