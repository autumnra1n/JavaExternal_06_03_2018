package lesson4.homework;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Михаил on 20.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        VehicleArrayFactory vehicleArrayFactory = new VehicleArrayFactory();
        Sorting sorting = new Sorting();
        System.out.println(Arrays.toString(sorting.max(vehicleArrayFactory.getVehicleArray(IFly.class))));
        System.out.println(Arrays.toString(sorting.min(vehicleArrayFactory.getVehicleArray(IMove.class))));
    }
}
