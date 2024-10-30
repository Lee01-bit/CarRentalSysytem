    import java.util.Scanner;

public class CarRental {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SystemRental rental = new SystemRental();

        Vehicles currentSelectedCar = null;

        SpecificCar car = new SpecificCar("Toyota", "Supra", 2020, 120,2,false,"Petrol");
        SpecificCar car1 = new SpecificCar("Audi", "R8", 2020, 200,2,true,"Diesel");
        SpecificCar motorcycles = new SpecificCar("Bmw", "S1000", 2008, 100,0,false,"petrol");

        rental.addCar(car);
        rental.addCar(car1);
        rental.addCar(motorcycles);

        while (true) {
            System.out.println();
            System.out.println("===Car Rental System===");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. Display current Rented vehicle");
            System.out.println("4. Display Rental Information");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");


            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:{
                    //Rents a Car
                    System.out.print("Enter the vehicle make: ");
                    String make = sc.nextLine();
                    System.out.print("Enter the vehicle model: ");
                    String model = sc.nextLine();

                    SpecificCar selectedSpecificCar = null;


                    // check for available vehicles
                    for(SpecificCar vc: SystemRental.getAvailableCars()) {
                        if(vc.getMake().equalsIgnoreCase(make) && vc.getModel().equalsIgnoreCase(model)){
                            selectedSpecificCar = vc;
                        }
                    }

                    if (selectedSpecificCar != null) {
                        // add the vehicle to rented vehicle
                        rental.rentVehicle(selectedSpecificCar);
                        System.out.print("Enter the rental duration in days: ");

                        int rentDuration = sc.nextInt();
                        if (rentDuration >= 0) {

                        double rc = rental.rentalCost(selectedSpecificCar, rentDuration);
                        System.out.println("Successfully rent a vehicle");
                        System.out.println("Rental cost: " + rc);


                    currentSelectedCar = selectedSpecificCar;

                    }
                    else {
                        System.out.println("Vehicle not found");
                    }
                break;
                }}
                case 2:{
                    //returns a  Car
                    System.out.print("Enter the vehicle make: ");
                    String make = sc.nextLine();
                    System.out.print("Enter the vehicle model: ");
                    String model = sc.nextLine();
                    SpecificCar selectedSpecificCar = null;

                    // checks  the vehicle in rented Cars
                    for(SpecificCar c: rental.getRentalCars()) {
                        if(c.getMake().equalsIgnoreCase(make) && c.getModel().equalsIgnoreCase(model)){
                            selectedSpecificCar = c;
                        }
                    }
                    if (selectedSpecificCar != null) {
                        rental.returnVehicle(selectedSpecificCar);
                        System.out.print("Vehicle successfully returned");
                        if (currentSelectedCar == selectedSpecificCar){
                            currentSelectedCar = null ;
                        }
                    }
                    else {
                        System.out.println("Vehicle not found");
                    }
                    break;
                }
                case 3:{
                    if (currentSelectedCar != null){
                        System.out.print("You are currently renting: ");
                        currentSelectedCar.displayInfo();
                    }
                    else {
                        System.out.println("You are not currently renting");

                    }
                    break;

                }
                case 4:{
                    rental.displayInfo();
                }break;
                case 5:{
                    System.out.println("Thank you for using our system , Goodbye!");
                    sc.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice. Please try again and choose a option that is listed");

            }
        }
    }
}
