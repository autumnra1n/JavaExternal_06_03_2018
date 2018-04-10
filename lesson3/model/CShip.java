package lesson3.model;

/**
 * Created by Михаил on 15.03.2018.
 */
public class CShip extends CVehicle {

    private int passengers;
    private String port;

    public CShip(int price, int speed, int year, int passengers, String port) {
        super(price, speed, year);
        this.passengers=passengers;
        this.port=port;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "CShip{" +
                "passengers=" + passengers +
                ", port='" + port + '\'' + ", " +
                super.toString() +
                '}';
    }
}
