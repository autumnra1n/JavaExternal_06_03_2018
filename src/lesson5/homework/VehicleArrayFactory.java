package lesson4_5.homework;

import java.util.Random;

/**
 * Created by Михаил on 20.03.2018.
 */
public class VehicleArrayFactory extends AbstractVehicleArrayFactory {
    private final static int SPEED = 100;
    private final static int ARRAY_RANGE = 20;
    private final static int BAT_CAR = 0;
    private final static int AMFIBIA = 1;

    @Override
    public AbstractVehicle getVehicle(int type) {
        switch (type) {
            case 0: return new BatCar(new Random().nextInt(SPEED));
            case 1: return new Amfibia(new Random().nextInt(SPEED));
            case 2: return new Car(new Random().nextInt(SPEED));
            case 3: return new Plane(new Random().nextInt(SPEED));
            case 4: return new Ship(new Random().nextInt(SPEED));
            default:{
                System.out.println("Enter correct number of a vehicle");

            }
        }
        return null;
    }

    @Override
    public AbstractVehicle[] getVehicleArray(int type) {
        final int n = (int)(Math.random()*ARRAY_RANGE);
        final AbstractVehicle[] abstractVehicles = new AbstractVehicle[n];
        for(int i = 0;i<n;i++){
            abstractVehicles[i]=getVehicle(type);
        }
        return abstractVehicles;
    }
}
