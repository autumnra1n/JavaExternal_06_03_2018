package model.dto.implementation;

import model.dto.AbstractKnightAmmunition;
import model.dto.IncreaseAttackScore;
import exceptions.InvalidInputsException;

public class Sword extends AbstractKnightAmmunition implements IncreaseAttackScore {

    private final int attackScore;

    public Sword(int attackScore, int price, int weight) throws InvalidInputsException {
        super(price, weight);
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "attackScore=" + attackScore +
                " price=" + super.getPrice() +
                ", weight=" + super.getWeight() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sword sword = (Sword) o;
        return getClass() == sword.getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public void increaseAttackScore(Knight knight) {
        knight.setAttackScore(knight.getAttackScore()+this.attackScore);
    }
}
