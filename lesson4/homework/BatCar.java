package lesson4.homework;

/**
 * Created by Михаил on 20.03.2018.
 */
public class BatCar extends AbstractVehicle implements IFly, ISwim, IMove{

    public BatCar(int speed) {
       super(speed);
    }


    @Override
    public void fly() {
        System.out.println("I fly");
    }

    @Override
    public void move() {
        System.out.println("I move");
    }

    @Override
    public void swim() {
        System.out.println("I swim");
    }

    @Override
    public String toString() {
        return "BatCar{" +
                "speed=" + super.getSpeed() +
                '}';
    }

}
