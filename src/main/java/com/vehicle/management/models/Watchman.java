package com.vehicle.management.models;



import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Entity
public class Watchman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_number", nullable = false)
    private String vehicleNumber;

    @Column(name = "created_date_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDateTime = LocalDateTime.now(); // Ensure proper initialization


    public Watchman() {
        // Default constructor
    }

    public Watchman(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.createdDateTime = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
