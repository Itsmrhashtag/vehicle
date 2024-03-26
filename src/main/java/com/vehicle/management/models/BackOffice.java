package com.vehicle.management.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BackOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double advanceFreight;
    @Column(name = "auto_generated_date_time", nullable = false)
    private LocalDateTime autoGeneratedDateTime = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watchman_id", referencedColumnName = "id", nullable = false)
    private Watchman watchman;
    private String transporterName;
    private int weight5kg;
    private int weight3kg;
    private int weight1kg;
    private int weight500g;
    private int weight10mrp;
    private int weight5rpm;

    private int tubQuantity;
    private int bucketQuantity;
    private int daliyaQuantity;

    public BackOffice() {
    }



    public Watchman getWatchman() {
        return watchman;
    }

    public void setWatchman(Watchman watchman) {
        this.watchman = watchman;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAdvanceFreight() {
        return advanceFreight;
    }

    public void setAdvanceFreight(double advanceFreight) {
        this.advanceFreight = advanceFreight;
    }

    public LocalDateTime getAutoGeneratedDateTime() {
        return autoGeneratedDateTime;
    }

    public void setAutoGeneratedDateTime(LocalDateTime autoGeneratedDateTime) {
        this.autoGeneratedDateTime = autoGeneratedDateTime;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }
    public int getWeight5kg() {
        return weight5kg;
    }
    public void setWeight5kg(int weight5kg) {
        this.weight5kg = weight5kg;
    }

    public int getWeight3kg() {
        return weight3kg;
    }

    public void setWeight3kg(int weight3kg) {
        this.weight3kg = weight3kg;
    }


    public int getWeight1kg() {
        return weight1kg;
    }

    public void setWeight1kg(int weight1kg) {
        this.weight1kg = weight1kg;
    }



    public int getWeight500g() {
        return weight500g;
    }
    public void setWeight500g(int weight500g) {
        this.weight500g = weight500g;
    }
    public int getWeight10mrp() {
        return weight10mrp;
    }

    public void setWeight10mrp(int weight10mrp) {
        this.weight10mrp = weight10mrp;
    }
    public int getTubQuantity() {
        return tubQuantity;
    }

    public void setTubQuantity(int tubQuantity) {
        this.tubQuantity = tubQuantity;
    }

    public int getBucketQuantity() {
        return bucketQuantity;
    }

    public void setBucketQuantity(int bucketQuantity) {
        this.bucketQuantity = bucketQuantity;
    }

    public int getDaliyaQuantity() {
        return daliyaQuantity;
    }

    public void setDaliyaQuantity(int daliyaQuantity) {
        this.daliyaQuantity = daliyaQuantity;
    }
}