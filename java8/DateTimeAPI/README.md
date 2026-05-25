# java8/DateTimeAPI - Modern Date and Time API

## Overview

This folder demonstrates the java.time API introduced in Java 8, providing immutable, thread-safe classes for date and time operations, replacing the legacy java.util.Date and Calendar classes.

## What You'll Learn

- LocalDate for date-only operations
- LocalTime for time-only operations  
- LocalDateTime for combined date and time
- Instant for machine time (UTC)
- ZonedDateTime for timezone-aware operations
- Temporal adjusters for date manipulation
- Chronologies for different calendar systems
- Conversion between different types

## Key Concepts Covered

1. **LocalDate**: Date without time
2. **LocalTime**: Time without date
3. **LocalDateTime**: Combined date and time
4. **Instant**: Machine time (UTC)
5. **ZonedDateTime**: Timezone-aware datetime
6. **Temporal Adjusters**: Convenient date calculations
7. **ChronoUnit**: Time units for calculations
8. **Chronology**: Different calendar systems

## File Descriptions

| File | Purpose | Key Learning |
|------|---------|--------------|
| `GetCurrentDateTime.java` | Getting current date, time, instant | Basic API usage |
| `DateToInstant.java` | Converting legacy Date to Instant | Migration from old API |
| `DateToLDAndLDT.java` | Convert to LocalDate/LocalDateTime | Practical conversions |
| `InstantToLocalDateTime.java` | Instant to local time conversions | UTC to local time |
| `ChronoDate.java` | Different calendar systems | Chronology usage |
| `TemporalAdjustor.java` | Adjust dates (next Monday, end of month) | Date manipulation |
| `ZoneMethod.java` | Timezone operations | Global time handling |
| `TestDate.java` | Comprehensive test suite | All date/time operations |

## How to Run

### Get Current DateTime
```bash
javac GetCurrentDateTime.java
java GetCurrentDateTime
```

### Date Conversions
```bash
javac DateToInstant.java
java DateToInstant
```

### Temporal Adjusters
```bash
javac TemporalAdjustor.java
java TemporalAdjustor
```

### Timezone Operations
```bash
javac ZoneMethod.java
java ZoneMethod
```

## Quick Start

1. Run `GetCurrentDateTime.java` to see basic usage
2. Study `DateToLDAndLDT.java` for conversions
3. Explore `TemporalAdjustor.java` for date calculations
4. Review `ZoneMethod.java` for timezone handling
5. Run `TestDate.java` for comprehensive examples

## LocalDate, LocalTime, LocalDateTime

### Creating Instances
```java
// Current date, time, datetime
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime currentDateTime = LocalDateTime.now();

// Specific values
LocalDate date = LocalDate.of(2025, 5, 25);
LocalTime time = LocalTime.of(14, 30, 0);
LocalDateTime dateTime = LocalDateTime.of(2025, 5, 25, 14, 30);

// Parsing strings
LocalDate parsed = LocalDate.parse("2025-05-25");
LocalTime parsedTime = LocalTime.parse("14:30:00");
```

### Manipulation
```java
LocalDate date = LocalDate.now();

date.plusDays(1);       // Tomorrow
date.plusMonths(1);     // Next month
date.plusYears(1);      // Next year
date.minusWeeks(1);     // Last week

date.withMonth(12);     // Change month
date.withDayOfMonth(1); // First of month
```

## Instant for Machine Time

```java
// Current instant (UTC)
Instant now = Instant.now();

// From timestamp
Instant fromTimestamp = Instant.ofEpochMilli(1234567890000L);

// Between instants
Duration duration = Duration.between(instant1, instant2);
```

## ZonedDateTime for Timezones

```java
// Current time in specific timezone
ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

// Converting between zones
ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
ZonedDateTime converted = utcTime.withZoneSameInstant(ZoneId.of("Europe/London"));
```

## Temporal Adjusters

```java
LocalDate date = LocalDate.now();

// Next Monday
date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

// Last day of month
date.with(TemporalAdjusters.lastDayOfMonth());

// Next business day
date.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));

// Nth day of month
date.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
```

## Period and Duration

```java
// Period (days, months, years)
LocalDate date1 = LocalDate.of(2025, 1, 1);
LocalDate date2 = LocalDate.of(2025, 12, 31);
Period p = Period.between(date1, date2);
p.getDays();    // Days component
p.getMonths();  // Months component
p.getYears();   // Years component

// Duration (seconds, nanos)
LocalTime time1 = LocalTime.of(10, 0);
LocalTime time2 = LocalTime.of(15, 30);
Duration d = Duration.between(time1, time2);
d.getSeconds(); // Total seconds
d.getNano();    // Nanosecond component
```

## Important Concepts

### Immutability
- All java.time objects are immutable
- Methods return new objects, don't modify originals
- Thread-safe by design

### ISO-8601 Standard
- Default format is ISO-8601
- Easy to parse and format
- International standard

### Timezone Handling
- Always be aware of timezone
- Use ZonedDateTime for application-level timezone work
- Store as Instant for system-wide consistent representation

## Related Topics

- For stream operations on dates: [java8/StreamApiConcept/](../StreamApiConcept/)
- For Java 8 overview: [java8/](../)
- For practical examples: See `TestDate.java`

## Prerequisites

- Understanding of Java syntax
- Familiar with LocalDate concept
- Java 8+ required

## Tips for Learning

1. **Prefer LocalDate**: For most date operations
2. **Use Instant**: For system/database storage
3. **Use ZonedDateTime**: For user-facing timezones
4. **Leverage adjusters**: For complex date calculations
5. **Be immutable-aware**: Don't expect mutations

## Common Mistakes to Avoid

1. Using legacy Date/Calendar classes
2. Assuming date arithmetic modifies original
3. Ignoring timezone in global applications
4. Confusing LocalDateTime with ZonedDateTime
5. Not parsing timestamps correctly

## Best Practices

1. **Use LocalDate** for date-only operations
2. **Use ZonedDateTime** for timezone-aware operations
3. **Store as Instant** in databases
4. **Use formatters** for user-facing dates
5. **Use temporal adjusters** for complex calculations

## Formatting Dates

```java
LocalDate date = LocalDate.now();

// Predefined formatters
date.format(DateTimeFormatter.ISO_LOCAL_DATE);
date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

// Custom formatter
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
String formatted = date.format(formatter);
```

## Advanced Topics

- **Chronology**: Non-Gregorian calendar systems
- **Custom TemporalQuery**: Build custom date logic
- **Formatting**: Locale-specific date formatting
- **Clock**: Custom time provider (testing)
