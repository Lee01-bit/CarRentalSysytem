    import java.util.Scanner;

public class CarRental {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SystemRental rental = new SystemRental();

        Cars car = new Car("Toyota", "Supra", 2020, 120,2,false,"Petrol");
        Cars car1 = new Car("Audi", "R8", 2020, 200,2,true,"Diesel");
        Cars motorcycle = new Car("Bmw", "S1000", 2008, 100,0,false,"Petrol");

        rental.addCar(car);
        rental.addCar(car1);
        rental.addCar(motorcycle);

        while (true) {
            System.out.println();
            System.out.println("===Car Rental System===");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. Display Rental Information");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");


            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:{
                    //Rents a Car
                    System.out.print("Enter the vehicle make: ");
                    String make = sc.nextLine();
                    System.out.println("Enter the vehicle model: ");
                    String model = sc.nextLine();

                    Car selectedCar = null;

                    // check for available vehicles
                    for(Car vc: rental.getAvailableCars()) {
                        if(vc.getMake().equalsIgnoreCase(make) && vc.getModel().equalsIgnoreCase(model)){
                            selectedCar = vc;
                        }
                    }

                    if (selectedCar != null) {
                        // add the vehicle to rented vehicle
                        rental.rentVehicle(selectedCar);
                        System.out.print("Enter the rental duration in days: ");
                        int rentDuration = sc.nextInt();

                        double rc = rental.rentalCost(selectedCar, rentDuration);
                        System.out.println("Successfully rent a vehicle");
                        System.out.println("Rental cost: " + rc);

                    }
                    else {
                        System.out.println("Vehicle not found");
                    }
                break;
                }
                case 2:{
                    //returns a  Car
                    System.out.print("Enter the vehicle make: ");
                    String make = sc.nextLine();
                    System.out.println("Enter the vehicle model: ");
                    String model = sc.nextLine();
                    Car selectedCar = null;

                    // checks  the vehicle in rented Cars
                    for(Car c: rental.getRentalCars()) {
                        if(c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model)){
                            selectedCar = c;
                        }
                    }
                    if (selectedCar != null) {
                        rental.returnVehicle(selectedCar);
                        System.out.print("Vehicle successfully returned a vehicle");
                    }
                    else {
                        System.out.println("Vehicle not found");
                    }
                }
                case 3:{
                    rental.displayInfo();
                    break;
                }
                case 4:{
                    System.out.println("Thank you for using our system");
                    sc.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice. Please try again and choose a option that is listed");

            }
        }
    }
}
