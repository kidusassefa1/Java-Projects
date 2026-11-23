package Workbook_5.Workshop_5W;

import java.math.BigDecimal;

public class LeaseContract extends Contract {

    private BigDecimal expectedEndingValue;
    private BigDecimal leaseFee;


    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice().multiply(BigDecimal.valueOf(0.5));
        this.leaseFee = vehicleSold.getPrice().multiply(BigDecimal.valueOf(0.07));
    }

    public BigDecimal getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(BigDecimal expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getExpectedEndingValue().add(getLeaseFee());
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        double annualRate = 0.04;
        int months = 36;

        double principal = getTotalPrice().doubleValue();
        double monthlyRate = annualRate / 12;

        double monthlyPayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, months)) / (Math.pow(1 + monthlyRate, months) - 1);

        return BigDecimal.valueOf(monthlyPayment);
    }

    @Override
    public String toString() {
        return String.format("LEASE|%s|%s|%s|%s|%s|%s|%s|%s",
                getDate(),
                getCustomerName(),
                getCustomerEmail(),
                getVehicleSold(),
                getExpectedEndingValue(),
                getLeaseFee(),
                getTotalPrice(),
                getMonthlyPayment());
    }
}
