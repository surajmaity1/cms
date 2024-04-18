package com.cts.cms.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cts.cms.entity.InsuranceType;
import com.cts.cms.repository.InsuranceTypeRepository;
import com.cts.cms.service.InsuranceTypeService;

@Service
public class InsuranceTypeServiceImpl implements InsuranceTypeService{

    InsuranceTypeRepository insuranceTypeRepository;

    public InsuranceTypeServiceImpl(InsuranceTypeRepository insuranceTypeRepository) {
        this.insuranceTypeRepository = insuranceTypeRepository;
    }


    @Override
    public List<String> getAllInsuranceName() {
        List<InsuranceType> insuranceTypes = insuranceTypeRepository.findAll();
        return insuranceTypes.stream()
                .map(InsuranceType::getInsuranceType)
                .collect(Collectors.toList());
    }


    @Override
    public Double getInsuranceAmount(String insuranceType) {
        // TODO Auto-generated method stub
        Optional<InsuranceType> insurance = insuranceTypeRepository
                .findByInsuranceType(insuranceType);

        if(!insurance.isPresent()) {
            return 0.0;
        }

        return insurance.get().getInsuranceAmount();
    }


}
