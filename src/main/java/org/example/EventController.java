package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            eventRepository.findById(id);
        }
        return ResponseEntity.status(200).build();

    }

    @DeleteMapping("/events/{id}")
    ResponseEntity<Event> deleteEvent(@PathVariable Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            eventRepository.delete(event.get());
        }
        return ResponseEntity.status(404).build();


    }

    @PutMapping("/events/{id}")
    ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event newEvent) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            Event updatedEvent = event.get();
            updatedEvent.setTitle(newEvent.getTitle());
            updatedEvent.setDescription(newEvent.getDescription());
            updatedEvent.setLocation(newEvent.getLocation());
            updatedEvent.setAvailableSeats(newEvent.getAvailableSeats());
            eventRepository.save(updatedEvent);
            return ResponseEntity.status(200).build();
        }
        return  ResponseEntity.status(404).build();
        }
    }
