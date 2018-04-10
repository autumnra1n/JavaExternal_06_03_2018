package model.dto;

public class Word {

    private String value;
    private int vowels;

    public int getVowels() {
        return vowels;
    }

    public void setVowels(int vowels) {
        this.vowels = vowels;
    }

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                ", vowels=" + vowels +
                '}';
    }
}
