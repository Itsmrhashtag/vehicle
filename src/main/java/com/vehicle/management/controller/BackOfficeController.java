package com.vehicle.management.controller;

import com.vehicle.management.models.BackOffice;
import com.vehicle.management.models.Watchman;
import com.vehicle.management.repo.BackOfficeRepo;
import com.vehicle.management.repo.WatchmanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/backoffice")
public class BackOfficeController {

    private final BackOfficeRepo backOfficeTransactionRepo;
    private final WatchmanRepo watchmanRepo;

    @Autowired
    public BackOfficeController(BackOfficeRepo backOfficeTransactionRepo, WatchmanRepo watchmanRepo) {
        this.backOfficeTransactionRepo = backOfficeTransactionRepo;
        this.watchmanRepo = watchmanRepo;
    }

    @PostMapping
    public ResponseEntity<String> createBackOfficeTransaction(@RequestBody BackOffice backOfficeTransaction) {
        try {
            Watchman watchman = watchmanRepo.findById(backOfficeTransaction.getWatchman().getId()).orElse(null);
            if (watchman == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Watchman with id " + backOfficeTransaction.getWatchman().getId() + " not found");
            }
            backOfficeTransaction.setTotalQuantity(backOfficeTransaction.getWeight1kg()+ backOfficeTransaction.getWeight5kg()+backOfficeTransaction.getWeight3kg()+backOfficeTransaction.getWeight500g()+backOfficeTransaction.getWeight10mrp()+backOfficeTransaction.getWeight5rpm());
            backOfficeTransaction.setWatchman(watchman);
            backOfficeTransaction.setAutoGeneratedDateTime(LocalDateTime.now());
            backOfficeTransactionRepo.save(backOfficeTransaction);
            return ResponseEntity.status(HttpStatus.CREATED).body("BackOffice transaction created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create BackOffice transaction");
        }
    }
}
