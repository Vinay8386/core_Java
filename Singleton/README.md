# Singleton Design Pattern

A comprehensive guide to implementing the Singleton design pattern in Java with six different approaches, each with its own advantages and use cases.

## Table of Contents

- [Overview](#overview)
- [Pattern Characteristics](#pattern-characteristics)
- [Implementation Approaches](#implementation-approaches)
- [Comparison & Best Practices](#comparison--best-practices)
- [Common Pitfalls](#common-pitfalls)
- [Running Examples](#running-examples)

---

## Overview

The Singleton pattern is a creational design pattern that restricts the instantiation of a class to a single object. It provides a global point of access to that instance.

### When to Use Singleton

- Database connection pooling
- Logging management
- Cache management
- Thread pool management
- Configuration management
- Resource management (printers, file handles)

### Key Characteristics

- Private constructor (prevents instantiation)
- Static instance of the class
- Public static method to access the instance
- Thread-safe initialization
- Lazy or eager loading options

---

## Implementation Approaches

### 1. **Static Eager Initialization**
**File:** `StaticEagerSingleton.java`

Instance is created at class loading time.

```
Advantages:
  ✓ Simple to implement
  ✓ Thread-safe by default
  ✓ No performance overhead at runtime

Disadvantages:
  ✗ Instance created even if never used
  ✗ No way to pass constructor parameters
  ✗ Can mask initialization errors
```

**Best for:** Applications where you're sure the singleton will be used.

---

### 2. **Dynamic Lazy Initialization**
**File:** `DynamicLazySingleton.java`

Instance is created only when first requested (non-thread-safe version).

```
Advantages:
  ✓ Instance created only when needed
  ✓ Easy to understand

Disadvantages:
  ✗ NOT thread-safe
  ✗ Race condition in multi-threaded environments
  ✗ Multiple instances can be created
```

**Best for:** Single-threaded applications only.

---

### 3. **Synchronized Lazy Initialization**
**File:** `DynamicLazyImprovedSingleton.java`

Thread-safe lazy initialization using synchronized keyword.

```
Advantages:
  ✓ Thread-safe
  ✓ Instance created only when needed
  ✓ Simple synchronization

Disadvantages:
  ✗ Performance overhead - synchronized on every call
  ✗ Potential bottleneck in high-concurrency scenarios
  ✗ Can lead to contention
```

**Best for:** Low to medium concurrency applications where simplicity is valued.

---

### 4. **Double-Checked Locking (DCL)**
**File:** `DoubleCheckedLockingSingleton.java`

Optimized thread-safe lazy initialization with minimal lock contention.

```
Advantages:
  ✓ Thread-safe
  ✓ Instance created only when needed
  ✓ Lock acquired only during initialization
  ✓ Better performance than full synchronization

Disadvantages:
  ✗ Complex to understand and implement correctly
  ✗ Requires volatile keyword (memory visibility)
  ✗ Can fail in certain older JVM implementations
  ✗ Not safe in all scenarios without careful implementation
```

**Best for:** High-concurrency applications where performance is critical.

**Important:** Requires `volatile` keyword to ensure memory visibility across threads.

---

### 5. **Bill Pugh Singleton (Static Inner Class)**
**File:** `BillPughSingleton.java`

Uses a static inner helper class for lazy initialization (recommended approach).

```
Advantages:
  ✓ Thread-safe by design
  ✓ Lazy initialization without complexity
  ✓ No synchronization overhead
  ✓ Simple and elegant
  ✓ No reflection issues (like Enum)

Disadvantages:
  ✗ Slightly less intuitive pattern
  ✗ Still vulnerable to reflection (less so than others)
```

**Best for:** Most production applications - perfect balance of safety, performance, and simplicity.

**How it works:** The static inner class is not loaded until it's referenced, ensuring thread-safe lazy initialization through JVM's class loading mechanism.

---

### 6. **Enum Singleton**
**File:** `EnumSingleton.java`

Uses Java's enum to implement singleton (most robust approach).

```
Advantages:
  ✓ Thread-safe by design
  ✓ Serialization-safe (prevents multiple instances during deserialization)
  ✓ Reflection-safe (prevents instantiation via reflection)
  ✓ Simple and elegant
  ✓ Handles all edge cases automatically

Disadvantages:
  ✗ Less familiar pattern to some developers
  ✗ Cannot extend other classes (enums implicitly extend Enum)
  ✗ Eager initialization (instance created at class loading)
  ✗ May seem overkill for simple use cases
```

**Best for:** Production code where maximum safety against reflection and serialization attacks is required.

**Why it's special:**
- Enum construction is controlled by JVM
- Prevents reflection attacks
- Prevents serialization attacks
- Prevents cloning

---

### 7. **Singleton With Function**
**File:** `SingletonWithFunction.java`

Demonstrates singleton pattern combined with functional programming (Java 8+).

```
Use Case:
  - Modern Java applications using lambdas and functional interfaces
  - Combining singleton with callback patterns
  - Functional approach to accessing singleton instances
```

---

## Comparison & Best Practices

### Performance Comparison

| Approach | Thread-Safe | Lazy Init | Lock Overhead | Reflection Safe |
|----------|-------------|-----------|---------------|-----------------|
| Eager | ✓ | ✗ | None | ✗ |
| Lazy (Unsafe) | ✗ | ✓ | None | ✗ |
| Synchronized | ✓ | ✓ | High | ✗ |
| Double-Check Lock | ✓ | ✓ | Low | ✗ |
| Bill Pugh | ✓ | ✓ | None | Partial |
| Enum | ✓ | ✗ | None | ✓ |

### Selection Guide

**Choose Eager Initialization when:**
- The singleton is always used in your application
- Application startup time is not critical
- Simplicity is preferred over lazy loading

**Choose Lazy Initialization when:**
- Singleton may not always be used
- Application startup time is important
- Singleton has expensive initialization

**Choose Bill Pugh when:**
- You need lazy initialization with high performance
- You want simplicity without complexity of DCL
- You're working in a standard multi-threaded application

**Choose Enum when:**
- You need maximum security against reflection/serialization
- You're in a production critical system
- You need guaranteed singleton behavior

**Choose Double-Check Locking when:**
- You have high concurrency requirements
- You're an expert in multi-threading
- You absolutely need lazy initialization with minimal overhead
- **Caution:** Most developers should avoid this

---

## Common Pitfalls

### 1. **Reflection Attack**
```java
// Dangerous - bypasses singleton
Constructor[] constructors = MyClass.class.getDeclaredConstructors();
constructors[0].setAccessible(true);
MyClass instance = constructors[0].newInstance();
```

**Solution:** Use Enum singleton (immune to reflection)

### 2. **Serialization Attack**
```java
// Dangerous - creates new instance after deserialization
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.txt"));
out.writeObject(singleton);

ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
MyClass newInstance = (MyClass) in.readObject(); // Different instance!
```

**Solution:** 
- Use Enum singleton (immune to serialization attacks)
- Or implement `readResolve()` method:
```java
protected Object readResolve() {
    return getInstance();
}
```

### 3. **Cloning Attack**
```java
// Dangerous - creates new instance via clone
MyClass clone = (MyClass) singleton.clone();
```

**Solution:** Override `clone()` to throw exception:
```java
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Singleton cannot be cloned");
}
```

### 4. **Thread Safety Mistakes**
- Using non-volatile fields in DCL
- Forgetting synchronization in lazy initialization
- Race conditions in custom getInstance() methods

### 5. **Inappropriate Use**
- Using Singleton for stateful objects
- Using Singleton as a replacement for dependency injection
- Creating pseudo-singletons with static methods instead of proper pattern

---

## Running Examples

### Compile All Files
```bash
javac *.java
```

### Run the Main Demo
```bash
java Main
```

This will demonstrate all six implementations and show how to use each one.

### Compile Individual Examples
```bash
# Compile specific implementation
javac StaticEagerSingleton.java
javac BillPughSingleton.java
javac EnumSingleton.java

# Compile main class
javac Main.java

# Run main
java Main
```

### Testing Thread Safety
The `Main.java` file includes tests to verify thread-safety of each implementation.

---

## Detailed Implementation Reference

### StaticEagerSingleton Pattern
```java
public class StaticEagerSingleton {
    private static final StaticEagerSingleton instance = new StaticEagerSingleton();
    
    private StaticEagerSingleton() { }
    
    public static StaticEagerSingleton getInstance() {
        return instance;
    }
}
```

### Bill Pugh Pattern (Recommended)
```java
public class BillPughSingleton {
    private BillPughSingleton() { }
    
    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance() {
        return SingletonHelper.instance;
    }
}
```

### Enum Singleton Pattern (Most Secure)
```java
public enum EnumSingleton {
    INSTANCE;
    
    public void doSomething() {
        // implementation
    }
}

// Usage: EnumSingleton.INSTANCE.doSomething();
```

---

## Key Takeaways

1. **Bill Pugh Singleton** is the best choice for most applications:
   - Thread-safe with no synchronization overhead
   - Lazy initialization by default
   - Simple and elegant
   - Balances security and performance

2. **Enum Singleton** should be used when:
   - Maximum security is required
   - Protecting against reflection and serialization is critical

3. **Avoid Double-Checked Locking** unless:
   - You have extreme performance requirements
   - You're an expert in concurrent programming
   - You understand the memory visibility implications

4. **Avoid Synchronized Lazy** in high-concurrency scenarios:
   - Can become a bottleneck
   - Every call acquires a lock

5. **Use Eager Initialization** when:
   - Simplicity is preferred
   - Singleton is always used
   - Initialization cost is not prohibitive

---

## Additional Resources

- [Effective Java - Item 3](https://www.oreilly.com/library/view/effective-java-3rd/9780134685991/) - Creating and destroying objects
- [Double-Checked Locking Pitfalls](https://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html)
- [Enum Singleton Implementation](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
- [Java Memory Model](https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html#jls-17.4)

---

## Practice Exercises

1. **Implement Thread Safety Test:** Create a program that spawns 100 threads and verifies all get the same singleton instance
2. **Serialization Test:** Serialize and deserialize each singleton type - observe which ones remain singleton
3. **Reflection Test:** Attempt reflection attacks on each implementation
4. **Performance Benchmark:** Measure getInstance() call performance for each approach under concurrent access
5. **Real-world Application:** Implement a DatabaseConnection singleton following Bill Pugh pattern

---

This README covers all six implementations of the Singleton pattern with their trade-offs, security considerations, and best practices for production use.
