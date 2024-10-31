public class SpecificCar extends Vehicles {

    private int doorNum;
    private boolean isConvertible;
    private String typeOfFuel;

    public SpecificCar(String make, String model, int year, double rentalRate, int doorNum, boolean isConvertible, String typeOfFuel) {
        super(make, model, year, rentalRate);

        if (typeOfFuel == null || typeOfFuel.isEmpty()) {
            throw new IllegalArgumentException("Type of fuel cannot be null or empty");
        }
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
        System.out.println();
    }
    @Override
    public String toString(){
        return super.toString() + "\nNumber of Doors: " + doorNum +"| Convertible: " + isConvertible +"| Type: " + typeOfFuel ;
    }
}