package lesson3;

import lesson3.Utils.DynamicVehicleArray;
import lesson3.Utils.Utils;
import lesson3.model.CCar;
import lesson3.model.CPlane;
import lesson3.model.CShip;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Михаил on 15.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        String x = "";
        CPlane plane = new CPlane(13,13,13,13,13);
        CCar cCar = new CCar(3,3,3);
        CShip cShip = new CShip(34,34,2,4,"Kiev");
        DynamicVehicleArray dynamicVehicleArray = new DynamicVehicleArray();
        dynamicVehicleArray.add(new CPlane(13,13,13,13,13),new CShip(34,34,2,4,"Kiev"),new CShip(34,34,2,4,"Kiev"),new CCar(3,3,3));
        System.out.println("1. Vehicle с наибольшей ценой");
        System.out.println("2. Найти механизм год выпуска 2000-2005 с  скоростью выше 150 км\\ч, и наименьшей ценой");
        System.out.println("3. Из Масива Vehicle получить масив Car не старше 5 лет");
        System.out.println("4. Из Масива Vehicle получить масив Ship не старше 5 лет, с  отсортированой ценой по убыванию");
        System.out.println("5. Завершение работы программы");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(!x.equals("5")) {
            try {
                x = reader.readLine();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
            switch (x){
                case "1":
                    System.out.println(Utils.highestPrice(dynamicVehicleArray));
                    break;
                case "2":
                    System.out.println(Utils.lowestPrice(dynamicVehicleArray));
                    break;
                case "3":
                    System.out.println(Utils.youngCars(dynamicVehicleArray));
                    break;
                case "4":
                    System.out.println(Utils.ships(dynamicVehicleArray));
                    break;
            }
        }
    }
}
