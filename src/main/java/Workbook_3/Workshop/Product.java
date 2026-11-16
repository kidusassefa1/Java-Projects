package Workbook_3.Workshop;

public class Product {
    private final String sku;
    private final String productName;
    private final double price;
    private final String department;

    public Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return this.sku;
    }

    public String getName() {
        return this.productName;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDepartment() { return this.department; }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Price: %.2f | Department: %s", this.getSku(), this.getName(), this.getPrice(), this.getDepartment());
    }
}
