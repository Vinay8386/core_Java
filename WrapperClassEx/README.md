# WrapperClassEx - Wrapper Classes and Auto-Boxing

## Overview

This folder demonstrates Java wrapper classes for primitive types, conversion between primitives and objects, and auto-boxing/unboxing mechanisms.

## What You'll Learn

- Wrapper classes for each primitive type
- Boxing and unboxing conversions
- Auto-boxing and auto-unboxing
- Wrapper class utilities and constants
- When to use wrapper classes
- Memory and performance implications

## Key Concepts Covered

1. **Wrapper Classes**: Object representations of primitives
2. **Boxing**: Converting primitive to wrapper object
3. **Unboxing**: Converting wrapper object to primitive
4. **Auto-Boxing**: Automatic conversion (Java 5+)
5. **Wrapper Utilities**: Parsing, conversion, constants

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `WrapperToString.java` | Converting between wrapper classes and strings | Type conversion, parsing, toString() |

## How to Run

```bash
# Compile
javac WrapperToString.java

# Run
java WrapperToString
```

## Expected Output

The program demonstrates:
- Converting wrapper objects to strings
- Converting strings to wrapper objects
- Parsing different number formats
- Null handling in conversions
- Different number bases (binary, octal, hex)

## Quick Start

1. Run the example to see wrapper class conversions
2. Modify the code to test different types
3. Try parsing different formats
4. Experiment with null values
5. Test error handling for invalid inputs

## Wrapper Classes Reference

### Primitive to Wrapper Mapping

| Primitive | Wrapper | Range |
|-----------|---------|-------|
| `byte` | `Byte` | -128 to 127 |
| `short` | `Short` | -32,768 to 32,767 |
| `int` | `Integer` | -2³¹ to 2³¹-1 |
| `long` | `Long` | -2⁶³ to 2⁶³-1 |
| `float` | `Float` | IEEE 754 32-bit |
| `double` | `Double` | IEEE 754 64-bit |
| `boolean` | `Boolean` | true/false |
| `char` | `Character` | 0 to 65,535 |

## Auto-Boxing Examples

### Java 5+ Auto-Boxing
```java
// Boxing (automatic)
int x = 10;
Integer obj = x;              // Auto-boxing

// Unboxing (automatic)
Integer obj2 = 20;
int y = obj2;                 // Auto-unboxing
```

### Manual Boxing/Unboxing (Pre-Java 5)
```java
int x = 10;
Integer obj = Integer.valueOf(x);    // Manual boxing
int y = obj.intValue();              // Manual unboxing
```

## String Conversion Examples

### Wrapper to String
```java
Integer num = 42;
String s1 = num.toString();           // "42"
String s2 = Integer.toString(42);     // "42"
String s3 = String.valueOf(42);       // "42"
```

### String to Wrapper
```java
String s = "42";
Integer num1 = Integer.parseInt(s);   // 42 (primitive)
Integer num2 = Integer.valueOf(s);    // 42 (wrapper object)
```

### Different Radix
```java
String hex = "2A";
int decimal = Integer.parseInt(hex, 16);  // 42
String binary = Integer.toBinaryString(42);  // "101010"
```

## Important Concepts

### Memory Considerations
- **Primitives**: Stored on stack, fast access
- **Wrappers**: Stored on heap, slower access
- **Collections**: Can only hold objects (need wrappers)
- **Performance**: Avoid unnecessary boxing in loops

### Wrapper Caching
```java
Integer a = 100;
Integer b = 100;
System.out.println(a == b);  // true (cached -128 to 127)

Integer c = 1000;
Integer d = 1000;
System.out.println(c == d);  // false (not cached)
```

### Null Handling
```java
Integer num = null;
int value = num;             // NullPointerException at unboxing
```

## Useful Wrapper Methods

| Method | Purpose | Example |
|--------|---------|---------|
| `valueOf()` | Create wrapper | `Integer.valueOf("42")` |
| `parseInt()` | Parse to primitive | `Integer.parseInt("42")` |
| `toString()` | Convert to string | `Integer.toString(42)` |
| `toHexString()` | Convert to hex | `Integer.toHexString(255)` |
| `toBinaryString()` | Convert to binary | `Integer.toBinaryString(7)` |
| `valueOf(String, radix)` | Parse with base | `Integer.parseInt("FF", 16)` |
| `compareTo()` | Compare values | `a.compareTo(b)` |
| `equals()` | Check equality | `a.equals(b)` |

## Related Topics

- For string operations: See [StringEx/](../StringEx/)
- For collections (require wrappers): See [Collection/](../Collection/)
- For Java 8 streams (use wrappers): See [java8/StreamApiConcept/](../java8/StreamApiConcept/)
- For documentation: See [Wrapper class.one](../Wrapper%20class.one)

## Prerequisites

- Understanding of primitive types
- Familiar with objects and classes
- Basic type conversion knowledge

## Tips for Learning

1. **Understand caching**: Test boxing cache limits
2. **Measure performance**: Avoid boxing in performance-critical code
3. **Handle null carefully**: Check for null before unboxing
4. **Use appropriate methods**: valueOf vs parseInt
5. **Test different radix**: Parse hex, octal, binary

## Common Mistakes to Avoid

1. Using `==` to compare wrapper objects (use `equals()`)
2. Unboxing null values (causes NullPointerException)
3. Unnecessary boxing in loops (performance impact)
4. Forgetting wrapper objects are immutable
5. Confusing valueOf() with parseInt()

## Best Practices

1. **Use `equals()` not `==`** for wrapper comparison
2. **Avoid boxing in tight loops** - unbox once, use primitive
3. **Check for null** before unboxing
4. **Use `Integer.valueOf()`** when you need wrapper object
5. **Use `Integer.parseInt()`** when you need primitive value
6. **Use `String.valueOf()`** for general object to string conversion

## Performance Considerations

### Avoid This
```java
// Bad: Boxing in loop
Integer sum = 0;
for (int i = 0; i < 1000000; i++) {
    sum += i;  // Auto-unbox, calculate, auto-box
}
```

### Prefer This
```java
// Good: Use primitive in loop
int sum = 0;
for (int i = 0; i < 1000000; i++) {
    sum += i;
}
```

## Advanced Topics

- **Generics with Wrappers**: Type parameters with wrapper classes
- **Collections Framework**: Collections only work with wrapper objects
- **Serialization**: Wrapper classes and object serialization
- **Concurrent Wrapper Classes**: AtomicInteger, AtomicLong, AtomicReference
