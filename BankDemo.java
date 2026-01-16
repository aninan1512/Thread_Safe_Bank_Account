package com.example.bank_account;

public class BankDemo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(50);

        Thread withdrawer1 = new Thread(() -> {
            try {
                account.withdraw(80);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Withdrawer-1");

        Thread withdrawer2 = new Thread(() -> {
            try {
                account.withdraw(40);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Withdrawer-2");

        Thread depositor = new Thread(() -> {
            try {
                Thread.sleep(1000);
                account.deposit(50);

                Thread.sleep(1000);
                account.deposit(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Depositor");

        System.out.println("Starting balance: " + account.getBalance());

        withdrawer1.start();
        withdrawer2.start();
        depositor.start();
    }
}
