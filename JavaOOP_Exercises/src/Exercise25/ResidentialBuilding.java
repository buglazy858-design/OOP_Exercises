package Exercise25;

class ResidentialBuilding extends Building {
    private int numberOfApartments;
    private double averageRentPerApartment;
    private boolean hasParking;
    private boolean hasGym;

    // Constructor
    public ResidentialBuilding(String address, int numberOfFloors, double totalArea,
            double maintenanceCost, int numberOfApartments,
            double averageRentPerApartment, boolean hasParking, boolean hasGym) {
        super(address, numberOfFloors, totalArea, maintenanceCost);
        this.numberOfApartments = numberOfApartments;
        this.averageRentPerApartment = averageRentPerApartment;
        this.hasParking = hasParking;
        this.hasGym = hasGym;
        System.out.println("Residential building with " + numberOfApartments + " apartments");
    }

    // Calculate total monthly rent from all apartments
    public double calculateTotalRent() {
        return numberOfApartments * averageRentPerApartment;
    }

    // Calculate annual rental income
    public double calculateAnnualRentalIncome() {
        return calculateTotalRent() * 12;
    }

    // Calculate profit after maintenance (assuming maintenance is monthly)
    public double calculateMonthlyProfit() {
        return calculateTotalRent() - getMaintenanceCost();
    }

    // Calculate area per apartment
    public double calculateAreaPerApartment() {
        if (numberOfApartments > 0) {
            return totalArea / numberOfApartments;
        }
        return 0;
    }

    // Calculate occupancy rate (for simulation purposes)
    public double calculateOccupancyRate(int occupiedApartments) {
        if (numberOfApartments > 0) {
            return (occupiedApartments * 100.0) / numberOfApartments;
        }
        return 0;
    }

    // Override displayBuildingInfo to show residential specific information
    @Override
    public void displayBuildingInfo() {
        System.out.println("\n=== RESIDENTIAL BUILDING ===");
        super.displayBuildingInfo();
        System.out.println("Number of Apartments: " + numberOfApartments);
        System.out.println("Average Rent per Apartment: $" + String.format("%.2f", averageRentPerApartment));
        System.out.println("Area per Apartment: " + String.format("%.2f", calculateAreaPerApartment()) + " sq ft");
        System.out.println("Parking Available: " + (hasParking ? "Yes" : "No"));
        System.out.println("Gym Available: " + (hasGym ? "Yes" : "No"));
        System.out.println("Total Monthly Rent: $" + String.format("%.2f", calculateTotalRent()));
        System.out.println("Annual Rental Income: $" + String.format("%.2f", calculateAnnualRentalIncome()));
        System.out.println("Monthly Profit: $" + String.format("%.2f", calculateMonthlyProfit()));
        System.out.println("Building Category: " + getBuildingCategory());
        System.out.println("Tall Building: " + (isTallBuilding() ? "Yes" : "No"));
    }

    // Residential building specific method - calculate amenities value
    public double calculateAmenitiesValue() {
        double amenitiesValue = 0;
        if (hasParking) {
            amenitiesValue += 50.0 * numberOfApartments; // $50 per apartment for parking
        }
        if (hasGym) {
            amenitiesValue += 30.0 * numberOfApartments; // $30 per apartment for gym
        }
        return amenitiesValue;
    }

    // Getters
    public int getNumberOfApartments() {
        return numberOfApartments;
    }

    public double getAverageRentPerApartment() {
        return averageRentPerApartment;
    }

    public boolean hasParking() {
        return hasParking;
    }

    public boolean hasGym() {
        return hasGym;
    }
}

// Subclass: CommercialBuilding
class CommercialBuilding extends Building {
    private int numberOfOffices;
    private double rentPerSqFt;
    private String businessType;
    private boolean hasElevator;
    private double commonArea; // area not rented out (hallways, etc.)

    // Constructor
    public CommercialBuilding(String address, int numberOfFloors, double totalArea,
            double maintenanceCost, int numberOfOffices, double rentPerSqFt,
            String businessType, boolean hasElevator, double commonArea) {
        super(address, numberOfFloors, totalArea, maintenanceCost);
        this.numberOfOffices = numberOfOffices;
        this.rentPerSqFt = rentPerSqFt;
        this.businessType = businessType;
        this.hasElevator = hasElevator;
        this.commonArea = commonArea;
        System.out.println("Commercial building for " + businessType + " with " + numberOfOffices + " offices");
    }

    // Calculate total rentable area (total area minus common area)
    public double calculateRentableArea() {
        return totalArea - commonArea;
    }

    // Calculate total monthly rent
    public double calculateTotalRent() {
        return calculateRentableArea() * rentPerSqFt;
    }

    // Calculate annual rental income
    public double calculateAnnualRentalIncome() {
        return calculateTotalRent() * 12;
    }

    // Calculate profit after maintenance
    public double calculateMonthlyProfit() {
        return calculateTotalRent() - getMaintenanceCost();
    }

    // Calculate area per office
    public double calculateAreaPerOffice() {
        if (numberOfOffices > 0) {
            return calculateRentableArea() / numberOfOffices;
        }
        return 0;
    }

    // Calculate common area percentage
    public double calculateCommonAreaPercentage() {
        if (totalArea > 0) {
            return (commonArea * 100.0) / totalArea;
        }
        return 0;
    }

    // Override displayBuildingInfo to show commercial specific information
    @Override
    public void displayBuildingInfo() {
        System.out.println("\n=== COMMERCIAL BUILDING ===");
        super.displayBuildingInfo();
        System.out.println("Number of Offices: " + numberOfOffices);
        System.out.println("Rent per Sq Ft: $" + String.format("%.2f", rentPerSqFt));
        System.out.println("Business Type: " + businessType);
        System.out.println("Elevator: " + (hasElevator ? "Yes" : "No"));
        System.out.println("Common Area: " + String.format("%.2f", commonArea) + " sq ft");
        System.out.println("Rentable Area: " + String.format("%.2f", calculateRentableArea()) + " sq ft");
        System.out.println("Area per Office: " + String.format("%.2f", calculateAreaPerOffice()) + " sq ft");
        System.out.println("Common Area Percentage: " + String.format("%.2f", calculateCommonAreaPercentage()) + "%");
        System.out.println("Total Monthly Rent: $" + String.format("%.2f", calculateTotalRent()));
        System.out.println("Annual Rental Income: $" + String.format("%.2f", calculateAnnualRentalIncome()));
        System.out.println("Monthly Profit: $" + String.format("%.2f", calculateMonthlyProfit()));
        System.out.println("Building Category: " + getBuildingCategory());
        System.out.println("Tall Building: " + (isTallBuilding() ? "Yes" : "No"));
    }

    // Commercial building specific method - calculate business suitability
    public String getBusinessSuitability() {
        double areaPerOffice = calculateAreaPerOffice();
        if (areaPerOffice >= 1000) {
            return "Large Corporations";
        } else if (areaPerOffice >= 500) {
            return "Medium Businesses";
        } else if (areaPerOffice >= 200) {
            return "Small Businesses";
        } else {
            return "Startups/Individual Offices";
        }
    }

    // Commercial building specific method - calculate elevator value
    public double calculateElevatorValue() {
        if (hasElevator) {
            return rentPerSqFt * 0.15 * calculateRentableArea(); // 15% premium for elevator
        }
        return 0;
    }

    // Getters
    public int getNumberOfOffices() {
        return numberOfOffices;
    }

    public double getRentPerSqFt() {
        return rentPerSqFt;
    }

    public String getBusinessType() {
        return businessType;
    }

    public boolean hasElevator() {
        return hasElevator;
    }

    public double getCommonArea() {
        return commonArea;
    }
}
