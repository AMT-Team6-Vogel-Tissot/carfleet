package ch.heigvd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CarTests {

    private DriversToCar fleet = new DriversToCar();
    private String jsonTest = "";
    @Test
    void plateMustBePresent(){
        String plateExcepted;
        fleet.parseJsonToCar();
        List<Car> cars = fleet.getCars();

        //recupere la voiture
        //comparer les champs



    }
}
