package ch.heigvd;

import java.util.*;

public class Car {
    private String id;
    private String name;
    private ArrayList<Values> column_values;

    public String getId(){
        return id;
    }

    public String getPlate(){
        return name;
    }

    public ArrayList<Values> getColumnValues(){
        return column_values;
    }
}
