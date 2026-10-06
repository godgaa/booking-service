package org.example;
import jakarta.persistence.*;


@Entity
@Table (name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
    private String description;
    private String location;
    private Integer availableSeats;




    protected Event() {
    }
            public Event( String title, String description, String location, Integer availableSeats) {
            this.title = title;
            this.description = description;
            this.location = location;
            this.availableSeats = availableSeats;
        }


    }

