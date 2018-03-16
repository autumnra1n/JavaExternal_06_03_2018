package lesson3.model;

/**
 * Created by Михаил on 15.03.2018.
 */
public class CCar extends CVehicle {

    public CCar(int price, int speed, int year) {
        super(price, speed, year);
    }

    @Override
    public String toString() {
        return "CCar{" + ", " + super.toString();
    }
}
