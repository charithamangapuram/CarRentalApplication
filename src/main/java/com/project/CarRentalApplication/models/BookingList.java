package com.project.CarRentalApplication.models;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingList {
    private List<BookingDetails> bookings = new ArrayList<>();

    public List<BookingDetails> getBookings() {
        return bookings;
    }

    public BookingDetails getOnebooking(String bookingId)
    {
        for(BookingDetails book : bookings)
        {
            if(book.getBookingId().equals(bookingId))
            {
                return book;
            }
        }

        return null;
    }


    public void addbooking(BookingDetails book) {
        bookings.add(book);
    }

    public Boolean deletebook(String bookingId){
        Boolean found = Boolean.FALSE;
        List<BookingDetails> bookingDummyList = new ArrayList<>();
        bookingDummyList.addAll(bookings);
        for(BookingDetails book: bookingDummyList)
        {
            if(book.getBookingId().equals(bookingId))
            {
                bookings.remove(book);
                found = Boolean.TRUE;
            }
        }

        return found;
    }

    public Boolean updatebooking(String bookingId,BookingDetails updatedbook)
    {
        Boolean updated = Boolean.FALSE;
        List<BookingDetails> bookings1 = new ArrayList<>(bookings);
        for(BookingDetails book :  bookings1)
        {
            if(book.getBookingId().equals(bookingId))
            {
                bookings.remove(book);
                bookings.add(updatedbook);
                updated = Boolean.TRUE;
            }

        }

        return updated;
    }

    public void addAll(List<BookingDetails> bookingDetailsList)
    {
        bookings.addAll(bookingDetailsList);
    }

    public void deleteAll()
    {
//        for(CarDetails car: cars)
//        {
//            cars.remove(car);
//        } dont write like this. unnecessary time complexity. use as below
        bookings = new ArrayList<>();
    }

}
