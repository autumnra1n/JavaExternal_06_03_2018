package model.factories.implementation;

import model.dto.implementation.Sword;
import exceptions.InvalidInputsException;
import model.factories.AbstractAmmunitionFactory;

public class SwordFactory extends AbstractAmmunitionFactory {

    @Override
    public Sword createNewInstance(int score, int weight, int price) {
        try{
            return new Sword(score, weight, price);
        } catch (InvalidInputsException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println("Check console");
        }
        return null;
    }
}
