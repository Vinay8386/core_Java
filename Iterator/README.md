# Iterator - Iterator Patterns and Collection Modification

## Overview

This folder demonstrates iterator patterns and how collections behave when modified during iteration. Shows the difference between fail-fast and fail-safe iteration mechanisms.

## What You'll Learn

- Iterator pattern implementation
- Fail-fast vs fail-safe behavior
- ConcurrentModificationException handling
- Safe iteration practices
- Collection modification during iteration

## Key Concepts Covered

1. **Fail-Fast Iterators**: Detect modification and throw exception
2. **Fail-Safe Iterators**: Handle modification gracefully
3. **ConcurrentModificationException**: What causes it and how to handle it
4. **Iterator Interface**: Methods and behavior
5. **Thread-Safe Collections**: CopyOnWriteArrayList, ConcurrentHashMap

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `Fail_Fast_Example.java` | Demonstrates fail-fast behavior | Throws exception when modified during iteration |
| `Fail_Safe_Example.java` | Demonstrates fail-safe behavior | Safely handles modification during iteration |

## How to Run

### Fail-Fast Example
```bash
# Compile
javac Fail_Fast_Example.java

# Run - Observe ConcurrentModificationException
java Fail_Fast_Example
```

### Fail-Safe Example
```bash
# Compile
javac Fail_Safe_Example.java

# Run - Completes without exception
java Fail_Safe_Example
```

## Expected Output

**Fail-Fast:**
- Iterates through elements
- Throws ConcurrentModificationException when modification detected

**Fail-Safe:**
- Iterates safely
- Completes even with modifications
- May not reflect all modifications (snapshot behavior)

## Quick Start

1. Run fail-fast example first to see the exception
2. Run fail-safe example to see safe approach
3. Compare output and behavior
4. Experiment with different modification scenarios

## Iterator Types Comparison

| Type | Collection | Behavior | Exception |
|------|-----------|----------|-----------|
| **Fail-Fast** | ArrayList, HashMap | Detects modification | ConcurrentModificationException |
| **Fail-Safe** | CopyOnWriteArrayList | Works with snapshot | No exception |
| **Synchronized** | Collections.synchronizedList() | Thread-safe wrapper | ConcurrentModificationException |

## Safe Iteration Patterns

### Pattern 1: Use Fail-Safe Iterator
```java
List<String> list = new CopyOnWriteArrayList<>(original);
for (String item : list) {
    list.remove(item);  // Safe
}
```

### Pattern 2: Use Iterator.remove()
```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    if (someCondition()) {
        it.remove();  // Safe method
    }
}
```

### Pattern 3: Create Copy for Iteration
```java
for (String item : new ArrayList<>(original)) {
    original.remove(item);  // Safe - iterating copy
}
```

## Important Concepts

### Fail-Fast Mechanism
- Uses internal modification counter
- Checks counter before each iteration
- Throws exception if count changes

### Fail-Safe Mechanism
- Creates snapshot of collection
- Iterates over snapshot
- Original can be modified safely

### When Each Occurs

**Fail-Fast Collections:**
- ArrayList
- HashMap
- HashSet
- TreeMap
- TreeSet

**Fail-Safe Collections:**
- CopyOnWriteArrayList
- ConcurrentHashMap
- CopyOnWriteArraySet

## Related Topics

- For collection basics: See [Collection/](../Collection/)
- For custom collections: See [Sample/CustomArrayList.java](../Sample/CustomArrayList.java)
- For streams (functional iteration): See [java8/StreamApiConcept/](../java8/StreamApiConcept/)

## Prerequisites

- Understanding of collections and iterators
- Familiar with for-each loops
- Basic exception handling knowledge

## Tips for Learning

1. **Run both examples**: Compare behavior differences
2. **Modify the code**: Test different scenarios
3. **Count modifications**: Understand the detection mechanism
4. **Try different collections**: See which are fail-fast vs fail-safe
5. **Use debugger**: Step through iterator execution

## Common Mistakes to Avoid

1. Directly removing from list during for-each loop
2. Assuming all iterators are fail-fast
3. Not catching ConcurrentModificationException
4. Not understanding snapshot behavior of fail-safe iterators
5. Using synchronized for thread safety (prefer concurrent collections)

## Best Practices

1. **Use Iterator.remove()** for safe removal
2. **Use CopyOnWriteArrayList** for concurrent modification
3. **Avoid direct list.remove()** during iteration
4. **Document modification behavior** in methods
5. **Test with multi-threaded access** when needed

## Advanced Topics

- **ConcurrentHashMap**: Thread-safe hash map without full synchronization
- **Thread-Safe Collections**: java.util.concurrent package
- **Custom Iterators**: Implementing Iterator interface
- **Streams API** (Java 8+): Functional alternative to iterators
