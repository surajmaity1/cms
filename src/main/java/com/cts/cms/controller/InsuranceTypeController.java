package com.cts.cms.controller;

import com.cts.cms.entity.InsuranceType;
import com.cts.cms.service.InsuranceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/admin")
public class InsuranceTypeController {

    InsuranceTypeService insuranceTypeService;

    @Autowired
    public InsuranceTypeController(InsuranceTypeService insuranceTypeService) {
        this.insuranceTypeService = insuranceTypeService;
    }

    @PostMapping("/addInsurance")
    public ResponseEntity<String> addInsurance(@RequestBody InsuranceType insuranceType) {
        String response = insuranceTypeService.addInsurance(insuranceType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}