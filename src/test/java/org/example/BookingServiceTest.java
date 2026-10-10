package org.example;
import org.example.Booking;
import org.example.BookingDto;
import org.example.Event;
import org.example.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void createBooking_shouldSaveBooking() {


        User user = new User("Test User");
        Event event = new Event("Concert", "Test event", "Berlin", 100);
        BookingDto dto = new BookingDto(1L, 1L);
        Booking booking = new Booking(user, event);



        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        Booking result = bookingService.createBooking(dto);

        assertNotNull(result);
        verify(bookingRepository).save(any(Booking.class));
    }
}





