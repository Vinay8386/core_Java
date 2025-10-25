package Java15;

/**
 * ============================================================
 * 📘 TEXT BLOCKS IN JAVA (Introduced in Java 13, Standardized in Java 15)
 * ============================================================
 *
 * 🎯 Purpose:
 * Simplify working with multiline Strings by reducing the need for escape characters,
 * concatenation operators (+), and newline symbols (\n).
 *
 * Text Blocks make code more readable, especially for large text content such as HTML,
 * JSON, XML, SQL queries, or any structured data.
 *
 * ------------------------------------------------------------
 * 🧠 KEY POINTS:
 * ------------------------------------------------------------
 * 1️⃣ A Text Block starts and ends with three double quotes (""").
 * 2️⃣ Must begin with a newline immediately after the opening """.
 * 3️⃣ Automatically handles newlines and indentation.
 * 4️⃣ Can use .stripIndent(), .indent(), and .translateEscapes() for formatting.
 * 5️⃣ The closing """ defines the indentation baseline.
 *
 * ------------------------------------------------------------
 * 🧩 Example (Before Text Blocks):
 * ------------------------------------------------------------
 * String poem = "'The time has come,' the Walrus said,\n" +
 *                "'To talk of many things:\n" +
 *                "Of shoes -- and ships -- and sealing-wax --\n" +
 *                "Of cabbages -- and kings --\n" +
 *                "And why the sea is boiling hot --\n" +
 *                "And whether pigs have wings.'";
 *
 * ------------------------------------------------------------
 * ✅ With Text Blocks (After Java 13+):
 * ------------------------------------------------------------
 * String poem = """
 *     'The time has come,' the Walrus said,
 *     'To talk of many things:
 *     Of shoes -- and ships -- and sealing-wax --
 *     Of cabbages -- and kings --
 *     And why the sea is boiling hot --
 *     And whether pigs have wings.'
 *     """;
 *
 * ------------------------------------------------------------
 * ✨ Why Use Text Blocks:
 * ------------------------------------------------------------
 * • No need for '+' or '\n'
 * • Automatically formatted multiline strings
 * • Cleaner, more readable syntax
 *
 * ------------------------------------------------------------
 * 🧮 COMPILER RULES:
 * ------------------------------------------------------------
 * ❌ Cannot be on a single line
 * ❌ No text allowed after the opening triple quotes
 * ✅ Compiler automatically removes incidental indentation
 * ✅ Newline after closing """ adds '\n' unless suppressed with '\'
 */
public class TextBlocksDemo {

    public static void main(String[] args) {

        demonstrateTraditionalString();
        demonstrateTextBlockString();
        demonstrateNewlineHandling();
        demonstrateWhitespaceAndIndentation();
        demonstrateStringComparison();
        demonstrateJsonExample();
        demonstrateTrailingWhiteSpaceTechniques();
        demonstrateStringUtilityMethods();
    }

    /**
     * 🔹 Traditional way of creating multi-line Strings (Before Java 13)
     * Requires '+' concatenation and '\n' newline characters.
     */
    public static void demonstrateTraditionalString() {
        String poem = "'The time has come,' the Walrus said,\n" +
                "'To talk of many things:\n" +
                "Of shoes -- and ships -- and sealing-wax --\n" +
                "Of cabbages -- and kings --\n" +
                "And why the sea is boiling hot --\n" +
                "And whether pigs have wings.'";

        System.out.println("===== Traditional String =====");
        System.out.println(poem);
    }

    /**
     * 🔹 Using Text Block (Modern way)
     * Automatically adds newlines and maintains indentation.
     */
    public static void demonstrateTextBlockString() {
        String poem = """
                'The time has come,' the Walrus said,
                'To talk of many things:
                Of shoes -- and ships -- and sealing-wax --
                Of cabbages -- and kings --
                And why the sea is boiling hot --
                And whether pigs have wings.'
                """;

        System.out.println("\n===== Text Block String =====");
        System.out.println(poem);
    }

    /**
     * 🔹 Demonstrates newline handling in text blocks.
     * Final newline is added if closing """ is on a new line.
     * Can be removed using '\' or by placing closing """ immediately after content.
     */
    public static void demonstrateNewlineHandling() {
        String withNewline = """
                red
                green
                blue
                """;

        String withoutNewline = """
                red
                green
                blue""";

        String suppressNewline = """
                red
                green
                blue\
                """;

        System.out.println("\n===== Newline Handling =====");
        System.out.println("With newline length: " + withNewline.length());
        System.out.println("Without newline length: " + withoutNewline.length());
        System.out.println("Suppress newline length: " + suppressNewline.length());
    }

    /**
     * 🔹 Demonstrates how Java handles indentation in text blocks.
     * Java automatically removes incidental leading spaces that match the least indented line.
     */
    public static void demonstrateWhitespaceAndIndentation() {
        String html = """
                <html>
                    <body>
                        <p>Hello World.</p>
                    </body>
                </html>
                """;

        System.out.println("\n===== Whitespace & Indentation =====");
        System.out.println(html);
    }

    /**
     * 🔹 Demonstrates equality comparison between traditional Strings and text blocks.
     */
    public static void demonstrateStringComparison() {
        String str1 = "Vinay Kumar";
        String str2 = """
                Vinay
                Kumar
                """;

        System.out.println("\n===== String Comparison =====");
        System.out.println("Equals without normalization: " + str1.equals(str2)); // false

        // Normalize using replace() and strip()
        String normalized = str2.replace("\n", " ").strip();
        System.out.println("Equals after normalization: " + str1.equals(normalized)); // true
    }

    /**
     * 🔹 Demonstrates JSON string creation before and after Text Blocks.
     */
    public static void demonstrateJsonExample() {
        String jsonTraditional = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": 30\n" +
                "}";

        String jsonTextBlock = """
                {
                    "name": "John",
                    "age": 30
                }
                """;

        System.out.println("\n===== JSON Example =====");
        System.out.println("Are equal? " + jsonTraditional.replace("\n", "").replace(" ", "").strip()
                .equals(jsonTextBlock.replace("\n", "").replace(" ", "").strip()));
    }

    /**
     * 🔹 Demonstrates methods to preserve or manipulate trailing white spaces in Text Blocks.
     */
    public static void demonstrateTrailingWhiteSpaceTechniques() {
        String usingDollar = """
                trailing$$$
                white space
                """.replace('$', ' ');

        String usingFence = """
                trailing   |
                white space|
                """.replace("|\n", "\n");

        String usingEscape = """
                trailing\\040\\040\\040
                white space
                """.translateEscapes();

        String usingS = """
                trailing\\s\\s\\s
                white space
                """.translateEscapes();

        System.out.println("\n===== Trailing White Space Techniques =====");
        System.out.println(usingDollar);
        System.out.println(usingFence);
        System.out.println(usingEscape);
        System.out.println(usingS);
    }

    /**
     * 🔹 Demonstrates Java String utility methods related to Text Blocks:
     * - formatted(Object... args)
     * - stripIndent()
     * - translateEscapes()
     */
    public static void demonstrateStringUtilityMethods() {
        String formatted = """
                Name: %s
                Age: %d
                """.formatted("John", 30);

        String indented = """
                red
                green
                blue
                """.indent(4);

        String withEscapes = """
                Line 1\\nLine 2\\tTabbed
                """.translateEscapes();

        System.out.println("\n===== String Utility Methods =====");
        System.out.println("Formatted:\n" + formatted);
        System.out.println("Indented:\n" + indented);
        System.out.println("Translated Escapes:\n" + withEscapes);
    }
}

