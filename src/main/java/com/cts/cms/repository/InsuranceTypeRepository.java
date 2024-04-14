package com.cts.cms.repository;

import com.cts.cms.entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Long> {
    Boolean existsByInsuranceType(String insuranceType);
    Optional<InsuranceType> findByInsuranceType(String insuranceType);
}
