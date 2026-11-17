package Workbook_5.AssetManager;

import java.math.BigDecimal;

public class House extends Asset {
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost,
                 String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal pricePerSquareFoot;

        switch (condition) {
            case 1:
                pricePerSquareFoot = new BigDecimal("180.00");
                break;
            case 2:
                pricePerSquareFoot = new BigDecimal("130.00");
                break;
            case 3:
                pricePerSquareFoot = new BigDecimal("90.00");
                break;
            case 4:
                pricePerSquareFoot = new BigDecimal("80.00");
                break;
            default:
                throw new IllegalArgumentException("Invalid house condition");
        }

        BigDecimal houseValue = pricePerSquareFoot.multiply(
                BigDecimal.valueOf(squareFoot));

        BigDecimal landValue = new BigDecimal("0.25").multiply(
                BigDecimal.valueOf(lotSize));

        return houseValue.add(landValue);
    }
}

