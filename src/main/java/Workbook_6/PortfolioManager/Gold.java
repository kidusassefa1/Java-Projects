package Workbook_6.PortfolioManager;

import java.math.BigDecimal;

public class Gold extends FixedAsset {
    private double weight;

    public Gold(String name, double value, double weight) {
        super(name, value);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public BigDecimal getValue() {
        return BigDecimal.ZERO;
    }


}
