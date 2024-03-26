package com.vehicle.management.controller;

import com.vehicle.management.models.Transaction;
import com.vehicle.management.models.Watchman;// Corrected typo in package name
import com.vehicle.management.repo.TransationRepo;
import com.vehicle.management.repo.WatchmanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/transactions")
public class TransactionController {

    private final TransationRepo transactionRepository; // Corrected typo in variable name
    private final WatchmanRepo watchmanRepository;

    @Autowired
    public TransactionController(TransationRepo transactionRepository, WatchmanRepo watchmanRepository) { // Corrected typo in parameter name
        this.transactionRepository = transactionRepository;
        this.watchmanRepository = watchmanRepository;
    }

    @PostMapping
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {
        System.out.println(transaction.getWatchman());
        try {
            // Check if Watchman exists
            Watchman watchman = watchmanRepository.findById(transaction.getWatchman().getId()).orElse(null); // Added .orElse(null) to handle optional

            if (watchman == null) {
                // Create a new Watchman entity if it doesn't exist
                watchman = new Watchman(transaction.getWatchman().getVehicleNumber());
                watchmanRepository.save(watchman);
            }

            // Set the Watchman in the Transaction
            transaction.setWatchman(watchman);

            transactionRepository.save(transaction);
            return ResponseEntity.status(HttpStatus.CREATED).body("Transaction created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create transaction");
        }
    }
}
