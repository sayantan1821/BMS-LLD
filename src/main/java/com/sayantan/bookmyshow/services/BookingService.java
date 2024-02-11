package com.sayantan.bookmyshow.services;

import com.sayantan.bookmyshow.models.Booking;
import com.sayantan.bookmyshow.models.ShowSeat;
import com.sayantan.bookmyshow.models.User;
import com.sayantan.bookmyshow.repositories.ShowSeatRepository;
import com.sayantan.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;
    BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(long userId, List<Long> seatIds, long showId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        List<ShowSeat> showSeats = showSeatRepository.findAllById(seatIds);
        return null;
    }
}
