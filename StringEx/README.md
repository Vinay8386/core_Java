# StringEx - String Operations and Manipulation

## Overview

This folder demonstrates String operations and the differences between String and StringBuffer classes in Java, highlighting immutability and performance considerations.

## What You'll Learn

- String immutability and implications
- StringBuffer for mutable string operations
- String concatenation performance
- Memory efficiency in string operations
- When to use String vs StringBuffer

## Key Concepts Covered

1. **String Immutability**: Strings cannot be changed
2. **StringBuffer**: Mutable alternative to String
3. **String Concatenation**: Performance implications
4. **String Pool**: Memory optimization for immutable strings
5. **Mutability Impact**: Effects on performance and thread safety

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `StringAndStringBuffer.java` | Comparison of String and StringBuffer | Immutability vs mutability, performance differences |

## How to Run

```bash
# Compile
javac StringAndStringBuffer.java

# Run
java StringAndStringBuffer
```

## Expected Output

The program demonstrates:
- String immutability behavior
- StringBuffer mutable operations
- Performance differences in concatenation
- Memory usage patterns
- Thread safety considerations

## Quick Start

1. Run the example to see String vs StringBuffer behavior
2. Modify the code to test different scenarios
3. Try different concatenation approaches
4. Observe memory and performance implications
5. Compare results for strings and buffers

## String vs StringBuffer Comparison

| Aspect | String | StringBuffer |
|--------|--------|-------------|
| **Mutable** | No | Yes |
| **Thread-Safe** | Yes (immutable) | Yes (synchronized) |
| **Performance** | Slow for concatenation | Fast for concatenation |
| **Memory** | String pool optimization | New object each modification |
| **Use Case** | Fixed strings, keys | Building/modifying strings |

## String Immutability Implications

### Creating Strings
```java
String s = "Hello";          // String literal - in pool
String s2 = new String("Hi"); // New object
String s3 = "Hello";          // Same as s (from pool)
```

### Concatenation
```java
String result = "";
for (int i = 0; i < 1000; i++) {
    result += "text";        // Creates 1000 new String objects
}
```

## StringBuffer Usage

### Efficient Concatenation
```java
StringBuffer sb = new StringBuffer();
for (int i = 0; i < 1000; i++) {
    sb.append("text");       // Modifies same buffer
}
String result = sb.toString(); // Single object creation
```

## Important Concepts

### String Pool
- Java maintains pool of unique string literals
- Saves memory for duplicate strings
- Only for string literals, not new String()

### Performance Comparison

**String concatenation (1000 iterations):**
- String: O(n²) - Creates new object each time
- StringBuffer: O(n) - Modifies existing buffer

### Thread Safety
- **String**: Inherently thread-safe (immutable)
- **StringBuffer**: Synchronized methods (thread-safe)
- **StringBuilder**: Not synchronized (faster, not thread-safe)

## StringBuilder (Java 5+)

```java
// Preferred for single-threaded environments
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append("text");      // No synchronization overhead
}
```

## Related Topics

- For wrapper classes: See [WrapperClassEx/](../WrapperClassEx/)
- For string conversion: See [WrapperClassEx/WrapperToString.java](../WrapperClassEx/WrapperToString.java)
- For documentation: See [String.one](../String.one)

## Prerequisites

- Understanding of Java strings
- Familiar with loops and concatenation
- Basic knowledge of mutability

## Tips for Learning

1. **Test immutability**: Try to modify strings
2. **Measure performance**: Compare execution times
3. **Check memory usage**: Monitor object creation
4. **Use StringBuilder**: For non-threaded string building
5. **Understand pool behavior**: String literal vs new String()

## Common Mistakes to Avoid

1. Concatenating strings in loops (use StringBuffer/StringBuilder)
2. Assuming new String() returns pool object
3. Using StringBuffer in single-threaded contexts (StringBuilder is faster)
4. Ignoring performance implications of string operations
5. Not releasing large StringBuffers (memory leaks)

## Best Practices

1. **Use String** for immutable/fixed strings
2. **Use StringBuffer** in multithreaded code with string building
3. **Use StringBuilder** in single-threaded code with string building
4. **Avoid string concatenation in loops**
5. **Use intern()** carefully for string pool management

## Performance Tips

1. **Pre-size StringBuffer** if you know capacity
2. **Use append()** instead of concatenation
3. **StringBuilder over StringBuffer** when thread-safe not needed
4. **String.join()** for joining collections
5. **Replace StringBuilder with String** when building complete

## Advanced Topics

- **String Interning**: Manual pool management with intern()
- **Regular Expressions**: String pattern matching
- **String Formatting**: format() and printf()
- **Text Blocks** (Java 15+): Multi-line strings
