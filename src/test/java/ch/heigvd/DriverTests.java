package ch.heigvd;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTests {

    private DriversToCar fleet = new DriversToCar();
    @BeforeEach
    void doBeforeEach() throws FileNotFoundException {
        String url = "utils\\dataDriver.json";
        JsonReader reader = new JsonReader(new InputStreamReader(
                new FileInputStream(url)));
        JsonParser jsonParser = new JsonParser();
        JsonObject userArray = jsonParser.parse(reader).getAsJsonObject();
        System.out.println(userArray);
    }
    @Test
    void plateMustBePresent(){
        String plateExcepted = "GE 4567889";
        Driver driverReceived = (Driver) fleet.parseJsonToDriver();

        assertEquals(plateExcepted,driverReceived.getPlate());
    }



    @Test
    void mapMustBeTheSame(){
        Map<String,String> mapExcepted = new HashMap<String, String>();
        mapExcepted.put("Nom/prénom","Libre Service");
        mapExcepted.put("Téléphone","41276519164");
        mapExcepted.put("E-mail","m.fontainesd@lift.ch");


        Driver driverReceived = (Driver) fleet.parseJsonToDriver();

        assertEquals(mapExcepted,driverReceived.getColumnValues());


    }
}
