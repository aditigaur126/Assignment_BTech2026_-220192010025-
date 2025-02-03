//Write a Java program to create a class called "Bank" with a collection of accounts and methods to add and remove accounts, and to deposit and withdraw money. Also define a class called "Account" to maintain account details of a particular customer.
package oops;

import java.util.ArrayList;

class Account {
    private String name;
    private int accno;
    private int balance;

    public Account(String name, int accno, int balance) {
        this.name = name;
        this.accno = accno;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNo(int accno) {
        this.accno = accno;
    }

    public int getNo() {
        return accno;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("After deposit :" + balance);
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("After withdrawal :" + balance);
        }
    }

    public void info() {
        System.out.println("Name: " + getName() + " Account Number : " + getNo() + " Balance : " + getBalance());
    }

}

class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<Account>();
    }

    public void addAcc(Account account) {
        accounts.add(account);
    }

    public void removeAcc(Account account) {
        accounts.remove(account);
    }

    public void withdrawal(Account account, int amount) {
        account.withdraw(amount);
    }

    public void depositMoney(Account account, int amount) {
        account.deposit(amount);
    }

    public ArrayList<Account> getacc() {
        return accounts;
    }
}

public class prog6 {
    public static void main(String[] args) {
        Bank b = new Bank();
        Account a1 = new Account("abc", 123, 20000000);
        Account a2 = new Account("axyz", 124, 10000000);
        b.addAcc(a1);
        b.addAcc(a2);
        a1.info();
        a2.info();
        b.depositMoney(a1, 2000);
        b.withdrawal(a2, 500);
        ArrayList<Account> accounts = b.getacc();
        for (Account ac : accounts) {
            ac.info();
        }
    }
}
