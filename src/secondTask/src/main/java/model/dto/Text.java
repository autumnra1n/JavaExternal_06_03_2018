package model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Text {

    private final List<Word> text;

    public Text(){
        text = new ArrayList<>();
    }

    public void addWord(Word word){
        text.add(word);
    }

    public List<Word> getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text=" + text +
                '}';
    }
}
