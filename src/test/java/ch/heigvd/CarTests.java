package ch.heigvd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class CarTests {

    private DriversToCar fleet = new DriversToCar();
    private String jsonTest = "";

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
        String plateExcepted;
        fleet.parseJsonToCar();
        List<Car> cars = fleet.getCars();

        //recupere la voiture
        //comparer les champs



    }
}
