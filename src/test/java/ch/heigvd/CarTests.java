package ch.heigvd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarTests {

    private DriversToCar fleet = new DriversToCar();

    Car carReceived;
    private final String ID = "939948325";
    private final String NAME = "GE 4567889";
    private final String COL_1 = "Nom/prénom";
    private final String COL_2 = "Téléphone";
    private final String VAL_1 = "Libre Service";
    private final String VAL_2 = "41276519164";

    @BeforeEach
    void doBeforeEach()  {
        var json = String.format("{\"id\":\"%s\",\"name\":\"%s\",\"column_values\":[{\"title\":\"%s\",\"text\":\"%s\"},"
                                        + "{\"title\":\"%s\",\"text\":\"%s\"}]}", ID, NAME, COL_1, VAL_1, COL_2, VAL_2);

        carReceived = fleet.parseJsonToCar(json);
    }

    @Test
    void isTheCreationOfACarIsCorrect(){
        Map<String,String> mapExcepted = new LinkedHashMap<>();

        mapExcepted.put("id", ID);
        mapExcepted.put("name", NAME);

        ArrayList<String> tabDriver = new ArrayList<>(Arrays.asList(carReceived.getId(), carReceived.getPlate()));

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

        Iterator<Values> i = carReceived.getColumnValues().iterator();

        for(Map.Entry<String, String> m : mapExcepted.entrySet()){
            Values val = i.next();
            assertEquals(m.getKey(), val.getTitle());
            assertEquals(m.getValue(), val.getText());
        }

    }

}
