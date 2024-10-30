public class Motorcycles extends Vehicles {


    private String bikeType;

    public Motorcycles(String make, String model, int year, double rentalRate, String bikeType) {
        super(make, model, year, rentalRate);
        if(bikeType == null || bikeType.isEmpty()){
            throw new IllegalArgumentException("bikeType is null or empty");
        }
        this.bikeType = bikeType;

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bike Type: " + bikeType);

    }
    @Override
    public String toString() {
        return super.toString() + "| BikeType: " + bikeType;
    }
}