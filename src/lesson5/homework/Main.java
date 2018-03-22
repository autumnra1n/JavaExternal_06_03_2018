package lesson4_5.homework;

import java.util.Arrays;

/**
 * Created by Михаил on 20.03.2018.
 */
public class Main {
    public static void main(String[] args) {
//        VehicleArrayFactory vehicleArrayFactory = new VehicleArrayFactory();
//        Sorting sorting = new Sorting();
//        System.out.println(Arrays.toString(sorting.min(vehicleArrayFactory.getVehicleArray(2))));
//        System.out.println(Arrays.toString(sorting.max(vehicleArrayFactory.getVehicleArray(3))));
//        System.out.println(Arrays.toString(sorting.min(vehicleArrayFactory.getVehicleArray(4))));
        Car car = new Car(34,"black");
        car.move();
        car.setColor("white");
    }
}
