package com.cts.cms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cms.entity.InsuranceType;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Long>{
    Optional<InsuranceType> findByInsuranceType(String insuranceType);
}
