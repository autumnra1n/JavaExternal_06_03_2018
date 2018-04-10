package lesson3.model;

/**
 * Created by Михаил on 15.03.2018.
 */
public abstract class CVehicle {

    private int price;
    private int speed;
    private int year;

    public CVehicle(){}

    public CVehicle(int price, int speed, int year) {
        this.price = price;
        this.speed = speed;
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  "price=" + price +
                ", speed=" + speed +
                ", year=" + year +
                '}';
    }
}
