package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private BookingService bookingService;


    public BookingController(BookingRepository bookingRepository, UserRepository userRepository, EventRepository eventRepository, BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.bookingService = bookingService;

    }

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;


    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDto dto) {
        if (userRepository.findById(dto.userId).isPresent()) {
            Booking booking = new Booking();
            bookingService.createBooking(dto);
            return ResponseEntity.status(201).body(booking);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getBookings() {
        return ResponseEntity.ok(bookingService.getAll());
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        if (bookingRepository.findById(id).isPresent()) {
            bookingRepository.findById(id).get();
        } else {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(bookingRepository.findById(id).get());
    }

    @DeleteMapping("/bookings/{id}")
    ResponseEntity<Event> deletebooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return ResponseEntity.ok().build();

    }

}





