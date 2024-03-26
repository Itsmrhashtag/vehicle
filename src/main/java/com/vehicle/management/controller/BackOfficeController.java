package com.vehicle.management.controller;

import com.vehicle.management.models.BackOffice;
import com.vehicle.management.models.Watchman;
import com.vehicle.management.repo.BackOfficeRepo;
import com.vehicle.management.repo.WatchmanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/backoffice")
public class BackOfficeController {

    private final BackOfficeRepo backOfficeRepository;
    private final WatchmanRepo watchmanRepository;

    @Autowired
    public BackOfficeController(BackOfficeRepo backOfficeRepository, WatchmanRepo watchmanRepository) {
        this.backOfficeRepository = backOfficeRepository;
        this.watchmanRepository = watchmanRepository;
    }

    @PostMapping
    public ResponseEntity<String> createBackOfficeTransaction(@RequestBody BackOffice backOffice) {
        // Fetch watchman by vehicle number
        Watchman watchman = watchmanRepository.findByVehicleNumber(backOffice.getWatchman().getVehicleNumber());
        if (watchman == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Watchman with vehicle number " + backOffice.getWatchman().getVehicleNumber() + " not found");
        }

        // Associate the back office transaction with the retrieved watchman
        backOffice.setWatchman(watchman);

        try {
            backOfficeRepository.save(backOffice);
            return ResponseEntity.status(HttpStatus.CREATED).body("BackOffice transaction created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create BackOffice transaction");
        }
    }
}