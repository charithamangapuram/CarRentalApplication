package com.project.CarRentalApplication.controller;

import com.project.CarRentalApplication.models.BookingDetails;
import com.project.CarRentalApplication.models.BookingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bookings")
public class BookingController {

    @Autowired
    BookingList bookings;

    @PostMapping(path = "/addBulk", consumes = "application/json", produces = "application/json")
    public void createbookings(@RequestBody List<BookingDetails> bookingDetailsList)
    {
        bookings.addAll(bookingDetailsList);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void createCar(@RequestBody BookingDetails book)
    {
        bookings.addbooking(book);
    }

    @GetMapping("/getAll")
    public List<BookingDetails> getAll() {
        return bookings.getBookings();
    }

    @GetMapping("/get/{bookingId}")
    public BookingDetails getOne(@PathVariable String bookingId) {
        return bookings.getOnebooking(bookingId);
    }

    @DeleteMapping(path="/delete/{bookingId}")
    public Boolean deletebooking(@PathVariable String bookingId)
    {
        return bookings.deletebook(bookingId);
    }

    @DeleteMapping(path="/deleteAll")
    public void deleteAllbookings()
    {
        bookings.deleteAll();
    }

    @PutMapping(path="/update/{bookingId}")
    public Boolean updateCar(@PathVariable String bookingId, @RequestBody BookingDetails updatedbooking)
    {
        return bookings.updatebooking(bookingId,updatedbooking);
    }

}
