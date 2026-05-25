# Java22 - Unnamed Variables and Patterns

## Overview

Java 22 introduces unnamed variables and patterns (using the underscore `_`), allowing developers to explicitly mark variables that are intentionally unused. This improves code clarity and reduces compiler warnings.

## What You'll Learn

- Unnamed variable syntax using `_`
- Unnamed patterns in destructuring
- Using unnamed in loops and catch blocks
- Benefits of explicit unused variables
- When to use unnamed patterns
- Code clarity improvements

## Key Concepts Covered

1. **Unnamed Variables**: Using `_` for intentionally unused variables
2. **Unnamed Patterns**: Pattern matching with ignored values
3. **Clarity**: Explicit intent that variable is ignored
4. **Warnings**: Reducing compiler warnings for unused variables
5. **Compatibility**: Using across different contexts

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `UnnamedVariableAndPatternExample.java` | Examples of unnamed variables and patterns | Syntax and usage |
| `Unnamed_Variable_And_Pattern_Notes` | Detailed documentation | Learning material |

## How to Run

```bash
javac UnnamedVariableAndPatternExample.java
java UnnamedVariableAndPatternExample
```

## Quick Start

1. Run `UnnamedVariableAndPatternExample.java` to see examples
2. Study the different use cases
3. Understand when to use `_` vs named variables
4. Practice refactoring existing code
5. Check `Unnamed_Variable_And_Pattern_Notes` for details

## Unnamed Variables Syntax

### Basic Unnamed Variable
```java
// Before Java 22
Object obj = getValue();  // Intentionally unused

// Java 22+ - Explicit intent
Object _ = getValue();

// Clear that we're ignoring the value
_ = getValue();
```

### In For-Each Loops
```java
// Before - if you don't need the variable
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
for (String ignored : names) {
    System.out.println("Processing item");
}

// Java 22 - Explicit
for (String _ : names) {
    System.out.println("Processing item");
}

// Traditional index loop
for (int i = 0; i < 10; i++) {
    System.out.println("Iteration");
}

// With unnamed
for (int _ = 0; _ < 10; _++) {
    System.out.println("Iteration");
}
```

### In Try-Catch Blocks
```java
// Before
try {
    risky();
} catch (IOException e) {
    // Intentionally ignored
    System.out.println("Operation failed");
}

// Java 22 - Explicit
try {
    risky();
} catch (IOException _) {
    System.out.println("Operation failed");
}
```

## Unnamed Patterns

### Record Pattern with Unnamed
```java
record Point(int x, int y) {}

// Before - unused variable
if (obj instanceof Point(int x, int y)) {
    System.out.println(x);  // Only using x
}

// Java 22 - Explicit intent
if (obj instanceof Point(int x, int _)) {
    System.out.println(x);  // Clear y is ignored
}

// Both unnamed
if (obj instanceof Point(int _, int _)) {
    System.out.println("Is a Point, but don't need values");
}
```

### In Switch Patterns
```java
sealed interface Result permits Success, Error {}
record Success(int value) implements Result {}
record Error(String message) implements Result {}

// Before - unused variables
String describe(Result r) {
    return switch (r) {
        case Success(int value) -> "Success";  // value unused
        case Error(String message) -> "Failed"; // message unused
    };
}

// Java 22 - Clear intent
String describe(Result r) {
    return switch (r) {
        case Success(int _) -> "Success";
        case Error(String _) -> "Failed";
    };
}
```

### Nested Unnamed Patterns
```java
record Address(String street, String city) {}
record Person(String name, Address address) {}

// Only want name, nested address ignored
if (obj instanceof Person(String name, Address(String _, String _))) {
    System.out.println(name);
}

// Everything unnamed except what we need
if (obj instanceof Person(String name, Address(String street, String _))) {
    System.out.println(name + " on " + street);
}
```

## Important Concepts

### Why Unnamed Variables?

**Benefits:**
1. **Explicit Intent**: Shows variable is intentionally unused
2. **Cleaner Code**: Avoids compiler warnings
3. **Documentation**: Code documents itself
4. **Safety**: Can't accidentally use ignored variable

```java
// Bad - confusing variable name
Object result = getValue();
System.out.println("Done");

// Good - explicit intent
Object _ = getValue();
System.out.println("Done");
```

### Scope Rules
```java
// Each _ is independent
int _ = 5;
int _ = 10;  // OK - different _ variables

// But cannot reference _
int _ = 5;
System.out.println(_);  // ERROR - cannot reference unnamed variable
```

## Use Cases

### Streams with map()
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Before
names.stream()
    .map(name -> name)  // Unused variable
    .forEach(System.out::println);

// Java 22
names.stream()
    .map(_ -> "User")  // Explicit: we don't care about name
    .forEach(System.out::println);
```

### Exception Handling
```java
// Before - unused exception
try {
    Thread.sleep(1000);
} catch (InterruptedException ignored) {
    // We're ignoring this exception
}

// Java 22 - Clear
try {
    Thread.sleep(1000);
} catch (InterruptedException _) {
    // Explicit intent to ignore
}
```

### Map Iteration
```java
Map<String, Integer> scores = new HashMap<>();

// Before - unused key
scores.forEach((key, value) -> {
    System.out.println(value);
});

// Java 22 - Explicit
scores.forEach((_, value) -> {
    System.out.println(value);
});
```

## Comparison: When to Use Named vs Unnamed

| Scenario | Use | Reason |
|----------|-----|--------|
| Iterator needed | String str | Will use the value |
| Iterator ignored | String _ | Not used in loop |
| Exception needed | catch (IOException e) | Will handle specifically |
| Exception ignored | catch (IOException _) | Just need to catch |
| Component used | Point(int x, int _) | Need x, not y |
| All components ignored | Point(int _, int _) | Only checking type |

## Important Differences from Pre-Java 22

```java
// Pre-Java 22 - underscore was usable as variable
int _ = 5;
int x = _ + 10;  // Worked in older Java

// Java 21+ - underscore is reserved keyword
int _ = 5;  // ERROR in Java 21+
int x = _ + 10;  // Cannot reference

// Java 22+ - only contexts that make sense
for (int _ = 0; _ < 10; _++) {}  // Patterns OK
catch (Exception _) {}            // Patterns OK
Point(int _, int _)               // Record patterns OK
```

## Related Topics

- For pattern matching: See [Java21/](../Java21/)
- For records: See [Java16/](../Java16/)
- For try-catch: Java exception handling basics

## Prerequisites

- Understanding of pattern matching (Java 21+)
- Familiar with lambdas and streams
- Java 22+ compiler required

## Tips for Learning

1. **Use for intentionally unused variables**: Clear intent
2. **Apply in loops**: Common use case
3. **Use in catch blocks**: When exception is ignored
4. **Pattern destructuring**: Don't need all components
5. **Improve readability**: Self-documenting code

## Common Mistakes to Avoid

1. Using `_` then trying to reference it (compilation error)
2. Using `_` for important variables (confusing intent)
3. Multiple `_` in same scope causing confusion
4. Not understanding `_` cannot be referenced
5. Using `_` when named variable would be clearer

## Best Practices

1. **Use `_` only when truly unused**: Don't obscure meaning
2. **Use in loops**: When iteration variable not needed
3. **Use in patterns**: When destructuring with unused components
4. **Use in catch**: When handling exception type, not message
5. **Keep code readable**: Named variable sometimes better

## Code Clarity Examples

### Good Use of Unnamed
```java
// Clear intent - we only want side effects
files.forEach(_ -> processFile());

// Clear we don't need coordinates
records.forEach(Point(int _, int _) -> System.out.println("Found point"));

// Clear exception type is handled, message ignored
try {
    dangerous();
} catch (IOException _) {
    System.out.println("Operation failed silently");
}
```

### Poor Use of Unnamed
```java
// Confusing - why are we computing this?
int _ = complexCalculation();
System.out.println("Done");

// Should just be:
complexCalculation();  // Clearer intent
System.out.println("Done");
```

## Advanced Topics

- **Unnamed Pattern in All Contexts**: Broader pattern matching
- **Variable Elision**: Further evolution of unnamed variables
- **Compiler Optimization**: Benefits from unnamed patterns
- **Future Improvements**: Continued pattern matching enhancements
