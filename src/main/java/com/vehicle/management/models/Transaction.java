package com.vehicle.management.models;




import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "watchman_id", referencedColumnName = "id", nullable = false)
    private Watchman watchman;

    @Column(name = "net_weight", nullable = false)
    private double netWeight;

    @Column(name = "auto_generated_date_time", nullable = false)
    private LocalDateTime autoGeneratedDateTime = LocalDateTime.now();

    @Column(name = "tare_weight", nullable = false)
    private double tareWeight;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    // Constructors, getters, and setters

    public Transaction() {
    }

    public Transaction(Long id, Watchman watchman, double netWeight, LocalDateTime autoGeneratedDateTime, double tareWeight, TransactionType transactionType) {
        this.id = id;
        this.watchman = watchman;
        this.netWeight = netWeight;
        this.autoGeneratedDateTime = autoGeneratedDateTime;
        this.tareWeight = tareWeight;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Watchman getWatchman() {
        return watchman;
    }

    public void setWatchman(Watchman watchman) {
        this.watchman = watchman;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public LocalDateTime getAutoGeneratedDateTime() {
        return autoGeneratedDateTime;
    }

    public void setAutoGeneratedDateTime(LocalDateTime autoGeneratedDateTime) {
        this.autoGeneratedDateTime = autoGeneratedDateTime;
    }

    public double getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(double tareWeight) {
        this.tareWeight = tareWeight;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}

