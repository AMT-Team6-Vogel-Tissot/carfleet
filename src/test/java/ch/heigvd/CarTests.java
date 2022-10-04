package ch.heigvd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class CarTests {

    private DriversToCar fleet = new DriversToCar();


    @BeforeEach
    void doBeforeEach() throws FileNotFoundException {
        String url = "utils\\dataCar.json";
        JsonReader reader = new JsonReader(new InputStreamReader(
                new FileInputStream(url)));
        JsonParser jsonParser = new JsonParser();
        JsonObject userArray = jsonParser.parse(reader).getAsJsonObject();
        System.out.println(userArray);
    }

    @Test
    void plateMustBePresent(){
        String plateExcepted = "GE 123201";
        Car carReceived = fleet.parseJsonToCar();

        assertEquals(plateExcepted,carReceived.getPlate());


    }

    @Test
    void mapMustBeTheSame(){
        Map<String,String> mapExcepted = new HashMap<String, String>();
        mapExcepted.put("Modèle","Volkswagen California");
        mapExcepted.put("Sous-éléments","Coordonnées du chauffeur");
        mapExcepted.put("Nom/prénom","Schmidt Alain");

        Car carReceived = fleet.parseJsonToCar();

        assertEquals(mapExcepted,carReceived.getColumnValues());


    }


}
