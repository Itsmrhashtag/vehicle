package com.vehicle.management.repo;

import com.vehicle.management.models.Watchman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchmanRepo extends JpaRepository<Watchman,Long> {
    Watchman findByVehicleNumber(String vehicleNumber);
}
