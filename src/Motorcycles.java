public class Motorcycles  extends Cars {


    private String bikeType;

    public Motorcycles(String make, String model, int year, double rentalRate, String bikeType) {
        super(make, model, year, rentalRate);
        this.bikeType = bikeType;

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bike Type: " + bikeType);

    }
}