package lesson4_5.homework;

/**
 * Created by Михаил on 20.03.2018.
 */
public abstract class AbstractVehicleArrayFactory {

    public abstract AbstractVehicle getVehicle(int type);
    public abstract AbstractVehicle[] getVehicleArray(int type);
}
