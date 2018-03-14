package lesson2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Михаил on 14.03.2018.
 */
public class Polygon {

    private List<Point> figures = new ArrayList<>();

    public Polygon(Point... points) {
        this.figures = Arrays.asList(points);
    }

    public Polygon(){

    }

    public void generateFigure(Point... points){
        figures = Arrays.asList(points);
    }

    public List<Point> getFigures() {
        return figures;
    }

    public void setFigures(List<Point> figures) {
        this.figures = figures;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "figures=" + figures +
                '}';
    }
}
