package com.project.CarRentalApplication.models;

import com.project.CarRentalApplication.controller.AvailbleCarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class CarList {
    @Autowired
    BookingList bookingList;

    private List<CarDetails> cars = new ArrayList<>();

    public List<CarDetails> getCars() {
        return cars;
    }

    public CarDetails getOneCar(String car_id)
    {
        for(CarDetails car : cars)
        {
            if(car.getCar_id().equals(car_id))
            {
                return car;
            }
        }

        return null;
    }


    public void addCar(CarDetails car) {
        cars.add(car);
    }

    public Boolean deleteCar(String car_id){
        Boolean found = Boolean.FALSE;
        List<CarDetails> carDummyList = new ArrayList<>();
        carDummyList.addAll(cars);
        for(CarDetails car: carDummyList)
        {
            if(car.getCar_id().equals(car_id))
            {
                cars.remove(car);
                found = Boolean.TRUE;
            }
        }

        return found;
    }

    public Boolean updateCar(String car_id,CarDetails updatedCar)
    {
        Boolean updated = Boolean.FALSE;
        for(CarDetails car :  cars)
        {
            if(car.getCar_id().equals(car_id))
            {
                cars.remove(car);
                cars.add(updatedCar);
                updated = Boolean.TRUE;
            }

        }

        return updated;
    }

    public void addAll(List<CarDetails> carDetailsList)
    {
        cars.addAll(carDetailsList);
    }

    public void deleteAll()
    {
//        for(CarDetails car: cars)
//        {
//            cars.remove(car);
//        } dont write like this. unnecessary time complexity. use as below


        cars = new ArrayList<>();
    }
    public List<CarDetails> getAvailableCars(String city, Date pickupDate,Date dropoffDate){
       List<BookingDetails> bookings = bookingList.getBookings();
       List<String> bookedCarIds = new ArrayList<>();
       for(BookingDetails booking : bookings){
           if(booking.getCity().equals(city))
           {
               if((booking.getPickupDate().after(pickupDate) && booking.getPickupDate().before(dropoffDate))
                       || (booking.getDropOffDate().after(pickupDate))&& (booking.getDropOffDate().before(dropoffDate))
                       || (booking.getPickupDate().before(pickupDate) && booking.getDropOffDate().after(dropoffDate)))
               {
                   bookedCarIds.add(booking.getCarId());
               }
           }
       }

       List<CarDetails> notAvailableCars = new ArrayList<>();
       for(String bookedCarId : bookedCarIds)
       {
           CarDetails carDetails = getOneCar(bookedCarId);
           notAvailableCars.add(carDetails);
       }
        List<CarDetails> availableCars = new ArrayList<>(cars);
       availableCars.removeAll(notAvailableCars);

       List<CarDetails> availableCars1 = availableCars.stream().filter(car->car.getCity().equals(city)).toList();

       return availableCars1;

    }

}
