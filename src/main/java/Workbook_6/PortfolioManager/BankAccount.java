package Workbook_6.PortfolioManager;

import java.math.BigDecimal;

public class BankAccount implements Valuable {
    private String name;
    private String accountNumber;
    private BigDecimal balance;

    public BankAccount(String name, String accountNumber, BigDecimal balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal amount) {
        balance = balance.add(amount);
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
        return balance;
    }

    @Override
    public BigDecimal getValue() {
        return BigDecimal.ZERO;
    }

}
