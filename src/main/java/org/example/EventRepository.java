package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

public interface EventRepository extends JpaRepository<Event,Long> {
}
