package ch.heigvd;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FleetIntegrationTests {

    private DriversToCar fleet = new DriversToCar();

    @Test
    void createFleet() throws IOException {

        var json = readFile("car.json");
        var json2 = readFile("driver.json");

        for(int i = 0; i < 3; ++i){
            Car carReceived = fleet.parseJsonToCar(json);
            Driver driverReceived = fleet.parseJsonToDriver(json2);
        }

        assertEquals(3,fleet.getCars().size());
        assertEquals(3,fleet.getDrivers().size());

        fleet.parseJsonToCar(json);
        assertEquals(4,fleet.getCars().size());

    }

    private String readFile(String fileName) throws IOException {
        return Files.readString(Path.of("src/test/resources", fileName));
    }

}
