package com.sayantan.bookmyshow.controllers;

import com.sayantan.bookmyshow.dto.BookMovieRequestDTO;
import com.sayantan.bookmyshow.dto.BookMovieResponseDTO;
import com.sayantan.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;
    @Autowired
    BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO bookMovieRequestDTO) {
        return null;
    }
}
