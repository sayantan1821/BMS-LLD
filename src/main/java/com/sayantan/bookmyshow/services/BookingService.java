package com.sayantan.bookmyshow.services;

import com.sayantan.bookmyshow.models.*;
import com.sayantan.bookmyshow.repositories.BookingRepository;
import com.sayantan.bookmyshow.repositories.ShowRepository;
import com.sayantan.bookmyshow.repositories.ShowSeatRepository;
import com.sayantan.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;
    private final PriceCalculatorService priceCalculatorService;
    BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository,
                   ShowRepository showRepository, BookingRepository bookingRepository,
                   PriceCalculatorService priceCalculatorService) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculatorService = priceCalculatorService;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(long userId, List<Long> seatIds, long showId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty())
            throw new RuntimeException("User not found");
        User bookedBy = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty())
            throw new RuntimeException("Show not found");
        Show bookedShow = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(seatIds);
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) &&
                showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) &&
                    Duration.between(showSeat.getLockedAt().toInstant(),
                            new Date().toInstant()).toMinutes() > 15)
                throw new RuntimeException("Seats are not available");
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }
        Booking booking = new Booking();
        booking.setBookedAt(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShow(bookedShow);
        booking.setUser(bookedBy);
        booking.setAmount(priceCalculatorService.caculatePrice(savedShowSeats, bookedShow));
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(savedShowSeats);

        booking = bookingRepository.save(booking);
        return booking;
    }
}
