package com.example.forsevaApp.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class JobRequests {

    @Id
    private ObjectId id;

    private String userId; // ID of the user who created the job
    private String workerId; // ID of the assigned worker
    private String jobStatus; // Example: "Pending", "In Progress", "Completed"
    private String skill; // Type of work (e.g., plumbing, carpenter)
    private String description; // Optional job description
    private LocalDateTime createdAt; // Timestamp of when the job was created
    private LocalDateTime updatedAt;
}
