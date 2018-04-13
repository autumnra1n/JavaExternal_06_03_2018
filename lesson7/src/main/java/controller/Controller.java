package controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Controller {

    private final Map <String, TreeMap<Integer,String>> result = new HashMap<>();

    public void fillMap(String word,Integer count,String url ){
        TreeMap <Integer, String> map = new TreeMap<>();
        map.put(count,url);
        result.put(word,map);
    }

    public Map getResult(List<String> pathList) {
        for(String p:pathList){
            String pResponse = null;
            try {
                pResponse = readPage(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] words = getWords(pResponse);
            String wordWithCounter = commonWord(words);
            String[] wc=  wordWithCounter.split(":");
            fillMap(wc[0], Integer.valueOf(wc[1]),p);
        }
        return new TreeMap<>(result);
    }

    public List<String> getPath(String path, int urls ){
        int counter=0;
        List <String> url = new ArrayList<>();
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(path).get();
            Elements links = doc.select("a[href]");
            for (Element element:links){
                System.out.println((element.attr("abs:href")));
                url.add(element.attr("abs:href"));
                counter++;
                if(counter==urls)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

    public String readPage(String path) throws IOException {
        URL website = new URL(path);
        URLConnection connection = website.openConnection();
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str=bf.readLine())!=null)
            sb.append(str);
        return sb.toString();
    }

    public String[] getWords(String htmlPage){
        htmlPage= htmlPage.replaceAll("<[^>]*>", "");
        String[] words=  htmlPage.split("['\\w',':','/',',',' -']");
        return words;
    }

    public String commonWord(String[] words ){
        int max=0;
        String word = null;
        int counter=0;
        for (String word2 : words) {
            for (String word1 : words) {
                if (word2.equalsIgnoreCase(word1) && word2.length() > 3) {
                    counter++;
                }
            }
            if (counter > max) {
                max = counter;
                word = word2;
            }
            counter = 0;
        }
        return word+":"+max;
    }
}
