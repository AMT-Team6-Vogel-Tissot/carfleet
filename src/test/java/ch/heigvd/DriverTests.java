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

        var json = String.format("{\"id\":\"%s\",\"name\":\"%s\",\"subitems\":[{\"name\":\"%s\"," +
                "\"column_values\":[{\"title\":\"%s\",\"text\":\"%s\"}," + "{\"title\":\"%s\",\"text\":\"%s\"}]}]}", ID, PLATE, NAME, COL_1, VAL_1, COL_2, VAL_2);

        driverReceived = fleet.parseJsonToDriver(json);

    }

    @Test
    void isTheCreationOfADriverIsCorrect(){

        Map<String,String> mapExcepted = new HashMap<>();

        mapExcepted.put("id", ID);
        mapExcepted.put("plate", PLATE);
        mapExcepted.put("name", NAME);

        ArrayList<String> tabDriver = new ArrayList<>(Arrays.asList(driverReceived.getId(), driverReceived.getPlate(), driverReceived.name()));

        Iterator<String> i = tabDriver.iterator();

        for(Map.Entry<String, String> m : mapExcepted.entrySet()){
            assertEquals(m.getValue(), i.next());
        }
    }

    @Test
    void isTheCreationOfColumnValuesIsCorrect(){

        Map<String,String> mapExcepted = new HashMap<>();

        mapExcepted.put("Nom/prénom", VAL_1);
        mapExcepted.put("Téléphone", VAL_2);

        assertEquals(mapExcepted, driverReceived.getColumnValues());

    }
}