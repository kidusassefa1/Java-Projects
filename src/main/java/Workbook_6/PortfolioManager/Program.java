package Workbook_6.PortfolioManager;

import java.math.BigDecimal;

public class Program {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123", "Pam", new BigDecimal("12500"));
        Valuable account2 = new BankAccount("456", "Gary", new BigDecimal("1500"));
// try to deposit money into both accounts
        account1.deposit(new BigDecimal(100));
        ((BankAccount)account2).deposit(new BigDecimal(100));
    }
}
