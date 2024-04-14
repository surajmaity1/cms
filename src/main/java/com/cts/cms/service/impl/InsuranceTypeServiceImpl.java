package com.cts.cms.service.impl;

import com.cts.cms.entity.InsuranceType;
import com.cts.cms.exception.CmsException;
import com.cts.cms.repository.InsuranceTypeRepository;
import com.cts.cms.service.InsuranceTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class InsuranceTypeServiceImpl implements InsuranceTypeService {

    InsuranceTypeRepository insuranceTypeRepository;

    public InsuranceTypeServiceImpl(InsuranceTypeRepository insuranceTypeRepository) {
        this.insuranceTypeRepository = insuranceTypeRepository;
    }

    @Override
    public String addInsurance(InsuranceType insuranceType) {

        // Check this insurance added by admin or not

        // add check for same insuranceType exists in database
        if (insuranceTypeRepository.existsByInsuranceType(insuranceType.getInsuranceType())){
            throw new CmsException(HttpStatus.BAD_REQUEST, "This insurance is already exists");
        }

        insuranceTypeRepository.save(insuranceType);
        return "Success: Insurance Added";
    }

}
