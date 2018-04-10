package lesson2.homework.utils;

import lesson2.homework.Polygon;
import lesson2.homework.AbstractFigure;

import java.io.*;

/**
 * Created by Михаил on 23.03.2018.
 */
public class Serializer {

    public static void serializeFigures(AbstractFigure... abstractFigure){
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("figures.bin"))){
            ous.writeObject(abstractFigure);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeFigures(String filename, AbstractFigure... figures){
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(filename))){
            ous.writeObject(figures);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Polygon deserializeFigures(String filename){
        int count = 0;
        Polygon polygon = new Polygon();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
                polygon.add((AbstractFigure[]) ois.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Amount of triangles = "+count);
        return polygon;
    }

    public static Polygon deserializeFigures(String... filenames){
        Polygon polygon = new Polygon();
        for(String filename:filenames) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                    polygon.add((AbstractFigure[]) ois.readObject());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return polygon;
    }


    public static Polygon deserializeFigures(){
        Polygon polygon = new Polygon();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("figures.bin"))){
                polygon.add((AbstractFigure[]) ois.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return polygon;
    }
}
