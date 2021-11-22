package sdp.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sdp.example.vehicle.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    private static final Logger logger = LogManager.getLogger();
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void init() {
        vehicles.add(new Car("Porsche", 340));
        vehicles.add(new Car("Tesla", 250));

        vehicles.add(new Ship("Hyundai", 50));
        vehicles.add(new Ship("Mitsubishi", 60));

        vehicles.add(new Bicycle("Trek", 53));
        vehicles.add(new Bicycle("Giant", 48));

        vehicles.add(new Plane("Boeing", 850));
        vehicles.add(new Plane("Airbus", 790));

    }

    public static void main(String[] args) {

        init();
        Scanner in = new Scanner(System.in);

        while (true) {
            logger.info("Choose option (CAR, SHIP, PLANE, BICYCLE, ALL, EXIT):");
            String userChoice = in.nextLine();

            switch (userChoice.toLowerCase()) {
                case "car":
                case "ship":
                case "bicycle":
                case "plane":
                case "all":
                    Stream<Vehicle> vehicleStream = vehicles.stream();
                    if (!userChoice.equalsIgnoreCase("all"))
                        vehicleStream = vehicleStream.filter(vehicle -> vehicle.getClass().getSimpleName().equalsIgnoreCase(userChoice));

                    vehicleStream.sorted((vehicle1, vehicle2) -> -Double.compare(vehicle1.getMaxSpeed(), vehicle2.getMaxSpeed()))
                            .limit(1)
                            .forEach(App::logFastestVehicle);
                    break;
                case "exit":
                    return;
                default:
                    logger.error("Invalid option. Choose correct one.");
                    break;
            }
        }


    }

    public static void logFastestVehicle(Vehicle vehicle) {
        logger.info("Vehicle {} of the manufacturer {} is the fastest (the maximum speed is {})",
                vehicle.getClass().getSimpleName().toUpperCase(),
                vehicle.getManufacturer(),
                vehicle.getMaxSpeed());
    }


}
