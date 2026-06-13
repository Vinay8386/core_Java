# Complete Java Multithreading & Executor Hierarchy

This file gives a single, practical view of the core Java threading and executor framework used in this folder.

---

## 1. Core Thread / Task Hierarchy

```text
java.lang.Thread
    - starts a separate execution path
    - run() is the task body
    - start() creates a new thread

java.lang.Runnable
    - functional interface
    - void run()
    - used by Executor.execute(...)

java.util.concurrent.Callable<V>
    - functional interface
    - V call() throws Exception
    - returns a value and can throw checked exceptions

java.util.concurrent.Future<V>
    - handle to an asynchronous task
    - methods: cancel(), isCancelled(), isDone(), get(), get(timeout, unit)

java.util.concurrent.RunnableFuture<V>
    - extends Runnable + Future
    - implemented by FutureTask

java.util.concurrent.ScheduledFuture<V>
    - extends Future<V>
    - used for delayed / scheduled tasks
```

---

## 2. Executor Framework Hierarchy

```text
java.util.concurrent.Executor
    └── java.util.concurrent.ExecutorService
            ├── java.util.concurrent.AbstractExecutorService
            │       ├── java.util.concurrent.ThreadPoolExecutor
            │       │       └── java.util.concurrent.ScheduledThreadPoolExecutor
            │       └── java.util.concurrent.ForkJoinPool
            └── java.util.concurrent.ScheduledExecutorService
                    └── java.util.concurrent.ScheduledThreadPoolExecutor
```

### Meaning of each level

- Executor
  - smallest interface
  - one method: void execute(Runnable command)

- ExecutorService
  - adds lifecycle control and result handling
  - supports submit(), shutdown(), shutdownNow(), invokeAll(), invokeAny()

- ScheduledExecutorService
  - extends ExecutorService
  - adds delayed and periodic task execution
  - supports schedule(), scheduleAtFixedRate(), scheduleWithFixedDelay()

- AbstractExecutorService
  - common implementation logic for submit(), invokeAll(), invokeAny()

- ThreadPoolExecutor
  - the real workhorse for fixed/cached pools

- ScheduledThreadPoolExecutor
  - specialized pool for scheduled tasks
  - extends ThreadPoolExecutor

- ForkJoinPool
  - special pool for fork/join and work-stealing tasks

---

## 3. Important Interfaces and Their Utility Methods

### Executor

```java
void execute(Runnable command)
```

Use when:
- you only want to run a task
- you do not need a result or lifecycle control

### ExecutorService

```java
void shutdown();
List<Runnable> shutdownNow();
boolean isShutdown();
boolean isTerminated();
boolean awaitTermination(long timeout, TimeUnit unit);

Future<?> submit(Runnable task);
<T> Future<T> submit(Callable<T> task);
<T> Future<T> submit(Runnable task, T result);

<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks);
<T> T invokeAny(Collection<? extends Callable<T>> tasks);
```

### ScheduledExecutorService

```java
ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
<V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit);

ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                      long initialDelay,
                                      long period,
                                      TimeUnit unit);

ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
                                         long initialDelay,
                                         long delay,
                                         TimeUnit unit);
```

### Future

```java
boolean cancel(boolean mayInterruptIfRunning);
boolean isCancelled();
boolean isDone();
V get() throws InterruptedException, ExecutionException;
V get(long timeout, TimeUnit unit)
    throws InterruptedException, ExecutionException, TimeoutException;
```

---

## 4. Main Concrete Classes You Should Know

### 1. ThreadPoolExecutor

- Built from core thread pool logic
- Used internally by many factory methods in Executors
- Supports:
  - corePoolSize
  - maximumPoolSize
  - keepAliveTime
  - BlockingQueue
  - RejectedExecutionHandler

Example:

```java
ThreadPoolExecutor pool = new ThreadPoolExecutor(
    2, 4, 30, TimeUnit.SECONDS,
    new LinkedBlockingQueue<Runnable>()
);
```

### 2. ScheduledThreadPoolExecutor

- Specialized for delayed and periodic scheduling
- Extends ThreadPoolExecutor
- Suitable for timers, retries, periodic jobs, cron-like behavior

### 3. ForkJoinPool

- Designed for divide-and-conquer tasks
- Uses work-stealing
- Best for recursive / parallel algorithms

### 4. FutureTask

- Common implementation of RunnableFuture
- Often used when you want to wrap a Callable and submit it manually

---

## 5. Executors Utility Class (Factory Methods)

The class `java.util.concurrent.Executors` is a utility class that creates pools for you.

### Factory methods

```text
newSingleThreadExecutor()
newFixedThreadPool(int nThreads)
newCachedThreadPool()
newScheduledThreadPool(int corePoolSize)
newSingleThreadScheduledExecutor()
newWorkStealingPool()
newWorkStealingPool(int parallelism)
```

### What each one creates

| Factory Method | Internal Implementation | Best Use Case |
|---|---|---|
| `newSingleThreadExecutor()` | Finalizable DelegatedExecutorService over ThreadPoolExecutor | Sequential tasks, ordering matters |
| `newFixedThreadPool(n)` | ThreadPoolExecutor | Stable number of workers |
| `newCachedThreadPool()` | ThreadPoolExecutor with unbounded growth | Short-lived tasks, bursty load |
| `newScheduledThreadPool(n)` | ScheduledThreadPoolExecutor | Delay / periodic scheduling |
| `newSingleThreadScheduledExecutor()` | ScheduledThreadPoolExecutor with one thread | Sequential scheduled jobs |
| `newWorkStealingPool()` | ForkJoinPool | CPU-heavy parallel tasks |

### Extra utility helpers in Executors

```text
defaultThreadFactory()
privilegedThreadFactory(ThreadFactory factory)
callable(Runnable task)
callable(Runnable task, T result)
unconfigurableExecutorService(ExecutorService executor)
unconfigurableScheduledExecutorService(ScheduledExecutorService executor)
```

---

## 6. Pool Types and Their Practical Behavior

### FixedThreadPool

- Fixed number of worker threads
- Good for controlled parallelism
- Queue holds extra tasks

Use when:
- you want predictable resource usage
- the number of concurrent tasks should stay limited

### CachedThreadPool

- Creates threads on demand
- Reuses idle threads for up to 60 seconds
- Good for many short-lived tasks

Use when:
- task count is unpredictable
- tasks are short-lived

### SingleThreadExecutor

- Exactly one thread
- Tasks run in order
- Good for serialization and stateful work

### ScheduledThreadPool

- Supports delay and periodic execution
- Good for background jobs and repeated tasks

### WorkStealingPool

- Uses multiple worker threads
- Good for parallel fork/join workloads
- Uses work-stealing algorithm for balancing load

---

## 7. Runnable vs Callable

| Aspect | Runnable | Callable |
|---|---|---|
| Return value | No | Yes |
| Exception handling | Cannot throw checked exceptions directly | Can throw checked exceptions |
| submit() result | Future<?> | Future<V> |
| Typical use | Background task | Task that returns output |

---

## 8. Short Summary

The most important mental model is:

```text
Runnable / Callable  ->  ExecutorService / ScheduledExecutorService  ->  Future
```

- Runnable = task without result
- Callable = task with result
- ExecutorService = manager of worker threads
- ScheduledExecutorService = executor with timing features
- Future = handle for result / cancellation / completion status

---

## 9. Recommended Study Path in This Folder

1. Start with `CreateThreadUsingRunnable.java`
2. Study `CallableTask.java` for return values
3. Study `ExecutorFrameworkEx.java` for basic pool usage
4. Review `Synchronization.java` for safe shared resources
5. Use this file as the quick reference for executor hierarchy
