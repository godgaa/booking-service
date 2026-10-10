package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookingRepository extends JpaRepository<Booking,Long> {
    
}
