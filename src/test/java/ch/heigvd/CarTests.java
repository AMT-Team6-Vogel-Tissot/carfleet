package ch.heigvd;

import com.google.gson.JsonParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarTests {

    private DriversToCar fleet = new DriversToCar();

    Car car;

    @BeforeEach
    void doBeforeEach()  {

        ArrayList<Values> column_values = new ArrayList<>(List.of(
                new Values("Modèle", "Volkswagen California"),
                new Values("Sous-éléments", "Coordonnées du chauffeur"),
                new Values("Nom/prénom", "Schmidt Alain")
        ));

        car = new Car("939948275", "GE 123201", column_values);
    }

    @Test
    void isTheCreationOfACarIsCorrect() throws IOException {
        var json = readFile("car.json");

        Car carReceived = fleet.parseJsonToCar(json);

        assertEquals(car.getId(), carReceived.getId());
        assertEquals(car.getLicensePlate(), carReceived.getLicensePlate());

        var itCar = car.getColumnValues().iterator();
        var itCarReceived = carReceived.getColumnValues().iterator();

        while(itCarReceived.hasNext() || itCar.hasNext()){
            var valDriver = itCar.next();
            var valDriverReceived = itCarReceived.next();

            assertEquals(valDriver.getTitle(), valDriverReceived.getTitle());
            assertEquals(valDriver.getText(), valDriverReceived.getText());
        }
    }

    @Test
    void carEmpty() throws IOException {
        var json = readFile("carEmpty.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToCar(json));
    }

    @Test
    void carWithColumnValuesMissing() throws IOException {
        var json = readFile("carMissingColumnValues.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToCar(json));
    }

    @Test
    void carWithARequiredFieldMissing() throws IOException {
        var json = readFile("carMissingRequiredField.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToCar(json));
    }

    @Test
    void carWithInvalidFieldType() throws IOException {
        var json = readFile("carWithInvalidFieldType.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToCar(json));
    }

    @Test
    void carWithBadStructure() throws IOException {
        var json = readFile("carWithBadStructure.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToCar(json));
    }

    private String readFile(String fileName) throws IOException {
        return Files.readString(Path.of("src/test/resources", fileName));
    }


}
