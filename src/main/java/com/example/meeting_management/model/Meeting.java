package com.example.meeting_management.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String date;
    private String time;
    private String description;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "meeting_id")
    private List<Booking> bookings = new ArrayList<>();

    public Meeting(){}

    public Meeting(String title, String date, String time, String description) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getDescription() { return description; }
    public List<Booking> getBookings() { return bookings; }


}
