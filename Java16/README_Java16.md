# Java 16 Directory Overview

This folder demonstrates Java 16 record classes with side-by-side comparisons and richer examples.

- [`Rectangle.java`](Java16/Rectangle.java)
  - Traditional immutable class with manual fields, constructor, accessors, `equals`, `hashCode`, `toString`.

- [`RectangleUsingRecord.java`](Java16/RectangleUsingRecord.java)
  - Minimal record version showing auto-generated constructor, accessors, and value-based methods.

- [`RecordClass.Java`](Java16/RecordClass.Java)
  - Feature-rich record examples:
    - `Person` record with compact and custom constructors, validation, `Comparable`, static factory, nested `Address` record, and overridden `toString`.
    - Generic `Pair<T, U>` record with static factory `of`.
    - Annotated `LegacyData` record (e.g., `@Deprecated`).
    - `Item` record implementing an interface with a custom `display` method.

- [`RecordClassNotes`](Java16/RecordClassNotes)
  - Detailed notes on records: syntax, auto-generated members, compact/custom/alternative constructors, constraints, examples, APIs, and guidance on when to use or avoid records.

## Quick Primer on Records
- Purpose: concise, transparent holders for shallowly immutable data.
- Syntax example: `record RectangleUsingRecord(double length, double width) { }`
- Auto-generated: private final fields, canonical constructor, accessors named after components, `equals`, `hashCode`, `toString`.
- Immutability: components are final; no extra instance fields allowed beyond the header.
- Constructors: use compact/custom constructors for validation; alternative constructors must delegate with `this(...)`.
- Behavior: you may add methods, static members, and nested types, but not additional instance state.
- Inheritance: records implicitly extend `java.lang.Record`; they can implement interfaces but cannot extend other classes or be extended.
