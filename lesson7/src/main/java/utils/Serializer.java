package utils;

import model.dto.AbstractKnightAmmunition;

import java.io.*;

public class Serializer {

    public static void serialize(String filename, AbstractKnightAmmunition...abstractKnightAmmunition){
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(filename))){
            ous.writeObject(abstractKnightAmmunition);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AbstractKnightAmmunition[] deserialize(String filename){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            AbstractKnightAmmunition[] abstractKnightAmmunition =  (AbstractKnightAmmunition[]) ois.readObject();
            return abstractKnightAmmunition;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
