import java.util.ArrayList;
import java.util.List;

public class SystemRental {

    private static List<Car>availableCars;
    private List<Car>rentalCars;

    public SystemRental() {
        availableCars = new ArrayList<Car>();
        rentalCars = new ArrayList<Car>();
    }

    // this will add vehicles to the rental system

    public void addCar(Cars cars) {
        availableCars.add((Car) cars);
    }

    public static List<Car> getAvailableCars() {
        return availableCars;
    }
    public List<Car> getRentalCars() {
        return rentalCars;
    }

    //To start renting a Car
    public void rentVehicle(Car car) {
        if(availableCars.contains(car)) {
            availableCars.remove(car);
            availableCars.add(car);
        }
    }

    // this will return rented vehicle

    public void returnVehicle(Car car) {
        if(rentalCars.contains(car)) {
            rentalCars.remove(car);
            availableCars.add(car);
        }
    }

    // displays available and  rented vehicle
    public void displayInfo() {
        System.out.println("Available Cars: " + availableCars);
        for(Car car : availableCars) {
            car.displayInfo();
            System.out.println();
        }
        System.out.println("Rental Cars: " + rentalCars);
        for(Car car : rentalCars) {
            car.displayInfo();
            System.out.println();
        }
    }

    //calculate total rental cost
    public double rentalCost(Car car, int durationRental){
        double rentalRate = car.getRentalPrice();
        double totalCost = rentalRate * durationRental;
        return totalCost;
    }

}
