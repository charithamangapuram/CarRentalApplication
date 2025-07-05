package com.project.CarRentalApplication.controller;

import com.project.CarRentalApplication.models.CarDetails;
import com.project.CarRentalApplication.models.CarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/AvailableCars")

public class AvailbleCarController {
    @Autowired
    CarList availbleCars;

    @GetMapping("/get/{city}/{pickupDate}/{dropOffDate}")
    public List< CarDetails> getAvailableCars(@PathVariable String city,
                                              @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date pickupDate,
                                              @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dropOffDate) {
        return availbleCars.getAvailableCars(city,pickupDate,dropOffDate);
    }


}
