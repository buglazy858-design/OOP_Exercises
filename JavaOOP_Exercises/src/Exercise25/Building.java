package Exercise25;

class Building {
    private String address;
    private int numberOfFloors;
    protected double totalArea; // protected for subclass access
    private double maintenanceCost;

    // Constructor
    public Building(String address, int numberOfFloors, double totalArea, double maintenanceCost) {
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.totalArea = totalArea;
        this.maintenanceCost = maintenanceCost;
        System.out.println("Building created at: " + address);
    }

    // Calculate basic maintenance cost per square foot
    public double calculateMaintenancePerSqFt() {
        if (totalArea > 0) {
            return maintenanceCost / totalArea;
        }
        return 0;
    }

    // Calculate area per floor
    public double calculateAreaPerFloor() {
        if (numberOfFloors > 0) {
            return totalArea / numberOfFloors;
        }
        return 0;
    }

    // Display building information
    public void displayBuildingInfo() {
        System.out.println("Address: " + address);
        System.out.println("Number of Floors: " + numberOfFloors);
        System.out.println("Total Area: " + String.format("%.2f", totalArea) + " sq ft");
        System.out.println("Area per Floor: " + String.format("%.2f", calculateAreaPerFloor()) + " sq ft");
        System.out.println("Maintenance Cost: $" + String.format("%.2f", maintenanceCost));
        System.out.println("Maintenance per Sq Ft: $" + String.format("%.2f", calculateMaintenancePerSqFt()));
    }

    // Check if building is tall (more than 10 floors)
    public boolean isTallBuilding() {
        return numberOfFloors > 10;
    }

    // Get building category based on floors
    public String getBuildingCategory() {
        if (numberOfFloors <= 3) {
            return "Low-Rise";
        } else if (numberOfFloors <= 10) {
            return "Mid-Rise";
        } else if (numberOfFloors <= 40) {
            return "High-Rise";
        } else {
            return "Skyscraper";
        }
    }

    // Getters
    public String getAddress() {
        return address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    // Setters with validation
    public void setMaintenanceCost(double maintenanceCost) {
        if (maintenanceCost >= 0) {
            this.maintenanceCost = maintenanceCost;
            System.out.println("Maintenance cost updated to: $" + String.format("%.2f", maintenanceCost));
        } else {
            System.out.println("✗ Maintenance cost cannot be negative!");
        }
    }
}
