package lesson3.Utils;

import lesson3.model.CVehicle;

import java.util.Arrays;

/**
 * Created by Михаил on 16.03.2018.
 */
public class Utils {
    private final static int YEAR = 2012;

    public static String highestPrice(DynamicVehicleArray vehicles){
        int count = 0;
        int maxPrice = 0;
        for (int i = 0; i<vehicles.getDynamicArray().length; i++){
            if(vehicles.getDynamicArray()[i].getPrice()>maxPrice) {
                maxPrice = vehicles.getDynamicArray()[i].getPrice();
                count = vehicles.getDynamicArray()[i].getPrice();
            }
            else
                return "no vehicle found";
        }
        return (vehicles.getDynamicArray()[count].toString());
    }
    public static String lowestPrice(DynamicVehicleArray vehicles){
        int count = 0;
        int lowestPrice = vehicles.getDynamicArray()[0].getPrice();
        for (int i = 0; i<vehicles.getDynamicArray().length; i++){
            if(vehicles.getDynamicArray()[i].getYear()>=2000&&vehicles.getDynamicArray()[i].getYear()<=2005) {
                if (vehicles.getDynamicArray()[i].getSpeed() > 150) {
                    if (vehicles.getDynamicArray()[i].getPrice() < lowestPrice) {
                        count = i;
                    }
                    else
                        return "no vehicle found";
                }
            }
            else
                return "no vehicle found";
        }
        return vehicles.getDynamicArray()[count].toString();
    }
    public static String youngCars(DynamicVehicleArray vehicles){
        DynamicVehicleArray dynamicVehicleArray = new DynamicVehicleArray();
        boolean exists = false;
        for (int i = 0; i<vehicles.getDynamicArray().length; i++){
            if(vehicles.getDynamicArray()[i].getClass().getName().equals("lesson3.model.CCar")&&vehicles.getDynamicArray()[i].getYear()>YEAR) {
                dynamicVehicleArray.add(vehicles.getDynamicArray()[i]);
                exists = true;
            }
        }
        if(exists){
            return dynamicVehicleArray.toString();
        }
        else {
            return "no car found";
        }
    }

    public static String ships(DynamicVehicleArray vehicles){
        DynamicVehicleArray dynamicVehicleArray = new DynamicVehicleArray();
        boolean exists = false;
        for (int i = 0; i<vehicles.getDynamicArray().length; i++){
            if(vehicles.getDynamicArray()[i].getClass().getName().equals("lesson3.model.CShip")) {
                dynamicVehicleArray.add(vehicles.getDynamicArray()[i]);
                exists = true;
            }
        }
        if(exists){
            CVehicle[] tempArray = dynamicVehicleArray.getDynamicArray();
            for (int j = 0; j < tempArray.length - 1; j++) {
                for (int k = j + 1; k < tempArray.length; k++) {
                    if (tempArray[j].getPrice()<tempArray[k].getPrice()) {
                        CVehicle temp = tempArray[k];
                        tempArray[k] = tempArray[j];
                        tempArray[j] = temp;
                    }
                }
            }
           return Arrays.toString(tempArray);
        }
        else {
            return "no ship found";
        }
    }
}
