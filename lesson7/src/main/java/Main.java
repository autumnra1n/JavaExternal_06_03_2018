package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        List<String> pathList = controller.getPath("https://ru.wikipedia.org/",20);
        System.out.println(controller.getResult(pathList).toString());
    }
}
