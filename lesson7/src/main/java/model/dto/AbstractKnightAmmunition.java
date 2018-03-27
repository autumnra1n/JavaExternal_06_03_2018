package model.dto;

import exceptions.InvalidInputsException;

import java.io.Serializable;

public abstract class AbstractKnightAmmunition implements Comparable<AbstractKnightAmmunition>, Serializable {

    private final int price;
    private final int weight;

    public AbstractKnightAmmunition(int price, int weight) throws InvalidInputsException {
        this.checkInputs(price, weight);
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "AbstractKnightAmmunition{" +
                "price=" + price +
                ", weight=" + weight +
                '}';
    }

    public void checkInputs(int price, int weight)throws InvalidInputsException{
        if(price<0||weight<0)
            throw new InvalidInputsException();
    }

    @Override
    public int compareTo(AbstractKnightAmmunition abstractKnightAmmunition){
        return Integer.compare(weight, abstractKnightAmmunition.getWeight());
    }
}


