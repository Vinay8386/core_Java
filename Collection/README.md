# Collection - Java Collections Framework Basics

## Overview

This folder demonstrates basic Java Collections Framework concepts, including ArrayList operations, size management, and collection behavior.

## What You'll Learn

- ArrayList fundamentals and operations
- Collection sizing and capacity management
- Common collection methods
- When to use different collection types
- Collection iteration and access patterns

## Key Concepts Covered

1. **ArrayList**: Dynamic array implementation
2. **Collection Size**: Size vs capacity
3. **Add/Remove Operations**: Modifying collections
4. **Iteration**: Accessing elements
5. **Memory Management**: How collections handle growth

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `ArrayListSizeCheck.java` | ArrayList size operations | Understanding size() method, capacity growth |

## How to Run

```bash
# Compile
javac ArrayListSizeCheck.java

# Run
java ArrayListSizeCheck
```

## Expected Output

The program demonstrates:
- Initial ArrayList capacity
- How size grows with additions
- Difference between logical size and internal capacity
- Practical ArrayList usage patterns

## Quick Start

1. Run the example to see ArrayList behavior
2. Modify the code to add/remove different numbers of elements
3. Observe how size and capacity change
4. Test with different data types (Integer, String, custom objects)

## ArrayList Methods Reference

| Method | Purpose | Example |
|--------|---------|---------|
| `add(E e)` | Add element | `list.add(5)` |
| `size()` | Get current size | `list.size()` |
| `get(int index)` | Access element | `list.get(0)` |
| `remove(int index)` | Remove element | `list.remove(0)` |
| `isEmpty()` | Check if empty | `list.isEmpty()` |
| `contains(Object o)` | Check membership | `list.contains(5)` |

## Important Concepts

### Size vs Capacity
- **Size**: Number of actual elements
- **Capacity**: Internal array size
- ArrayList grows automatically when capacity is exceeded

### Performance Characteristics
- **Access**: O(1) - Direct index access
- **Add at end**: O(1) amortized
- **Add at beginning**: O(n) - Requires shifting
- **Remove**: O(n) - May require shifting elements

## Related Topics

- For collection iteration: See [Iterator/](../Iterator/)
- For custom collections: See [Sample/](../Sample/CustomArrayList.java)
- For advanced streams: See [java8/StreamApiConcept/](../java8/StreamApiConcept/)

## Prerequisites

- Basic Java syntax knowledge
- Understanding of arrays
- Familiar with generics

## Tips for Learning

1. **Experiment with size()**: Add and remove elements, observe size changes
2. **Compare with arrays**: Understand advantages of ArrayList
3. **Try generics**: Use different data types
4. **Test edge cases**: Empty lists, single elements, duplicates
5. **Measure performance**: Compare add operations at different positions

## Common Mistakes to Avoid

1. Confusing size() with capacity
2. Using index out of bounds
3. Modifying collection during iteration (see Iterator folder)
4. Not initializing ArrayList with appropriate type
5. Assuming ArrayList is always more efficient than arrays

## Advanced Topics

- See [Sample/CustomArrayList.java](../Sample/CustomArrayList.java) for custom ArrayList implementation
- See [java8/StreamApiConcept/](../java8/StreamApiConcept/) for functional collection operations
