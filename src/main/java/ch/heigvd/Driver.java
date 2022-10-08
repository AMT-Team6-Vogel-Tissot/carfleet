package ch.heigvd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    private String id;
    private String name;
    private String responsable;

    private ArrayList<Values> column_values;

    public String getId(){
        return id;
    }

    public String getPlate(){
        return name;
    }

    public String name(){
        return responsable;
    }

    public ArrayList<Values> getColumnValues(){
        return column_values;
    }
}
