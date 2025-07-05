package com.project.CarRentalApplication.controller;

import com.project.CarRentalApplication.models.CarDetails;
import com.project.CarRentalApplication.models.CarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarList cars;

    @PostMapping(path = "/addBulk", consumes = "application/json", produces = "application/json")
    public void createCars(@RequestBody List<CarDetails> carDetailsList)
    {
        cars.addAll(carDetailsList);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void createCar(@RequestBody CarDetails car)
    {
        cars.addCar(car);
    }

    @GetMapping("/getAll")
    public List<CarDetails> getAll() {
        return cars.getCars();
    }

    @GetMapping("/get/{car_id}")
    public CarDetails getOne(@PathVariable String car_id) {
        return cars.getOneCar(car_id);
    }

    @DeleteMapping(path="/delete/{car_id}")
    public Boolean deletecar(@PathVariable String car_id)
    {
        return cars.deleteCar(car_id);
    }

    @DeleteMapping(path="/deleteAll")
    public void deleteAllcar()
    {
        cars.deleteAll();
    }

    @PutMapping(path="/update/{car_id}")
    public Boolean updateCar(@PathVariable String car_id, @RequestBody CarDetails updatedCar)
    {
        return cars.updateCar(car_id,updatedCar);
    }

}
