package Workbook_5.AssetManager;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AssetTest {

    @Test
    public void testAssetValue() {
        Asset asset = new Asset("My laptop", "2024-01-10", new BigDecimal("1500.00"));

        assertEquals(new BigDecimal("1500.00"), asset.getValue());
    }

    @Test
    public void testHouseExcellentCondition() {
        House house = new House(
                "My house",
                "2020-05-10",
                new BigDecimal("350000.00"),
                "123 Main St",
                1,
                2000,
                5000
        );

        // 2000 * 180 + 5000 * 0.25 = 361250
        assertEquals(0, new BigDecimal("361250.00").compareTo(house.getValue()));
    }

    @Test
    public void testHouseGoodCondition() {
        House house = new House(
                "Vacation home",
                "2022-08-15",
                new BigDecimal("250000.00"),
                "456 Lake Rd",
                2,
                1500,
                4000
        );

        // 1500 * 130 + 4000 * 0.25 = 196000
        assertEquals(
                0,
                new BigDecimal("196000.00")
                        .compareTo(house.getValue())
        );
    }

    @Test
    public void testVehicleDepreciation() {
        int currentYear = java.time.Year.now().getValue();

        Vehicle vehicle = new Vehicle(
                "My car",
                "2024-01-01",
                new BigDecimal("20000.00"),
                "Ford Focus",
                currentYear - 2,
                40000
        );

        // 2 years old: 3% per year = 6% reduction
        assertEquals(
                0,
                new BigDecimal("18800.00")
                        .compareTo(vehicle.getValue())
        );
    }

    @Test
    public void testVehicleHighMileage() {
        int currentYear = java.time.Year.now().getValue();

        Vehicle vehicle = new Vehicle(
                "Tom's truck",
                "2024-01-01",
                new BigDecimal("20000.00"),
                "Ford F-150",
                currentYear - 2,
                120000
        );

        // 18800 * 0.75 = 14100
        assertEquals(
                0,
                new BigDecimal("14100.00")
                        .compareTo(vehicle.getValue())
        );
    }

    @Test
    public void testHondaMileageException() {
        int currentYear = java.time.Year.now().getValue();

        Vehicle vehicle = new Vehicle(
                "My Honda",
                "2024-01-01",
                new BigDecimal("20000.00"),
                "Honda Accord",
                currentYear - 2,
                150000
        );

        // Honda is exempt from the 25% mileage reduction
        assertEquals(
                0,
                new BigDecimal("18800.00")
                        .compareTo(vehicle.getValue())
        );
    }

    @Test
    public void testToyotaMileageException() {
        int currentYear = java.time.Year.now().getValue();

        Vehicle vehicle = new Vehicle(
                "My Toyota",
                "2024-01-01",
                new BigDecimal("20000.00"),
                "Toyota Camry",
                currentYear - 2,
                150000
        );

        assertEquals(
                0,
                new BigDecimal("18800.00")
                        .compareTo(vehicle.getValue())
        );
    }

    @Test
    public void testVehicleOverTenYears() {
        int currentYear = java.time.Year.now().getValue();

        Vehicle vehicle = new Vehicle(
                "Old car",
                "2010-01-01",
                new BigDecimal("30000.00"),
                "Ford Focus",
                currentYear - 12,
                80000
        );

        assertEquals(
                0,
                new BigDecimal("1000.00")
                        .compareTo(vehicle.getValue())
        );
    }

    @Test
    public void testInheritanceAndPolymorphism() {
        ArrayList<Asset> myAssets = new ArrayList<>();

        myAssets.add(new House(
                "My house", "2020-05-10",
                new BigDecimal("350000.00"),
                "123 Main St", 1, 2000, 5000
        ));

        myAssets.add(new House(
                "Vacation home", "2022-08-15",
                new BigDecimal("250000.00"),
                "456 Lake Rd", 2, 1500, 4000
        ));

        myAssets.add(new Vehicle(
                "My car", "2024-01-01",
                new BigDecimal("20000.00"),
                "Honda Accord", 2024, 45000
        ));

        myAssets.add(new Vehicle(
                "Tom's truck", "2018-06-20",
                new BigDecimal("50000.00"),
                "Ford F-150", 2018, 125000
        ));

        assertEquals(4, myAssets.size());

        for (Asset asset : myAssets) {
            assertNotNull(asset.getValue());

            System.out.println("\nDescription: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.printf("Original Cost: $%,.2f%n",
                    asset.getOriginalCost());
            System.out.printf("Current Value: $%,.2f%n",
                    asset.getValue());

            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("House at " + house.getAddress());

            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Vehicle: " + vehicle.getYear()
                        + " " + vehicle.getMakeModel());
            }

            System.out.println("-----------------------------");
        }

        assertInstanceOf(House.class, myAssets.get(0));
        assertInstanceOf(House.class, myAssets.get(1));
        assertInstanceOf(Vehicle.class, myAssets.get(2));
        assertInstanceOf(Vehicle.class, myAssets.get(3));
    }
}
