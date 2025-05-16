package com.example.meeting_management.repository;

import com.example.meeting_management.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Meeting findByTitle(String title);
}

