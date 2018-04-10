package model.factories.implementation;

import model.dto.implementation.Hauberk;
import exceptions.InvalidInputsException;
import model.factories.AbstractAmmunitionFactory;

public class HauberkFactory extends AbstractAmmunitionFactory {

    @Override
    public Hauberk createNewInstance(int score, int weight, int price) {
        try{
            return new Hauberk(score, weight, price);
        } catch (InvalidInputsException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println("Check console");
        }
        return null;
    }
}
