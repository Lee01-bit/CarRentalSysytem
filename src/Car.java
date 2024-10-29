public class Car extends Cars {

    private int doorNum;
    private boolean isConvertible;
    private String typeOfFuel;

    public Car(String make, String model, int year, double rentalRate, int doorNum, boolean isConvertible, String typeOfFuel) {
        super(make, model, year, rentalRate);
        this.doorNum = doorNum;
        this.isConvertible = isConvertible;
        this.typeOfFuel = typeOfFuel;
    }




    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + doorNum);
        System.out.println("Convertible: " + isConvertible);
        System.out.println("Fuel Type: " + typeOfFuel);
    }

}