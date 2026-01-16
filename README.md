# Thread-Safe Bank Account (Java)

## Overview
This project implements a thread-safe bank account system in Java that supports concurrent deposits and withdrawals while maintaining data consistency. It demonstrates correct synchronization and inter-thread communication using Java’s built-in concurrency primitives.

The application simulates a simple banking scenario where multiple threads operate on a shared account balance without causing race conditions or invalid states.

---

## Features
- Thread-safe balance management using `synchronized` methods
- Correct use of `wait()` and `notifyAll()` for inter-thread coordination
- Blocking withdrawals when funds are insufficient
- Safe concurrent deposits and withdrawals
- Multithreaded simulation demonstrating real-world behavior

## How It Works
- A shared `BankAccount` object stores the account balance.
- Withdrawal threads attempt to withdraw funds concurrently.
- If the balance is insufficient, the withdrawal thread waits.
- Deposit operations add funds and notify waiting threads.
- Waiting threads re-check the balance condition before proceeding, ensuring correctness even in the presence of spurious wakeups.

Because thread scheduling is handled by the JVM, output order may vary between executions.


The balance never becomes negative, and withdrawals only complete when sufficient funds are available.

---

## How to Run

### Requirements
- Java 8 or later
- IntelliJ IDEA or any Java-compatible IDE

### Running in IntelliJ IDEA
1. Open the project in IntelliJ.
2. Ensure `src/main/java` is marked as a **Sources Root**.
3. Open `BankDemo.java`.
4. Run the `main` method.

### Running from the Terminal
```bash
javac BankAccount.java BankDemo.java
java BankDemo
