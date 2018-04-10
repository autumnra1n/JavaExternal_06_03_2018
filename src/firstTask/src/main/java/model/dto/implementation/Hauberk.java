package model.dto.implementation;

import model.dto.AbstractKnightAmmunition;
import model.dto.IncreaseProtectionScore;
import exceptions.InvalidInputsException;

public class Hauberk extends AbstractKnightAmmunition implements IncreaseProtectionScore {

    private final int protectScore;

    public Hauberk(int protectScore, int weight, int price) throws InvalidInputsException{
        super(price, weight);
        this.protectScore = protectScore;
    }

    public int getProtectScore() {
        return protectScore;
    }

    @Override
    public String toString() {
        return "Hauberk{" +
                "protectScore=" + protectScore +
                " price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hauberk hauberk = (Hauberk) o;
        return getClass() == hauberk.getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public void increaseProtectionScore(Knight knight) {
        knight.setProtectionScore(knight.getProtectionScore()+this.protectScore);
    }
}
