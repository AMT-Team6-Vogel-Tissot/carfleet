package ch.heigvd;

import com.google.gson.JsonParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DriverTests {

    private DriversToCar fleet = new DriversToCar();
    Driver driver;

    @BeforeEach
    void doBeforeEach() {

        ArrayList<Values> column_values = new ArrayList<>(List.of(
                new Values("Nom/prénom", "Libre Service"),
                new Values("Téléphone", "41276519164"),
                new Values("E-mail", "m.fontainesd@lift.ch")
        ));

        driver = new Driver("939948325", "GE 4567889", "Responsable véhicule : Maxime Fontaines", column_values);
    }

    @Test
    void isTheCreationOfADriverIsCorrect() throws IOException {

        var json = readFile("driver.json");

        Driver driverReceived = fleet.parseJsonToDriver(json);

        assertEquals(driver.getId(), driverReceived.getId());
        assertEquals(driver.getLicensePlate(), driverReceived.getLicensePlate());
        assertEquals(driver.getResponsable(), driverReceived.getResponsable());

        var itDriver = driver.getColumnValues().iterator();
        var itDriverReceived = driverReceived.getColumnValues().iterator();

        while(itDriverReceived.hasNext() || itDriver.hasNext()){
            var valDriver = itDriver.next();
            var valDriverReceived = itDriverReceived.next();

            assertEquals(valDriver.getTitle(), valDriverReceived.getTitle());
            assertEquals(valDriver.getText(), valDriverReceived.getText());
        }

    }
    @Test
    void driverEmpty() throws IOException {
        var json = readFile("driverEmpty.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToDriver(json));
    }

    @Test
    void driverWithColumnValuesMissing() throws IOException {
        var json = readFile("driverMissingColumnValues.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToDriver(json));
    }

    @Test
    void driverWithARequiredFieldMissing() throws IOException {
        var json = readFile("driverMissingRequiredField.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToDriver(json));
    }

    @Test
    void driverWithInvalidFieldType() throws IOException {
        var json = readFile("driverWithInvalidFieldType.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToDriver(json));
    }

    @Test
    void driverWithBadStructure() throws IOException {
        var json = readFile("driverWithBadStructure.json");

        assertThrows(JsonParseException.class, () -> fleet.parseJsonToDriver(json));
    }

    private String readFile(String fileName) throws IOException {
        return Files.readString(Path.of("src/test/resources", fileName));
    }

}