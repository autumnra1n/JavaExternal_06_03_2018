package lesson4.homework;

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
            default:{
                System.out.println("Enter Human");

            }
        }
        return null;
    }

    @Override
    public AbstractVehicle[] getVehicleArray(Class aclass) {
        final int n = (int)(Math.random()*ARRAY_RANGE);
        final AbstractVehicle[] abstractVehicles = new AbstractVehicle[n];
        if(aclass.isAssignableFrom(Amfibia.class)&&aclass.isAssignableFrom(BatCar.class)){
            for(int i = 0;i<n;i++){
                abstractVehicles[i]=getVehicle(new Random().nextInt(2));
            }
        }
        if(aclass.isAssignableFrom(Amfibia.class)&&!aclass.isAssignableFrom(BatCar.class)){
            for(int i = 0;i<n;i++){
                abstractVehicles[i]=getVehicle(AMFIBIA);
            }
        }
        if(aclass.isAssignableFrom(BatCar.class)&&!aclass.isAssignableFrom(Amfibia.class)){
            for(int i = 0;i<n;i++){
                abstractVehicles[i]=getVehicle(BAT_CAR);
            }
        }
        return abstractVehicles;
    }
}
