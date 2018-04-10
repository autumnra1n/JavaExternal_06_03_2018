package model.dto.implementation;

public class Knight {

    private final String name;
    private int protectionScore;
    private int attackScore;

    public Knight(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getProtectionScore() {
        return protectionScore;
    }

    public void setProtectionScore(int protectionScore) {
        this.protectionScore = protectionScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        this.attackScore = attackScore;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                ", protectionScore=" + protectionScore +
                ", attackScore=" + attackScore +
                '}';
    }
}
