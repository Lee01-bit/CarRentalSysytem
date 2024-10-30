import java.util.ArrayList;
import java.util.List;

public class SystemRental {

    private static List<SpecificCar> availableSpecificCars;
    private final List<SpecificCar> rentalSpecificCars;
    private static List<Motorcycles> availableMotorcycles;

    public SystemRental() {
        availableSpecificCars = new ArrayList<SpecificCar>();
        rentalSpecificCars = new ArrayList<SpecificCar>();
        availableMotorcycles = new ArrayList<Motorcycles>();
    }

    // this will add vehicles to the rental system

    public void addCar(SpecificCar car) {
        if (car != null){
            availableSpecificCars.add(car);
            System.out.println(car.getMake() + " " + car.getModel() + "  " + car.getYear() + "Added to available cars");

        }else{
            System.out.println("Car is null");
        }


    }
    public void addMotorcycle(Motorcycles motorcycle) {
      if(motorcycle != null){  availableMotorcycles.add(motorcycle);
        System.out.println(motorcycle.getMake() + " " + motorcycle.getModel() + "Added to available cars " + motorcycle.getYear());
    } else {
          System.out.println("Cannot add a null motorcycle");
      }
    }

    public static List<SpecificCar> getAvailableCars() {
        return availableSpecificCars;
    }
    public List<SpecificCar> getRentalCars() {
        return rentalSpecificCars;
    }

    //To start renting a Car
    public void rentVehicle(SpecificCar specificCar) {
        if(availableSpecificCars.contains(specificCar)) {
            availableSpecificCars.remove(specificCar);
            rentalSpecificCars.add(specificCar);
        }
    }

    // this will return rented vehicle

    public void returnVehicle(SpecificCar specificCar) {
        if(rentalSpecificCars.contains(specificCar)) {
            rentalSpecificCars.remove(specificCar);
            availableSpecificCars.add(specificCar);
        }
    }
    public void displayRented(){
        System.out.println("=== Rental Cars ===" );
        for(SpecificCar specificCar : rentalSpecificCars) {
            specificCar.displayInfo();

        }
    }
    // displays available and  rented vehicle
    public void displayInfo() {
        System.out.println("=== Available Cars === ");
        for(SpecificCar specificCar : availableSpecificCars) {
            specificCar.displayInfo();
            rentalSpecificCars.add(specificCar);

        }

    }

    //calculate total rental cost
    public double rentalCost(SpecificCar specificCar, int durationRental){

        double rentalRate = specificCar.getRentalPrice();
        return  rentalRate * durationRental ;
    }


}
