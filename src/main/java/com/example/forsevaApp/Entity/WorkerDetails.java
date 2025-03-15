package com.example.forsevaApp.Entity;

import java.util.List;

public class WorkerDetails {
    private List<String> skills; // List of skills like "plumber", "carpenter", etc.
    private double hourlyRate;
    private boolean availability;
    public WorkerDetails() {}

    public WorkerDetails(List<String> skills, double hourlyRate, boolean availability) {
        this.skills = skills;
        this.hourlyRate = hourlyRate;
        this.availability = availability;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
