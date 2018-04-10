package controller;

import model.dto.Text;
import model.dto.Word;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsController {

    public static Text filter(String input){
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(input);
        Text text = new Text();
        while (matcher.find()){
            text.addWord(new Word(matcher.group()));
        }
        return text;
    }

    private static void vowelsCounter(Text text){
        String temp;
        for(Word word:text.getText()){
            temp = word.getValue();
            word.setVowels(temp.toLowerCase().replaceAll("[^aoiuye]","").length());
        }
    }

    public static Text sortByVowels(Text text){
        vowelsCounter(text);
        text.getText().sort(Comparator.comparingInt(Word::getVowels));
        return text;
    }
}
