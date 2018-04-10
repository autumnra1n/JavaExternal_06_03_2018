package lesson4.homework;

/**
 * Created by Михаил on 20.03.2018.
 */
public abstract class AbstractVehicle implements Comparable<AbstractVehicle> {

    private final int speed;

    public AbstractVehicle(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "AbstractVehicle{" +
                "speed=" + speed +
                '}';
    }

    @Override
    public int compareTo(AbstractVehicle o) {
        if(this.getSpeed()<o.getSpeed()){
            return -1;
        }
        else if(this.getSpeed()>o.getSpeed()){
            return 1;
        }
        else
            return 0;
    }
}
