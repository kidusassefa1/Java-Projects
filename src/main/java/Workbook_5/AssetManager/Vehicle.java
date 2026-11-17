package Workbook_5.AssetManager;

import java.math.BigDecimal;
import java.time.Year;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost,
                   String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int age = Math.max(0, Year.now().getValue() - year);
        BigDecimal value;

        if (age <= 3) {
            value = getOriginalCost().multiply(
                    BigDecimal.ONE.subtract(
                            new BigDecimal("0.03").multiply(BigDecimal.valueOf(age))));
        } else if (age <= 6) {
            value = getOriginalCost().multiply(
                    BigDecimal.ONE.subtract(
                            new BigDecimal("0.06").multiply(BigDecimal.valueOf(age))));
        } else if (age <= 10) {
            value = getOriginalCost().multiply(
                    BigDecimal.ONE.subtract(
                            new BigDecimal("0.08").multiply(BigDecimal.valueOf(age))));
        } else {
            value = new BigDecimal("1000.00");
        }

        String model = makeModel.toLowerCase();

        if (odometer > 100000
                && !model.contains("honda")
                && !model.contains("toyota")) {
            value = value.multiply(new BigDecimal("0.75"));
        }

        return value.max(BigDecimal.ZERO);
    }
}

