package ch.heigvd;

import java.util.*;

public class Car {
    private String id;
    private String licensePlate;
    private ArrayList<Values> column_values;

    public Car(String _id, String _licensePlate, ArrayList<Values> _column_values){
        id = _id;
        licensePlate = _licensePlate;
        column_values = _column_values;
    }

    public String getId(){
        return id;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public ArrayList<Values> getColumnValues(){
        return column_values;
    }
}
