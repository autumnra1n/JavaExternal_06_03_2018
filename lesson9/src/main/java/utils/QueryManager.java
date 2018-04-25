package utils;

import java.util.ResourceBundle;

public class QueryManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("mySqlQuery");

    private QueryManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}

