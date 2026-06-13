# MultiThreading - Fundamentals of Concurrent Programming

## Overview

This folder contains essential threading concepts, thread synchronization, and the executor framework. It demonstrates how to create threads, handle concurrent access, prevent deadlocks, and manage thread pools.

## What You'll Learn

- Thread creation methods
- Thread lifecycle and states
- Synchronization mechanisms
- Deadlock prevention and detection
- Executor framework for thread management
- Callable and Runnable interfaces
- Thread-safe operations

## Key Concepts Covered

1. **Thread Creation**: Thread class vs Runnable interface vs Lambda
2. **Thread Synchronization**: Synchronized blocks and methods
3. **Inter-thread Communication**: Shared resources and locks
4. **Deadlock Scenarios**: Causes and prevention
5. **Executor Framework**: Thread pool management
6. **Task Handling**: Runnable and Callable tasks
7. **Future Objects**: Waiting for task completion

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `CreateThreadUsingThreadClass.java` | Extend Thread class directly | Thread subclassing approach |
| `CreateThreadUsingRunnable.java` | Implement Runnable interface | Preferred approach (composition) |
| `ThreadUsingLambda.java` | Lambda expressions for threading | Modern syntax |
| `ThreadUsingAnonymousInnerClass.java` | Anonymous inner class approach | Pre-lambda approach |
| `Synchronization.java` | Synchronized methods and blocks | Preventing race conditions |
| `SharedResource.java` | Resource sharing between threads | Demonstrating synchronization need |
| `DeadlockCondition.java` | Deadlock scenarios | Understanding deadlock |
| `ExecutorFrameworkEx.java` | Basic executor usage | Thread pool management |
| `Executor_Framework_Hierarchy_Complete.md` | Full hierarchy and pool reference | Interfaces, classes, utility methods, pool types |
| `CallableTask.java` | Callable interface with return values | Task with results |
| `RunnableTask.java` | Runnable interface implementation | Task without return value |
| `Main.java` | Integration examples | Putting it together |

## How to Run

### Create Thread Using Thread Class
```bash
javac CreateThreadUsingThreadClass.java
java CreateThreadUsingThreadClass
```

### Create Thread Using Runnable
```bash
javac CreateThreadUsingRunnable.java
java CreateThreadUsingRunnable
```

### Thread Using Lambda
```bash
javac ThreadUsingLambda.java
java ThreadUsingLambda
```

### Synchronization Example
```bash
javac Synchronization.java SharedResource.java
java Synchronization
```

### Deadlock Demonstration
```bash
javac DeadlockCondition.java
java DeadlockCondition
```

### Executor Framework
```bash
javac ExecutorFrameworkEx.java
java ExecutorFrameworkEx
```

## Quick Start Learning Path

1. **Start with Creation Methods**: Review all three approaches
2. **Understand Synchronization**: Study race conditions
3. **Learn Executor Framework**: Modern approach to threading
4. **Study Deadlock**: Understand and prevent issues
5. **Practice with examples**: Run and modify code

## Thread Creation Methods

### Method 1: Extend Thread Class
```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
}

// Usage
Thread t = new MyThread();
t.start();
```

### Method 2: Implement Runnable (Preferred)
```java
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

// Usage
Thread t = new Thread(new MyRunnable());
t.start();
```

### Method 3: Lambda Expression (Modern)
```java
Thread t = new Thread(() -> {
    for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + ": " + i);
    }
});
t.start();
```

## Thread Synchronization

### Synchronized Methods
```java
public synchronized void increment() {
    count++;  // Only one thread at a time
}
```

### Synchronized Blocks
```java
public void update() {
    // Non-critical code - runs concurrently
    
    synchronized(lock) {
        // Critical section - serialized access
        sharedResource.modify();
    }
}
```

### Lock Object
```java
private final Object lock = new Object();

public void criticalOperation() {
    synchronized(lock) {
        // Only one thread in this block at a time
    }
}
```

## Important Concepts

### Thread States
```
START → READY → RUNNING → BLOCKED/WAITING → TERMINATED
```

### Race Condition Example
```java
// Without synchronization - race condition
count++;  // Read-modify-write, NOT atomic

// With synchronization
synchronized(this) {
    count++;  // Atomic from other threads' perspective
}
```

### Deadlock Prevention
```
Hold-and-Wait: Don't hold resources while waiting for others
Circular Wait: Impose ordering on lock acquisition
Timeouts: Use tryLock() with timeout
```

## Executor Framework

### Basic Usage
```java
ExecutorService executor = Executors.newFixedThreadPool(5);

executor.execute(() -> {
    System.out.println("Task running");
});

executor.shutdown();
```

### Thread Pool Types
```java
// Fixed size pool
ExecutorService fixed = Executors.newFixedThreadPool(10);

// Single thread executor
ExecutorService single = Executors.newSingleThreadExecutor();

// Cached pool (grows as needed)
ExecutorService cached = Executors.newCachedThreadPool();

// Scheduled executor
ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(5);
```

## Runnable vs Callable

| Aspect | Runnable | Callable |
|--------|----------|----------|
| **Return Value** | No (void) | Yes (Generic <V>) |
| **Exception Handling** | Unchecked only | Checked exceptions |
| **Usage** | execute() | submit() |
| **Future** | No future | Returns Future |

## Related Topics

- For deep-dive concurrency: See `DD_Multithreading_*` folders
- For stream parallelism: See [java8/StreamApiConcept/](../java8/StreamApiConcept/)
- For advanced patterns: See `DD_Multithreading_Executors_ExecutorHierarchy_Future`

## Prerequisites

- Understanding of classes and objects
- Familiar with methods and interfaces
- Basic understanding of concurrent concepts

## Tips for Learning

1. **Start with simple threads**: Single thread first, then multiple
2. **Understand synchronization**: Why it's needed
3. **Use executor framework**: Better than manual threading
4. **Avoid deadlocks**: Learn lock ordering
5. **Use modern approaches**: Lambda and executor
6. **Debug with println**: Trace thread execution

## Common Mistakes to Avoid

1. Calling run() instead of start() (no new thread)
2. Forgetting synchronization (race conditions)
3. Holding locks too long (deadlock risk)
4. Not shutting down executor (resource leak)
5. Using Thread class when Runnable sufficient
6. Assuming execution order (threads are unpredictable)

## Best Practices

1. **Use Runnable over Thread**: Allows extension of other classes
2. **Use Executor framework**: Better than manual thread management
3. **Use volatile** for simple flags: If no complex synchronization
4. **Use ConcurrentHashMap**: Instead of synchronized HashMap
5. **Minimize critical sections**: Only synchronize what's necessary
6. **Use try-finally**: Ensure lock is released
7. **Prefer higher-level constructs**: ConcurrentCollections, Futures

## Thread-Safe Collections

```java
// Before Java 5
Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

// Java 5+ (preferred)
Map<String, Integer> map = new ConcurrentHashMap<>();
List<String> list = new CopyOnWriteArrayList<>();
```

## Advanced Topics

- **Volatile Keyword**: Visibility guarantees
- **Happen-Before Relationships**: Memory visibility
- **CompletableFuture**: Async computation chains (Java 8+)
- **Atomic Classes**: AtomicInteger, AtomicReference
- **Lock Interface**: java.util.concurrent.locks
- **Condition Variables**: Wait/notify alternatives
- **Parallel Streams**: Functional parallel processing
- **Virtual Threads** (Java 19+): Lightweight threads

## Performance Considerations

- **Context Switching**: Too many threads cause overhead
- **Lock Contention**: Too much synchronization causes bottlenecks
- **Thread Pool Sizing**: Balance between concurrency and overhead
- **Throughput vs Latency**: Different optimization strategies
