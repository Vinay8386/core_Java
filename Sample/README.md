# Sample - Custom Collection Implementations

## Overview

This folder contains custom implementations of Java's standard data structures, particularly a custom ArrayList implementation to understand how collections work internally.

## What You'll Learn

- Internal structure of ArrayList
- Dynamic array resizing
- Generic type parameters
- Collection interface implementation
- Performance characteristics of collections

## Key Concepts Covered

1. **Generic Classes**: Implementing with type parameters
2. **Dynamic Arrays**: Growing arrays when capacity exceeded
3. **Collection Interface**: Methods and contracts
4. **Index-based Access**: Fast O(1) access
5. **Resizing Strategy**: Doubling capacity for efficiency

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `CustomArrayList.java` | Custom ArrayList implementation | Internal structure, generic types, resizing |
| `Test.java` | Testing custom collection | Verifying functionality |

## How to Run

```bash
# Compile
javac CustomArrayList.java Test.java

# Run
java Test
```

## Expected Output

The program demonstrates:
- Creating custom list with generic types
- Adding elements and automatic resizing
- Accessing elements by index
- Removing elements
- Getting size and capacity
- Iterator behavior

## Quick Start

1. Run the test program to see CustomArrayList in action
2. Study the internal structure of CustomArrayList.java
3. Compare with built-in ArrayList from Java API
4. Experiment by modifying the custom implementation
5. Add new methods to extend functionality

## CustomArrayList Implementation Highlights

### Key Features
- Generic type parameter `<T>`
- Dynamic array backing store
- Automatic capacity growth
- Index-based element access
- Iterator support

### Internal Structure
```
CustomArrayList
├── elements[] - Backing array
├── size - Current number of elements
└── capacity - Internal array size
```

### Resizing Strategy
```
Initial capacity: 10
Growth when full: capacity *= 2
Resize overhead: O(n)
Amortized add: O(1)
```

## Performance Analysis

| Operation | Time | Space |
|-----------|------|-------|
| Access (get) | O(1) | N/A |
| Add (end) | O(1) amortized | O(1) amortized |
| Add (middle) | O(n) | N/A |
| Remove | O(n) | N/A |
| Search | O(n) | N/A |

## Related Topics

- For using ArrayList: See [Collection/](../Collection/)
- For iterator behavior: See [Iterator/](../Iterator/)
- For streams: See [java8/StreamApiConcept/](../java8/StreamApiConcept/)
- For advanced collections: See [Java8_code/](../Java8_code/)

## Prerequisites

- Understanding of arrays
- Familiar with generics
- Basic data structure knowledge

## Tips for Learning

1. **Trace through add()**: Understand element insertion
2. **Study resize()**: See how capacity grows
3. **Implement remove()**: Add your own removal logic
4. **Add get()**: Implement index-based access
5. **Create iterators**: Implement Iterator interface

## Common Mistakes to Avoid

1. Not checking capacity before adding
2. Losing data during resize
3. Off-by-one errors in indexing
4. Not handling generic type properly
5. Inefficient resizing strategy (growing by 1 is slow)

## Best Practices

1. **Use built-in ArrayList** for production code
2. **Understand implementation** for better usage
3. **Consider performance** when choosing collections
4. **Document behavior** of custom collections
5. **Write comprehensive tests** for custom implementations

## Extension Exercises

1. **Add remove() method**: Remove element at index
2. **Add contains() method**: Search for element
3. **Add clear() method**: Empty the collection
4. **Implement Iterable**: Support for-each loops
5. **Add shrinkToSize()**: Reduce capacity to size
6. **Implement Comparable**: Sort elements
7. **Add thread safety**: Synchronized operations
8. **Support null elements**: Handle null values

## Advanced Topics

- **Concurrent Collections**: Thread-safe ArrayList variants
- **Copy-on-Write Strategy**: CopyOnWriteArrayList
- **Vector vs ArrayList**: Legacy vs modern collections
- **LinkedList**: Alternative to array-based lists
