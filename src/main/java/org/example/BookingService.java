package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookingService {
    private UserRepository userRepository;
    private BookingRepository bookingRepository;
    private EventRepository eventRepository;

    BookingService(UserRepository userRepository, BookingRepository bookingRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
    }


    public Booking createBooking(BookingDto Dto) {
        User user = userRepository.findById(Dto.userId).orElse(null);
        Event event = eventRepository.findById(Dto.eventId).orElse(null);
        Booking booking = new Booking(user, event);
        return bookingRepository.save(booking);

    }



    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
}
