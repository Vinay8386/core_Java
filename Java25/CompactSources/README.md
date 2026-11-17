# Java 25 compact source examples

This folder is a separate source root in `.vscode/settings.json`. Compact source
files cannot declare a package, so this keeps the examples under Java25 without
making VS Code expect a `Java25` package declaration.

The other Java25 examples stay in package `Java25` under the repository source root.

From the repository root, run:

```powershell
java Java25/CompactSources/ClassUsingInstanceMain.java
```

In VS Code, select `Run Java 25 compact main` in Run and Debug.
