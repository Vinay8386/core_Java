# Java8_code Folder Documentation

This folder contains Java 8 learning examples organized into four focused submodules:

- `CollectorWithJava8/` – Collector and stream aggregation examples using employee-like data
- `Interview_code/` – Java interview practice problems and coding question solutions
- `MapQuestion/` – Map-based examples and transformations
- `random_que/` – Miscellaneous Java 8 features, stream utilities, functional interfaces, and related examples

## Package Structure

All source files in this folder use the package root:

- `Java8_code`

For example:

- `Java8_code.CollectorWithJava8`
- `Java8_code.Interview_code`
- `Java8_code.MapQuestion`
- `Java8_code.random_que`

This package layout matches the physical folder structure under `Java8_code`.

## Subfolder Overview

### CollectorWithJava8/

Focuses on Java 8 collectors, grouping, partitioning, sorting, and aggregation.

Representative classes:
- `CountByGender.java`
- `DeptWiseAvgSalary.java`
- `MaxAndMinSalaryEmp.java`
- `SalaryPerDepartment.java`
- `SortBySalary.java`

### Interview_code/

Contains interview-style Java problems and solutions, including list processing, string handling, and algorithmic examples.

Representative classes:
- `FirstQ.java`
- `EleventhQ.java`
- `FibonacciNumber.java`
- `MaxOccuranceCharacter.java`
- `ThirtyTwo.java`

### MapQuestion/

Demonstrates Java Map operations such as filtering, sorting, and converting maps to lists.

Representative classes:
- `MaxValueInHashMap.java`
- `FilterEntriesBasedOnKeyLength.java`
- `MapToList.java`
- `SortByValueAndKey.java`

### random_que/

Includes miscellaneous Java 8 features, stream examples, functional interfaces, and utility patterns.

Representative classes:
- `FlatMap.java`
- `ParallelStreamExample.java`
- `MapReduceExample.java`
- `GenerateOtpUsingSupplierPFI.java`
- `ListToOptional.java`

## How to Compile

From the `core_Java` folder, compile all files under `Java8_code` with PowerShell:

```powershell
Get-ChildItem -Recurse -Filter *.java -Path Java8_code | ForEach-Object {
    javac $_.FullName
}
```

Or compile a specific package directory:

```powershell
javac Java8_code\CollectorWithJava8\*.java
```

## How to Run

Use the top-level package-qualified class name. For example:

```powershell
java Java8_code.Interview_code.EleventhQ
```

## Notes

- The folder is intended for Java 8 practice, so it uses streams, lambda expressions, collectors, and functional interfaces.
- Ensure your IDE or build tool recognizes `core_Java` as the project root so the `Java8_code` package root resolves correctly.
