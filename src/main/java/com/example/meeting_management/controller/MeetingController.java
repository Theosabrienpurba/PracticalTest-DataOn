package com.example.meeting_management.controller;


import com.example.meeting_management.model.Booking;
import com.example.meeting_management.model.Meeting;
import com.example.meeting_management.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MeetingController {

    @Autowired
    private MeetingRepository meetingRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/meetings";
    }

    @GetMapping("/meetings")
    public String listMeetings(Model model) {
        model.addAttribute("meetings", meetingRepository.findAll());
        return "meetings";
    }

    @PostMapping("/book")
    public String bookMeeting(@RequestParam String meetingTitle,
                              @RequestParam String name,
                              @RequestParam String email) {
        Meeting meeting = meetingRepository.findByTitle(meetingTitle);
        if (meeting != null) {
            meeting.addBooking(new Booking(name, email));
            meetingRepository.save(meeting);
        }
        return "redirect:/meetings";
    }
    @PostMapping("/create-meeting")
    public String createMeeting(@RequestParam String title,
                                @RequestParam String date,
                                @RequestParam String time,
                                @RequestParam String description) {
        Meeting meeting = new Meeting(title, date, time, description);
        meetingRepository.save(meeting);
        return "redirect:/meetings";
    }

    @PostMapping("/approve")
    public String approveBooking(@RequestParam String meetingTitle,
                                 @RequestParam String email) {
        Meeting meeting = meetingRepository.findByTitle(meetingTitle);
        if (meeting != null) {
            meeting.getBookings().stream()
                    .filter(b -> b.getEmail().equals(email))
                    .findFirst().ifPresent(b -> b.setApproved(true));
            meetingRepository.save(meeting);
        }
        return "redirect:/meetings";
    }
}
