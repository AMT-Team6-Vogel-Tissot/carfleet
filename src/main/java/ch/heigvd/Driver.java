package ch.heigvd;

import java.util.ArrayList;

public class Driver {
    private String id;
    private String licensePlate;
    private String responsable;

    private ArrayList<Values> column_values;

    public Driver(String _id, String _licensePlate, String _responsable, ArrayList<Values> _column_values){
        id = _id;
        licensePlate = _licensePlate;
        responsable = _responsable;
        column_values = _column_values;
    }

    public String getId(){
        return id;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public String getResponsable(){
        return responsable;
    }

    public ArrayList<Values> getColumnValues(){
        return column_values;
    }
}
