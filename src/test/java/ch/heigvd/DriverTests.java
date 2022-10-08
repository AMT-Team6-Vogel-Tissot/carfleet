package ch.heigvd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DriverTests {

    private DriversToCar fleet = new DriversToCar();

    Driver driverReceived;
    private final String ID = "939948325";
    private final String NAME = "Responsable véhicule : Maxime Fontaines";
    private final String PLATE = "GE 4567889";
    private final String COL_1 = "Nom/prénom";
    private final String COL_2 = "Téléphone";
    private final String VAL_1 = "Libre Service";
    private final String VAL_2 = "41276519164";

    @BeforeEach
    void doBeforeEach() {

        var json = String.format("{\"id\":\"%s\",\"name\":\"%s\",\"responsable\":\"%s\"," +
                "\"column_values\":[{\"title\":\"%s\",\"text\":\"%s\"}," + "{\"title\":\"%s\",\"text\":\"%s\"}]}", ID, PLATE, NAME, COL_1, VAL_1, COL_2, VAL_2);

        driverReceived = fleet.parseJsonToDriver(json);

    }

    @Test
    void isTheCreationOfADriverIsCorrect(){

        Map<String,String> mapExcepted = new LinkedHashMap<>();

        mapExcepted.put("id", ID);
        mapExcepted.put("name", PLATE);
        mapExcepted.put("responsable", NAME);

        ArrayList<String> tabDriver = new ArrayList<>(Arrays.asList(driverReceived.getId(), driverReceived.getPlate(), driverReceived.name()));

        Iterator<String> i = tabDriver.iterator();

        for(Map.Entry<String, String> m : mapExcepted.entrySet()){
            assertEquals(m.getValue(), i.next());
        }
    }

    @Test
    void isTheCreationOfColumnValuesIsCorrect(){

        Map<String,String> mapExcepted = new LinkedHashMap<>();

        mapExcepted.put("Nom/prénom", VAL_1);
        mapExcepted.put("Téléphone", VAL_2);

        Iterator<Values> i = driverReceived.getColumnValues().iterator();

        for(Map.Entry<String, String> m : mapExcepted.entrySet()){
            Values val = i.next();
            assertEquals(m.getKey(), val.getTitle());
            assertEquals(m.getValue(), val.getText());
        }

    }
}