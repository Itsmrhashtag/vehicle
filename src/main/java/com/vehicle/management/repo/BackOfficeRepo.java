package com.vehicle.management.repo;

import com.vehicle.management.models.BackOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackOfficeRepo extends JpaRepository<BackOffice,Long> {
}
