package com.vehicle.management.controller;

import com.vehicle.management.models.Watchman;
import com.vehicle.management.repo.WatchmanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/watchman")
public class WatchmanController {

    private final WatchmanRepo watchmanRepository;

    @Autowired
    public WatchmanController(WatchmanRepo watchmanRepository) {
        this.watchmanRepository = watchmanRepository;
    }

    @PostMapping
    public ResponseEntity<String> addWatchman(@RequestBody Watchman watchman) {
        watchman.setCreatedDateTime(LocalDateTime.now());
        watchmanRepository.save(watchman);
        return ResponseEntity.status(HttpStatus.CREATED).body("Watchman added successfully");
    }
    @GetMapping
    public List<Watchman> getAllVehicle(){
        List<Watchman> all=watchmanRepository.findAll();
        Collections.reverse(all);
        return all;
    }
}