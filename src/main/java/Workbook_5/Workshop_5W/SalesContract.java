package Workbook_5.Workshop_5W;

import java.math.BigDecimal;

public class SalesContract extends Contract{
    private BigDecimal salesTax;
    private BigDecimal recordingFee;
    private BigDecimal processingFee;
    private boolean isFinancing;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinancing) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTax = vehicleSold.getPrice().multiply(BigDecimal.valueOf(0.05));
        this.recordingFee = BigDecimal.valueOf(100);

        if (vehicleSold.getPrice().compareTo(BigDecimal.valueOf(10000)) >= 0) {
            this.processingFee = BigDecimal.valueOf(495);
        } else {
            this.processingFee = BigDecimal.valueOf(295);
        }

        this.isFinancing = isFinancing;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(BigDecimal recordingFee) {
        this.recordingFee = recordingFee;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinancing() {
        return isFinancing;
    }

    public void setFinancing(boolean financing) {
        isFinancing = financing;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getVehicleSold().getPrice()
                .add(getSalesTax())
                .add(getProcessingFee())
                .add(getRecordingFee());
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        if (!isFinancing) {
            return BigDecimal.ZERO;
        }

        double annualRate;
        int months;

        if (getVehicleSold().getPrice().compareTo(BigDecimal.valueOf(10000)) >= 0) {
            annualRate = 0.0425;
            months = 48;
        } else {
            annualRate = 0.0525;
            months = 24;
        }

        double principal = getTotalPrice().doubleValue();
        double monthlyRate = annualRate / 12;

        double monthlyPayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, months)) / (Math.pow(1 + monthlyRate, months) - 1);

        return BigDecimal.valueOf(monthlyPayment);
    }
}
