package com.cts.cms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cms.entity.InsuranceType;
import com.cts.cms.repository.InsuranceTypeRepository;
import com.cts.cms.service.InsuranceTypeService;

@RestController
@RequestMapping("/cms/insurance")
public class InsuranceTypeController {

    InsuranceTypeService insuranceTypeService;

    public InsuranceTypeController(InsuranceTypeService insuranceTypeService) {
        this.insuranceTypeService = insuranceTypeService;
    }

    @GetMapping("/all")
    public List<String> getAllInsuranceName() {
        return insuranceTypeService.getAllInsuranceName();
    }

    @GetMapping("/{insuranceType}")
    public Double getInsuranceAmount(@PathVariable("insuranceType") String insuranceType) {
        return insuranceTypeService.getInsuranceAmount(insuranceType);
    }
}
