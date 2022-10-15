package ch.heigvd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class DriversToCar {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Driver> drivers  = new ArrayList<>();

    public Car parseJsonToCar(String json){

        Gson gson = new GsonBuilder().registerTypeAdapter(Car.class, new CarGsonDeserializer()).create();
        Car car = gson.fromJson(json, Car.class);

        cars.add(car);

        return car;
    }

    public Driver parseJsonToDriver(String json){

        Gson gson = new GsonBuilder().registerTypeAdapter(Driver.class, new DriverGsonDeserializer()).create();
        Driver driver = gson.fromJson(json, Driver.class);

        drivers.add(driver);

        return driver;
    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    public ArrayList<Driver> getDrivers(){
        return drivers;
    }
}
