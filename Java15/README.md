# Java15 - Text Blocks

## Overview

Java 15 introduced text blocks (multi-line string literals), allowing developers to write multi-line strings without concatenation or escape sequences, improving readability for JSON, SQL, HTML, and other formats.

## What You'll Learn

- Text block syntax and usage
- Escape sequences in text blocks
- Indentation handling
- String interpolation alternatives
- When to use text blocks vs regular strings
- Common text block patterns

## Key Concepts Covered

1. **Text Block Syntax**: Triple quotes `"""` for multi-line strings
2. **Indentation**: Automatic leading whitespace removal
3. **Escape Sequences**: Still available but less needed
4. **Line Terminators**: Implicit newlines
5. **String Operations**: All String methods apply

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `TextBlocksDemo.java` | Text block syntax and examples | Multi-line string literals |

## How to Run

```bash
javac TextBlocksDemo.java
java TextBlocksDemo
```

## Quick Start

1. Run `TextBlocksDemo.java` to see text block examples
2. Modify the examples to understand indentation
3. Experiment with different content (JSON, SQL, etc.)
4. Compare readability with traditional string concatenation

## Text Block Syntax

### Basic Text Block
```java
// Before Java 15
String html = "<html>\n" +
              "  <body>\n" +
              "    <p>Hello World</p>\n" +
              "  </body>\n" +
              "</html>";

// Java 15+ Text Block
String html = """
              <html>
                <body>
                  <p>Hello World</p>
                </body>
              </html>
              """;
```

### Key Rules
```java
// Opening quotes must be followed by newline
String valid = """
               Content starts here
               """;

// Closing quotes on separate line
String content = """
                 Multi-line
                 text
                 """;

// Indentation is significant
String formatted = """
                   Line 1
                   Line 2
                   """;
```

## Common Text Block Uses

### JSON
```java
String json = """
              {
                "name": "John",
                "age": 30,
                "city": "New York"
              }
              """;
```

### SQL
```java
String sql = """
             SELECT id, name, email
             FROM users
             WHERE active = true
             ORDER BY name
             """;
```

### HTML
```java
String html = """
              <div class="container">
                <h1>Welcome</h1>
                <p>This is a text block</p>
              </div>
              """;
```

### XML
```java
String xml = """
             <?xml version="1.0"?>
             <root>
               <element>Value</element>
             </root>
             """;
```

## Indentation Handling

```java
// Indentation normalized based on closing quotes position
String text = """
              Hello
              World
              """;  // Closing quotes at column 15
             // Result: "Hello\nWorld\n"

// Extra indentation is preserved
String indented = """
                  Line 1
                    Line 2 (2 spaces extra)
                  Line 3
                  """;
```

## Escape Sequences in Text Blocks

```java
// Still work in text blocks
String escaped = """
                 Line 1\tTabbed
                 Line 2\"Quoted\"
                 Line 3\\Backslash
                 """;

// Less needed in text blocks
String less = """
              New lines are implicit
              No need for \n
              """;
```

## String Operations

```java
String text = """
              Hello
              World
              """;

// All String methods apply
text.length();           // Works as expected
text.replace("World", "Java"); // Works
text.split("\n");        // Works
text.strip();            // Removes leading/trailing whitespace
```

## Important Concepts

### Text Block Features
- Implicit newlines at each line
- No need for `\n` or concatenation
- Indentation automatically handled
- Escape sequences still available
- Returns a regular String object

### Comparison with Concatenation

```java
// Concatenation - verbose
String s1 = "Line 1\n" +
            "Line 2\n" +
            "Line 3\n";

// Text block - readable
String s2 = """
            Line 1
            Line 2
            Line 3
            """;
```

## Related Topics

- For string operations: See [StringEx/](../StringEx/)
- For switch statements: See [Java14/](../Java14/)
- For records: See [Java16/](../Java16/)

## Prerequisites

- Understanding of Java strings
- Java 15+ compiler required
- Basic string manipulation knowledge

## Tips for Learning

1. **Use for JSON/SQL/HTML**: Text blocks shine here
2. **Pay attention to indentation**: Automatic but important
3. **Compare readability**: Much better than concatenation
4. **Use strip() method**: Remove leading/trailing whitespace
5. **Remember it's a String**: All normal operations work

## Common Mistakes to Avoid

1. Forgetting newline after opening quotes
2. Not understanding indentation normalization
3. Unnecessary escape sequences
4. Placing closing quotes on same line
5. Expecting template variables (use String.format instead)

## Best Practices

1. **Use text blocks** for multi-line strings (JSON, SQL, HTML)
2. **Keep closing quotes aligned** for clear indentation
3. **Use strip()** to remove unwanted leading/trailing whitespace
4. **Document complex blocks** with comments
5. **Consider readability** over brevity

## String Formatting Alternatives

```java
// Text block with String.format()
String formatted = """
                   Name: %s
                   Age: %d
                   """.formatted("John", 30);

// Text block with replace()
String template = """
                  Hello [name], you are [age] years old
                  """;
String result = template.replace("[name]", "John")
                        .replace("[age]", "30");
```

## Advanced Topics

- **String Formatting** (Java 15+): formatted() method
- **String Interpolation**: Future feature (under discussion)
- **Template Literals**: Language feature evolution
- **Text Block Processing**: API details and edge cases
