package com.example.bank_account;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be > 0.");
        }

        int oldBalance = balance;
        balance += amount;

        System.out.printf(
                "[%s] Deposit: +%d | %d -> %d%n",
                Thread.currentThread().getName(),
                amount,
                oldBalance,
                balance
        );

        notifyAll();
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be > 0.");
        }

        while (balance < amount) {
            System.out.printf(
                    "[%s] Withdraw: -%d | Waiting (balance=%d)%n",
                    Thread.currentThread().getName(),
                    amount,
                    balance
            );
            wait();
        }

        int oldBalance = balance;
        balance -= amount;

        System.out.printf(
                "[%s] Withdraw: -%d | %d -> %d%n",
                Thread.currentThread().getName(),
                amount,
                balance + amount,
                balance
        );
    }
}
