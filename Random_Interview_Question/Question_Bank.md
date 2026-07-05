# Java Interview Preparation Notes

## Java Interview

- Why is composition generally preferred over inheritance in Java?
- How would you ensure running threads always see a consistent configuration when configuration is refreshed?
- Which Java Collections would you use to optimize a Spring Boot application?

---

## Spring Boot Interview

- How would you implement Idempotency in REST APIs?
- How would you handle Race Condition when multiple requests with the same Idempotency Key arrive simultaneously?
- How would you ensure Data Consistency across Distributed Microservices?
- How would you handle failure when a downstream service in a Saga fails?

---

## Singleton and Concurrency

- Explain advanced strategies for initializing a service while ensuring thread safety and minimal performance overhead.
- Why is `volatile` required in Double-Checked Locking (DCL)?
- Stateless vs Stateful Object (Very Important for Singleton & Spring Boot)
- Does removing `final` make a Singleton Bean Stateful?
- How does `volatile` guarantee Visibility?
- What is Atomicity?
- Difference between `volatile` and Atomic Classes.