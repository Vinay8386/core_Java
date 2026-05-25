# Java10_11 - Local Variable Type Inference and String Enhancements

## Overview

Java 10 introduced local variable type inference with the `var` keyword, allowing developers to omit type declarations. Java 11 further enhanced this capability with var in lambda parameters. This folder demonstrates these features and other enhancements.

## What You'll Learn

- Local variable type inference using `var` keyword
- Using var in lambda parameters
- Enhanced for-each loops with var
- String manipulation methods (repeat)
- Try-with-resources improvements
- When to use var and when to specify types explicitly

## Key Concepts Covered

1. **Local Variable Type Inference**: The `var` keyword
2. **Type Safety**: Compiler still provides full type checking
3. **Readability**: When var improves vs harms readability
4. **Lambda Parameters**: Using var in functional interfaces
5. **String Methods**: New String utility methods

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `TypeInferenceExample.java` | Introduction to var keyword | Basic type inference |
| `LambdaVarExample.java` | Using var in lambda parameters | Functional programming with var |
| `ForEachWithVarExample.java` | Enhanced for-each loops | Iteration with var |
| `StringRepeatExample.java` | New String.repeat() method | String manipulation |
| `TryWithResourcesExample.java` | Try-with-resources enhancements | Resource management |

## How to Run

### Type Inference
```bash
javac TypeInferenceExample.java
java TypeInferenceExample
```

### Lambda with Var
```bash
javac LambdaVarExample.java
java LambdaVarExample
```

### For-Each with Var
```bash
javac ForEachWithVarExample.java
java ForEachWithVarExample
```

### String.repeat()
```bash
javac StringRepeatExample.java
java StringRepeatExample
```

## Quick Start

1. Start with `TypeInferenceExample.java` to understand var basics
2. Study `LambdaVarExample.java` for var in lambdas
3. Review `ForEachWithVarExample.java` for iteration patterns
4. Explore `StringRepeatExample.java` for string methods

## The var Keyword

### Type Inference Syntax
```java
// Before Java 10
ArrayList<String> list = new ArrayList<String>();
String message = "Hello";
int count = 10;

// Java 10+ with var
var list = new ArrayList<String>();
var message = "Hello";
var count = 10;  // Inferred as int
```

### Type Inference Restrictions
```java
var x;                          // ERROR: No initializer
var y = null;                   // ERROR: Cannot infer from null
var z = { 1, 2, 3 };          // ERROR: Array initializer
```

## Var in Lambda Parameters (Java 11)

```java
// Before Java 11
list.forEach((var item) -> System.out.println(item));  // ERROR

// Java 11+
list.forEach((var item) -> System.out.println(item));  // OK

// Can add annotations
list.forEach((@NotNull var item) -> System.out.println(item));
```

## String.repeat() Method

```java
String str = "abc";
System.out.println(str.repeat(3));  // "abcabcabc"
System.out.println(str.repeat(0));  // ""

// Practical use
String border = "*".repeat(50);
String indent = "  ".repeat(4);
```

## Important Concepts

### When to Use var

✅ **Good Uses:**
```java
var iterator = list.iterator();           // Type is clear
var button = new JButton("Click");        // Type is explicit in constructor
var reader = Files.newBufferedReader(path); // Return type is clear
```

❌ **Poor Uses:**
```java
var x = 10;                    // What type? Use int
var data = getData();          // Unclear without method knowledge
var result = complexCalculation(); // Hard to understand intent
```

### Type Safety
- Compiler fully type-checks var declarations
- No loss of type safety
- Just syntactic convenience

### Compatibility
- var is not a keyword in Java 9 and earlier
- Code using var only compiles in Java 10+
- var is a reserved type name (not a keyword)

## For-Each Loop Enhancements

```java
// Traditional
for (String item : list) {
    System.out.println(item);
}

// With var
for (var item : list) {
    System.out.println(item);
}

// Useful for complex types
for (var entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

## String Methods Summary

| Method | Purpose | Example |
|--------|---------|---------|
| `repeat(int count)` | Repeat string | `"x".repeat(5)` → "xxxxx" |
| `strip()` | Remove leading/trailing whitespace | `"  hi  ".strip()` → "hi" |
| `stripLeading()` | Remove leading whitespace | `"  hi".stripLeading()` → "hi" |
| `stripTrailing()` | Remove trailing whitespace | `"hi  ".stripTrailing()` → "hi" |
| `isBlank()` | Check if blank | `"  ".isBlank()` → true |

## Related Topics

- For lambdas: See [java8/methodReference/](../java8/methodReference/)
- For string operations: See [StringEx/](../StringEx/)
- For functional programming: See [java8/](../java8/)

## Prerequisites

- Understanding of Java types
- Familiar with lambdas and streams (Java 8+)
- Basic knowledge of generics

## Tips for Learning

1. **Use var wisely**: Only when type is clear from context
2. **Enable IDE hints**: See inferred types easily
3. **Compare readability**: Sometimes explicit types are better
4. **Practice lambda var**: Understand annotation support
5. **Use string methods**: Simplify string manipulation

## Common Mistakes to Avoid

1. Using var when type is unclear
2. Declaring var without initializer
3. Not understanding var doesn't change type checking
4. Over-using var in public APIs
5. Assuming var reduces type safety

## Best Practices

1. **Use var for local variables only** (not fields, parameters, return types)
2. **Choose var when type is obvious** from the initializer
3. **Prefer explicit types** in public APIs for clarity
4. **Use var for complex generic types** (improves readability)
5. **Keep code readable** - var is about clarity, not brevity

## Readability Guidelines

| Scenario | Recommendation |
|----------|-----------------|
| `var list = new ArrayList<String>();` | ✅ Clear from constructor |
| `var obj = someMethod();` | ❌ Unclear without docs |
| `var i = 0;` | ❌ Just use int |
| `var iterator = list.iterator();` | ✅ Type is clear |
| `var button = new JButton();` | ✅ Constructor makes type obvious |
| `var x = complexExpression();` | ❌ Hard to understand intent |

## Advanced Topics

- **Local Variable Type Inference Algorithm**: How compiler infers types
- **Intersection Types**: Generic type bounds in inference
- **Compiler Inference**: Complex scenarios and limitations
- **Pattern Matching** (Java 16+): Enhanced type inference
