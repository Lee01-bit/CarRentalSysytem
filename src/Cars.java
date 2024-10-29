public class Cars {
    private String make;
    private String model;
    private int year;
    private double rentalPrice;

    public Cars(String make, String model, int year, double rentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    public void displayInfo() {
        System.out.println("Make : " + make);
        System.out.println("Model : " + model);
        System.out.println("Year : " + year);
        System.out.println("Rental Price : " + rentalPrice);
    }

    public double getRentalPrice() {
        return rentalPrice;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
}
