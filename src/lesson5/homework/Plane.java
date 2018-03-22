package lesson4_5.homework;

/**
 * Created by Михаил on 21.03.2018.
 */
public class Plane extends AbstractVehicle implements IFly {
    private final String name = "Plane";
    private Engine engine;

    static class Fly{
        private final static String DESTINATION = "Poland";
        private static boolean check(int speed) {
            return speed > Engine.Rotor.ROTOR_SPEED;
        }
    }
    class Engine{
        class Rotor extends Engine{
            public Rotor(){
                super();
            }
            private final static int ROTOR_SPEED = 400;
        }
        class Turbo extends Engine{
            public Turbo(){
                super();
            }
            private final static int TURBO_SPEED = 800;
        }
    }

    public Plane(int speed) {
        super(speed);
        if(Fly.check(speed))
            engine = new Engine().new Rotor();
        else
            engine = new Engine().new Turbo();
    }

    @Override
    public void fly() {

    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                "speed='" + super.getSpeed() + '\'' +
                '}';
    }
}
