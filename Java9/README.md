# Java9 - Java 9 Enhancements and Features

## Overview

Java 9 introduced several important features and enhancements, including improvements to the diamond operator, enhanced try-with-resources, safe varargs annotations, and the underscore as a reserved keyword.

## What You'll Learn

- Diamond operator improvements for anonymous classes
- Enhanced try-with-resources statements
- Safe varargs handling with @SafeVarargs
- Underscore as reserved keyword
- Module system introduction

## Key Concepts Covered

1. **Diamond Operator**: Type inference improvements
2. **Try-with-Resources**: Enhanced resource management
3. **Safe Varargs**: Preventing heap pollution warnings
4. **Reserved Keywords**: Underscore and future compatibility
5. **Modules**: Java Platform Module System (JPMS)

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `DiamondAnonymousJava7.java` | Diamond operator in Java 7 (before improvements) | Limited diamond operator support |
| `DiamondAnonymousJava9.java` | Improved diamond operator in Java 9 | Can now use with anonymous classes |
| `UnderscoreExample.java` | Underscore as reserved keyword | Cannot use underscore as variable name |
| `SafeVarargsDemo.java` | @SafeVarargs annotation | Mark methods as safe for varargs |
| `TryWithResourcesExample.java` | Enhanced try-with-resources | More flexible resource management |
| `Car.java` | Example class for demonstrations | Supporting code |

## How to Run

### Diamond Operator Comparison
```bash
# Compile both versions
javac DiamondAnonymousJava7.java
javac DiamondAnonymousJava9.java

# Run and compare
java DiamondAnonymousJava7
java DiamondAnonymousJava9
```

### Underscore Example
```bash
# Compile
javac UnderscoreExample.java

# Run
java UnderscoreExample
```

### Safe Varargs
```bash
# Compile
javac SafeVarargsDemo.java

# Run
java SafeVarargsDemo
```

### Try-with-Resources
```bash
# Compile
javac TryWithResourcesExample.java

# Run
java TryWithResourcesExample
```

## Quick Start

1. Start with `DiamondAnonymousJava7.java` to understand the limitation
2. Review `DiamondAnonymousJava9.java` to see the improvement
3. Study `SafeVarargsDemo.java` for varargs safety
4. Examine `TryWithResourcesExample.java` for resource management
5. Check `UnderscoreExample.java` for keyword changes

## Diamond Operator Evolution

### Java 7 Diamond Operator
```java
// Works with class instantiation
List<String> list = new ArrayList<>();

// Does NOT work with anonymous class
Comparator<String> comp = new Comparator<String>() {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
};
```

### Java 9 Diamond Operator
```java
// Now works with anonymous classes too
Comparator<String> comp = new Comparator<>() {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
};
```

## @SafeVarargs Usage

```java
// Method with varargs
@SafeVarargs
public static <T> void printArray(T... array) {
    for (T item : array) {
        System.out.println(item);
    }
}

// Usage - no warnings
printArray("a", "b", "c");
List<String> list = Arrays.asList("x", "y");
printArray(list);  // Warning in Java 8, safe in Java 9+
```

## Try-with-Resources Enhancements

### Java 7-8 Try-with-Resources
```java
try (FileInputStream fis = new FileInputStream("file.txt")) {
    // use fis
} catch (IOException e) {
    // handle error
}
```

### Java 9 Try-with-Resources
```java
FileInputStream fis = new FileInputStream("file.txt");
try (fis) {  // Can reuse existing resource
    // use fis
} catch (IOException e) {
    // handle error
}
```

## Important Concepts

### Heap Pollution Warning
- Occurs when using generic varargs
- Can lose type safety with reifiable types
- @SafeVarargs suppresses warnings when safe

### Effective Final
- Variables created before try statement can be used in try-with-resources (Java 9+)
- Must not be reassigned

### Reserved Keywords
- Underscore `_` reserved for future use
- Cannot use as variable name
- Previous code using `_` must be refactored

## Feature Timeline

| Feature | Introduced | Purpose |
|---------|------------|---------|
| Diamond operator | Java 7 | Type inference |
| Try-with-resources | Java 7 | Auto resource management |
| @SafeVarargs | Java 7 | Suppress varargs warnings |
| Enhanced diamond | Java 9 | Works with anonymous classes |
| Underscore reserved | Java 9 | Future compatibility |

## Related Topics

- For modules: Java Platform Module System (JPMS) documentation
- For try-catch: See Java exception handling guides
- For generics: See advanced generics documentation

## Prerequisites

- Understanding of generics
- Familiar with try-catch-finally
- Knowledge of varargs

## Tips for Learning

1. **Compare versions**: Run both Java 7 and Java 9 diamond examples
2. **Test underscore**: Try using underscore to see compiler error
3. **Check warnings**: Watch for varargs heap pollution warnings
4. **Use @SafeVarargs**: Mark your own varargs methods when safe
5. **Try enhancements**: Use effective final in try-with-resources

## Common Mistakes to Avoid

1. Using underscore as variable name (compiler error in Java 9+)
2. Not using @SafeVarargs when safe (generates warnings)
3. Ignoring heap pollution warnings
4. Not using diamond operator with anonymous classes (Java 9+)
5. Not taking advantage of enhanced try-with-resources

## Best Practices

1. **Use diamond operator** for type inference
2. **Mark varargs methods** with @SafeVarargs when safe
3. **Use try-with-resources** for automatic resource closing
4. **Avoid underscore** as variable name for future compatibility
5. **Enable compiler warnings** to catch potential issues

## Advanced Topics

- **Module System (JPMS)**: Java Platform Module System
- **Automatic Module Names**: Module system compatibility
- **Var Keyword** (Java 10): Type inference for local variables
- **Process API**: Better subprocess handling
