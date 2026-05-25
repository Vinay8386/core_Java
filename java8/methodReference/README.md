# java8/methodReference - Method References as Lambda Alternatives

## Overview

This folder demonstrates method references, a concise way to reference methods by their names instead of writing explicit lambda expressions. Method references improve readability and are functional alternatives to lambdas.

## What You'll Learn

- Four types of method references
- Static method references
- Instance method references (particular object)
- Instance method references (arbitrary object)
- Constructor references
- When to use method references vs lambdas
- Combining with streams

## Key Concepts Covered

1. **Static Method Reference**: ClassName::staticMethodName
2. **Particular Instance Reference**: instance::instanceMethodName
3. **Arbitrary Instance Reference**: ClassName::instanceMethodName
4. **Constructor Reference**: ClassName::new
5. **Functional Interface Matching**: Method signature compatibility

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `StaticMethodReference.java` | Reference to static methods | ClassName::method |
| `InstanceMethodReferenceOfParticularObject.java` | Instance method of specific object | object::method |
| `InstanceMethodReferenceOfArbitraryObject.java` | Instance method of arbitrary object | ClassName::method |
| `ConstructorReference.java` | Constructor invocation reference | ClassName::new |

## How to Run

### Static Method Reference
```bash
javac StaticMethodReference.java
java StaticMethodReference
```

### Particular Instance Reference
```bash
javac InstanceMethodReferenceOfParticularObject.java
java InstanceMethodReferenceOfParticularObject
```

### Arbitrary Instance Reference
```bash
javac InstanceMethodReferenceOfArbitraryObject.java
java InstanceMethodReferenceOfArbitraryObject
```

### Constructor Reference
```bash
javac ConstructorReference.java
java ConstructorReference
```

## Quick Start

1. Start with `StaticMethodReference.java` (simplest)
2. Review `InstanceMethodReferenceOfParticularObject.java`
3. Study `InstanceMethodReferenceOfArbitraryObject.java`
4. Explore `ConstructorReference.java`

## Four Types of Method References

### 1. Static Method Reference
```java
// Method
public class Math {
    public static double sqrt(double x) { return Math.sqrt(x); }
}

// Lambda
Function<Double, Double> f1 = x -> Math.sqrt(x);

// Method Reference
Function<Double, Double> f2 = Math::sqrt;

// Usage
Double result = f2.apply(16.0);  // 4.0
```

### 2. Particular Instance Reference
```java
String str = "Hello";

// Lambda
Function<String, String> f1 = s -> str.concat(s);

// Method Reference
Function<String, String> f2 = str::concat;

// Usage
String result = f2.apply(" World");  // "Hello World"
```

### 3. Arbitrary Instance Reference
```java
// Lambda
BiFunction<String, String, Integer> f1 = (s1, s2) -> s1.compareTo(s2);

// Method Reference
BiFunction<String, String, Integer> f2 = String::compareTo;

// Usage
int result = f2.apply("abc", "xyz");  // Negative (abc < xyz)
```

### 4. Constructor Reference
```java
// Lambda
Supplier<String> f1 = () -> new String();

// Method Reference
Supplier<String> f2 = String::new;

// Usage
String str = f2.get();

// With ArrayList
Supplier<List<String>> f3 = ArrayList::new;
List<String> list = f3.get();
```

## Practical Examples

### Filtering with Method References
```java
List<String> words = Arrays.asList("hello", "world", "java");

// Lambda
words.stream()
    .filter(s -> s.length() > 4)
    .forEach(s -> System.out.println(s));

// Method Reference
words.stream()
    .filter(w -> w.length() > 4)
    .forEach(System::out::println);  // Method reference
```

### Mapping with Method References
```java
List<String> words = Arrays.asList("hello", "world");

// Lambda
words.stream()
    .map(s -> s.toUpperCase())
    .forEach(System.out::println);

// Method Reference
words.stream()
    .map(String::toUpperCase)  // Method reference
    .forEach(System.out::println);
```

### Sorting with Method References
```java
List<String> words = Arrays.asList("apple", "zebra", "banana");

// Lambda
words.sort((a, b) -> a.compareTo(b));

// Method Reference
words.sort(String::compareTo);

// Or using Collections
Collections.sort(words, String::compareTo);
```

## Functional Interface Compatibility

### Matching Signatures
```java
// Interface
@FunctionalInterface
interface Converter<T, U> {
    U convert(T t);
}

// Method
public static Integer parseInteger(String s) {
    return Integer.parseInt(s);
}

// Method reference matches if signatures compatible
Converter<String, Integer> conv = Integer::parseInt;
Integer num = conv.convert("42");  // 42
```

## Related Topics

- For lambdas: [java8/](../)
- For streams using method references: [StreamApiConcept/](../StreamApiConcept/)
- For advanced concepts: [Java8_code/](../../Java8_code/)

## Prerequisites

- Understanding of lambda expressions
- Familiar with functional interfaces
- Java 8+ required

## Tips for Learning

1. **Start with static methods**: Simplest to understand
2. **Progress to instance references**: More complex
3. **Learn constructor references**: For object creation
4. **Use in streams**: Most common use case
5. **Compare with lambdas**: Understand equivalence

## Common Mistakes to Avoid

1. Signature mismatch (method doesn't match functional interface)
2. Trying to use method reference for method with logic (use lambda)
3. Confusing `::` with `.` (different meanings)
4. Forgetting parentheses in constructor reference (ClassName::new)
5. Assuming method reference is always shorter (sometimes lambda clearer)

## Best Practices

1. **Use method references** when available (cleaner)
2. **Use lambdas** when needing custom logic
3. **Document intent**: Clear which method is referenced
4. **Prefer clarity**: If confusing, use explicit lambda
5. **Combine with streams**: Most idiomatic use

## When to Use

| Scenario | Use |
|----------|-----|
| Simple method delegation | Method reference |
| Need custom logic | Lambda |
| Reference existing method | Method reference |
| Complex computation | Lambda |
| Creating objects | Constructor reference |
| Single operation | Method reference |

## Equivalence Examples

```java
// All equivalent ways to convert to uppercase
List<String> words = Arrays.asList("hello", "world");

// Original
words.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

// Method reference for map
words.stream().map(String::toUpperCase).forEach(System.out::println);

// Method reference for forEach
words.stream().map(String::toUpperCase).forEach(System.out::println);
```

## Advanced Topics

- **Binding**: Early vs deferred binding in method references
- **Overloaded Methods**: Resolution with type inference
- **Custom Functional Interfaces**: Creating for method references
- **Generic Method References**: With type parameters
