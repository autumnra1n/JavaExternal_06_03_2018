package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextRepository {

    public static String retriveText(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}
