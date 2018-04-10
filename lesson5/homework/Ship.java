package lesson4_5.homework;

/**
 * Created by Михаил on 21.03.2018.
 */
public class Ship extends AbstractVehicle implements ISwim {

    private final String name = "Ship";
    private String country;
    private String time;
    private LuxuryLevel luxuryLevel;

    public Ship(int speed) {
        super(speed);
    }

    @Override
    public void swim() {

    }

    class Destination{
        private Destination(){}
        public void setCountry(String country){
            Ship.this.country = country;
        }
        public void setArrivalTime(String time){
            Ship.this.time = time;
        }
    }

    public enum LuxuryLevel{
        ECONOM,
        DEFAULT,
        LUX;

        public static LuxuryLevel fromValue(final String value) {
            if (value.equalsIgnoreCase("econom")){
                return ECONOM;
            } else if (value.equalsIgnoreCase("lux")){
                return LUX;
            } else {
                return DEFAULT;
            }
        }
    }

    public Destination setDestination(){
        return new Destination();
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                "speed='" + super.getSpeed() + '\'' +
                '}';
    }
}
