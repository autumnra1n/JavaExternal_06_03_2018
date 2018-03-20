package lesson4.homework;

/**
 * Created by Михаил on 20.03.2018.
 */
public class Amfibia extends AbstractVehicle implements IMove, ISwim{

    public Amfibia(int speed) {
       super(speed);
    }

    @Override
    public void move() {

    }

    @Override
    public void swim() {

    }

    @Override
    public String toString() {
        return "Amfibia{" +
                "speed=" + super.getSpeed() +
                '}';
    }

}
