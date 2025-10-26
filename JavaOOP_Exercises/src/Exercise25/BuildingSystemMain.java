package Exercise25;

// Subclass: ResidentialBuilding


// Main class to test the building system
public class BuildingSystemMain {
    public static void main(String[] args) {
        System.out.println("=== BUILDING MANAGEMENT SYSTEM ===\n");

        // Create residential buildings
        System.out.println("--- Creating Residential Buildings ---");
        ResidentialBuilding apartment1 = new ResidentialBuilding("123 Main St", 5, 25000, 5000,
                20, 1200, true, true);
        ResidentialBuilding apartment2 = new ResidentialBuilding("456 Oak Ave", 3, 12000, 3000,
                12, 900, false, true);
        ResidentialBuilding luxuryApartment = new ResidentialBuilding("789 Park Blvd", 15, 75000, 15000,
                40, 2500, true, true);

        // Create commercial buildings
        System.out.println("\n--- Creating Commercial Buildings ---");
        CommercialBuilding office1 = new CommercialBuilding("101 Business Rd", 8, 40000, 8000,
                25, 2.50, "Office", true, 5000);
        CommercialBuilding retail1 = new CommercialBuilding("202 Market St", 2, 15000, 4000,
                8, 3.00, "Retail", false, 2000);
        CommercialBuilding techPark = new CommercialBuilding("303 Innovation Dr", 12, 60000, 12000,
                35, 3.25, "Technology", true, 8000);

        // Display residential building information
        System.out.println("\n--- Residential Building Information ---");
        apartment1.displayBuildingInfo();
        System.out.println("\n" + "=".repeat(60));
        apartment2.displayBuildingInfo();
        System.out.println("\n" + "=".repeat(60));
        luxuryApartment.displayBuildingInfo();

        // Display commercial building information
        System.out.println("\n--- Commercial Building Information ---");
        office1.displayBuildingInfo();
        System.out.println("\n" + "=".repeat(60));
        retail1.displayBuildingInfo();
        System.out.println("\n" + "=".repeat(60));
        techPark.displayBuildingInfo();

        // Test rent calculations
        System.out.println("\n=== RENT CALCULATION COMPARISON ===");
        System.out.println("Apartment 1 Total Rent: $" + String.format("%.2f", apartment1.calculateTotalRent()));
        System.out.println("Apartment 2 Total Rent: $" + String.format("%.2f", apartment2.calculateTotalRent()));
        System.out.println(
                "Luxury Apartment Total Rent: $" + String.format("%.2f", luxuryApartment.calculateTotalRent()));
        System.out.println("Office 1 Total Rent: $" + String.format("%.2f", office1.calculateTotalRent()));
        System.out.println("Retail 1 Total Rent: $" + String.format("%.2f", retail1.calculateTotalRent()));
        System.out.println("Tech Park Total Rent: $" + String.format("%.2f", techPark.calculateTotalRent()));

        // Test specific methods
        System.out.println("\n=== BUILDING SPECIFIC FEATURES ===");
        System.out.println(
                "Apartment 1 Amenities Value: $" + String.format("%.2f", apartment1.calculateAmenitiesValue()));
        System.out.println("Office 1 Business Suitability: " + office1.getBusinessSuitability());
        System.out.println("Tech Park Elevator Value: $" + String.format("%.2f", techPark.calculateElevatorValue()));

        // Test occupancy rate simulation
        System.out.println("\n=== OCCUPANCY SIMULATION ===");
        System.out.println("Apartment 1 Occupancy Rate: " +
                String.format("%.1f", apartment1.calculateOccupancyRate(18)) + "%");
        System.out.println("Apartment 2 Occupancy Rate: " +
                String.format("%.1f", apartment2.calculateOccupancyRate(10)) + "%");

        // Test profit calculations
        System.out.println("\n=== PROFIT ANALYSIS ===");
        System.out.println("Luxury Apartment Monthly Profit: $" +
                String.format("%.2f", luxuryApartment.calculateMonthlyProfit()));
        System.out.println("Tech Park Monthly Profit: $" +
                String.format("%.2f", techPark.calculateMonthlyProfit()));

        // Test error handling
        System.out.println("\n=== TESTING ERROR HANDLING ===");
        apartment1.setMaintenanceCost(-1000); // Invalid maintenance cost
        apartment1.setMaintenanceCost(5500); // Valid maintenance cost

        // Demonstrate polymorphism
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        Building[] buildings = {
                new ResidentialBuilding("444 Elm St", 4, 18000, 4000, 15, 1100, true, false),
                new CommercialBuilding("555 Commerce Ave", 6, 30000, 6000, 20, 2.75, "Mixed Use", true, 4000),
                new ResidentialBuilding("666 Pine Rd", 7, 35000, 7000, 28, 1500, false, true),
                new CommercialBuilding("777 Corporate Ln", 10, 50000, 10000, 30, 3.10, "Finance", true, 6000)
        };

        // Display all buildings and their rental information
        for (Building building : buildings) {
            building.displayBuildingInfo();

            // Calculate and display rent based on building type
            if (building instanceof ResidentialBuilding) {
                ResidentialBuilding rb = (ResidentialBuilding) building;
                System.out.println("RESIDENTIAL - Annual Income: $" +
                        String.format("%.2f", rb.calculateAnnualRentalIncome()));
            } else if (building instanceof CommercialBuilding) {
                CommercialBuilding cb = (CommercialBuilding) building;
                System.out.println("COMMERCIAL - Annual Income: $" +
                        String.format("%.2f", cb.calculateAnnualRentalIncome()));
            }
            System.out.println("\n" + "=".repeat(70));
        }

        // Final summary
        System.out.println("=== BUILDING PORTFOLIO SUMMARY ===");
        System.out.println("Residential Buildings: 123 Main St, 456 Oak Ave, 789 Park Blvd, 444 Elm St, 666 Pine Rd");
        System.out.println("Commercial Buildings: 101 Business Rd, 202 Market St, 303 Innovation Dr, " +
                "555 Commerce Ave, 777 Corporate Ln");
        System.out.println("Building Categories: Low-Rise, Mid-Rise, High-Rise");
        System.out.println("All buildings support rent calculation and profit analysis");
    }
}