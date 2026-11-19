package Workbook_6.PortfolioManager;

import java.math.BigDecimal;

public class Jewelry extends FixedAsset{
    private double karat;

    public Jewelry(String name, double value, double karat) {
        super(name, value);
        this.karat = karat;
    }

    public double getKarat() {
        return karat;
    }

    public void setKarat(double karat) {
        this.karat = karat;
    }

    @Override
    public BigDecimal getValue() {
        return BigDecimal.ZERO;
    }

}
