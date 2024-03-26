package com.vehicle.management.repo;

import com.vehicle.management.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransationRepo extends JpaRepository<Transaction,Long> {
}
