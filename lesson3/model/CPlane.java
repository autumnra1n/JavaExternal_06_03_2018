package lesson3.model;

/**
 * Created by Михаил on 15.03.2018.
 */
public class CPlane extends CVehicle {

    private int height;
    private int passengers;

    public CPlane(int price, int speed, int year, int height, int passengers) {
        super(price, speed, year);
        this.height = height;
        this.passengers = passengers;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "CPlane{" +
                "height=" + height +
                ", passengers=" + passengers + ", " +
                super.toString() +
                '}';
    }
}
