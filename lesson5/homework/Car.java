package lesson4_5.homework;

/**
 * Created by Михаил on 21.03.2018.
 */
public class Car extends AbstractVehicle implements IMove {

    private static final String NAME = "Car";
    private Color color;
    private StringBuffer buffer = new StringBuffer();

    public Car(int speed, String choosenColor) {
        super(speed);
        this.color = Color.fromValue(choosenColor);
        buffer.append(choosenColor);
    }

    public Car(int speed){
        super(speed);
    }

    public enum Color{
        BLACK,
        WHITE,
        RED,
        BLUE,
        DEFAULT;

        public static Color fromValue(final String value) {
            if (value.equalsIgnoreCase("black")){
                return BLACK;
            } else if (value.equalsIgnoreCase("white")){
                return WHITE;
            } else if (value.equalsIgnoreCase("red")){
                return RED;
            } else if (value.equalsIgnoreCase("blue")){
                return BLUE;
            } else {
                return DEFAULT;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String color) {
        class Monitoring{
            Monitoring(String color){
                buffer.append(", ");
                buffer.append(color);
            }
            String getLog(){
                return buffer.toString();
            }
        }
        Monitoring monitoring = new Monitoring(color);
        System.out.println("Car's colors: "+monitoring.getLog());
        this.color = Color.fromValue(color);
    }

    @Override
    public void move() {
        System.out.println(NAME+"'s current speed is "+ super.getSpeed()+", color is " +this.color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + NAME + '\'' +
                "speed='" + super.getSpeed() + '\'' +
                "color='" + this.color + '\'' +
                '}';
    }

}
