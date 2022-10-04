package ch.heigvd;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private int id;
    private String plate;
    private Map<String,String> column_values = new HashMap<String, String>();

    public int getId(){
        return id;
    }

    public String getPlate(){
        return plate;
    }

    public Map<String,String> getColumnValues(){
        return column_values;
    }
}
