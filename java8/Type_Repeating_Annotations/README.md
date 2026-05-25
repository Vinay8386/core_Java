# java8/Type_Repeating_Annotations - Enhanced Annotation Capabilities

## Overview

Java 8 introduced two major annotation enhancements: Repeating Annotations (apply same annotation multiple times) and Type Annotations (annotate any type usage, not just declarations).

## What You'll Learn

- Repeating annotations syntax
- Type annotations on any type
- Annotation containers
- Meta-annotations for repeating
- Processing repeated annotations
- Type safety with annotations
- Reflection over annotations

## Key Concepts Covered

1. **Repeating Annotations**: Apply annotation multiple times
2. **Type Annotations**: Annotate types, parameters, casts
3. **Annotation Container**: Holder for repeated annotations
4. **Meta-annotations**: @Repeatable, @Target
5. **Runtime Processing**: Reading repeated annotations
6. **Type Safety**: Annotations at compile time

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `RepeatAnnotation.java` | Repeating annotation basics | Single and multiple annotations |
| `TypeAnnotationExample.java` | Type annotations on various types | Type usage annotations |
| `TestTypeAnnotation.java` | Testing type annotations | Processing type annotations |

## How to Run

### Repeating Annotations
```bash
javac RepeatAnnotation.java
java RepeatAnnotation
```

### Type Annotations
```bash
javac TypeAnnotationExample.java
java TypeAnnotationExample
```

### Test Type Annotations
```bash
javac TestTypeAnnotation.java
java TestTypeAnnotation
```

## Repeating Annotations

### Before Java 8 (Workaround)
```java
@interface Schedules {
    Schedule[] value();
}

@Schedules({
    @Schedule(dayOfWeek="Monday", time="09:00"),
    @Schedule(dayOfWeek="Friday", time="17:00")
})
public void workSchedule() {}
```

### Java 8 (Clean Syntax)
```java
// Define repeatable annotation
@Repeatable(Schedules.class)
@interface Schedule {
    String dayOfWeek();
    String time();
}

// Container annotation
@interface Schedules {
    Schedule[] value();
}

// Usage - apply multiple times
@Schedule(dayOfWeek="Monday", time="09:00")
@Schedule(dayOfWeek="Friday", time="17:00")
public void workSchedule() {}
```

## Type Annotations

### Where Type Annotations Apply

```java
// On return type
@NotNull String getName() { }

// On parameter type
void process(@NotNull String data) { }

// On generic type parameter
List<@NotNull String> names;

// On cast
String str = (@NotNull Object) obj;

// On array type
@NotNull String[] array;

// On type variable bound
<T extends @NotNull Object> void process(T t);

// On exception type
try {
    // ...
} catch (@SuppressWarnings Exception e) {
    // ...
}

// On class literal
Class<?> cls = @Deprecated String.class;
```

## Defining Repeating Annotations

### Step 1: Create Annotation
```java
@Repeatable(Permissions.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Permission {
    String name();
    String role();
}
```

### Step 2: Create Container
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Permissions {
    Permission[] value();
}
```

### Step 3: Use
```java
@Permission(name="read", role="USER")
@Permission(name="write", role="ADMIN")
@Permission(name="delete", role="ADMIN")
public class Document {}
```

## Processing Repeating Annotations

### Runtime Reflection
```java
@Permission(name="read", role="USER")
@Permission(name="write", role="ADMIN")
public class Document {}

// Process annotations
Class<?> cls = Document.class;

// Get all repeated annotations
Permission[] perms = cls.getAnnotationsByType(Permission.class);
for (Permission perm : perms) {
    System.out.println(perm.name() + " -> " + perm.role());
}

// Get container annotation
Permissions container = cls.getAnnotation(Permissions.class);
if (container != null) {
    for (Permission perm : container.value()) {
        System.out.println(perm.name());
    }
}
```

## Type Annotations Example

### Null Safety Checking
```java
// Annotation for non-null values
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {}

// Usage
public class User {
    private @NotNull String name;  // name cannot be null
    
    public void setName(@NotNull String name) {
        this.name = name;  // guaranteed not null
    }
}
```

### Collections with Type Safety
```java
// Annotation for unmodifiable collections
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnly {}

// Usage
List<@ReadOnly String> immutableNames;  // Elements are read-only
Map<String, @NotNull Integer> validCounts;  // Values cannot be null
```

## Important Concepts

### Retention Policy
```java
@Retention(RetentionPolicy.SOURCE)      // Compile-time only
@Retention(RetentionPolicy.CLASS)       // In .class file
@Retention(RetentionPolicy.RUNTIME)     // Available at runtime
```

### Target with Type Annotations
```java
@Target({
    ElementType.TYPE_USE,      // On any type
    ElementType.PARAMETER,     // On parameters
    ElementType.LOCAL_VARIABLE // On local variables
})
```

## Benefits

| Feature | Benefit |
|---------|---------|
| **Repeating** | Multiple same annotations, cleaner syntax |
| **Type Annotations** | Better static analysis tools |
| **Null Safety** | Tool checking for null safety |
| **Compile-time Safety** | Catch errors before runtime |

## Related Topics

- For advanced annotations: See [java8/](../)
- For reflection examples: See [Basic_concept/](../../Basic_concept/)

## Prerequisites

- Understanding of annotations
- Familiar with reflection
- Java 8+ required

## Tips for Learning

1. **Understand motivation**: Why repeating and type annotations
2. **Learn container syntax**: How containers work
3. **Practice reflection**: Reading annotations at runtime
4. **Use type annotations**: With IDE/tool support
5. **Combine with static analysis**: Maximum benefit

## Common Mistakes to Avoid

1. Forgetting @Repeatable meta-annotation
2. Container annotation missing @Retention/@Target
3. Not setting @Target(TYPE_USE) for type annotations
4. Confusing repeated vs contained annotations
5. Assuming type annotations enforce (they're hints for tools)

## Best Practices

1. **Use repeating annotations**: When multiple instances needed
2. **Enable runtime retention**: If runtime processing needed
3. **Document purpose**: What annotation validates
4. **Use with IDE support**: Better with annotation processors
5. **Combine with static analysis**: Checkstyle, SpotBugs

## Tool Integration

### Annotation Processors
```java
@SupportedAnnotationTypes("example.Permission")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class PermissionProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                          RoundEnvironment roundEnv) {
        for (Element elem : roundEnv.getElementsAnnotatedWith(Permission.class)) {
            // Process annotations
        }
        return true;
    }
}
```

## Advanced Topics

- **Pluggable Annotation Processing**: Custom annotation processors
- **Type Safety with Annotations**: Creating type-safe frameworks
- **Checker Framework**: Advanced type checking
- **Annotation Inheritance**: Meta-annotations hierarchy
