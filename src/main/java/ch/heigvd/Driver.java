package ch.heigvd;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    private String id;
    private String plate;
    private String name;
    private Map<String,String> column_values = new HashMap<String, String>();

    public String getId(){
        return id;
    }

    public String getPlate(){
        return plate;
    }

    public String name(){
        return name;
    }

    public Map<String,String> getColumnValues(){
        return column_values;
    }
}
