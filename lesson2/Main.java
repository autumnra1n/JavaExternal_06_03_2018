package lesson2.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Михаил on 14.03.2018.
 */
public class Main {
    public static void main(String[] args) {
        //Решение первого задания
        Polygon figures = new Polygon();
        figures.add(new Point(12,13));
        figures.add(new Point(13,15));
        figures.add(new Line(new Point(11,5),new Point(20,3)));
        figures.add(new Triangle((new Point(10,2)),new Point(12,10), new Point(22,25)));
        System.out.println(figures);
        //Решение второго задания
        Polygon polygon = new Polygon();
        polygon.add((new Point(10,2)),new Point(12,10), new Point(22,25), new Point(22,25));
        System.out.println("Квадрат " + polygon);
    }
}
