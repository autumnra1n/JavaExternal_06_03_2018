package model.factories;

import model.dto.AbstractKnightAmmunition;

public abstract class AbstractAmmunitionFactory <T> {

    public abstract AbstractKnightAmmunition createNewInstance(int score, int weight, int price);
}
