package ch.heigvd;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DriversToCar {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Driver> drivers  = new ArrayList<>();

    public Car parseJsonToCar(String json){

        Gson gson = new Gson();
        Car car = gson.fromJson(json, Car.class);

        cars.add(car);

        return car;
    }

    public Driver parseJsonToDriver(String json){

        Gson gson = new Gson();
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
