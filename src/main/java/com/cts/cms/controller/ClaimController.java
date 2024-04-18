package com.cts.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cms.dto.ClaimDto;
import com.cts.cms.service.ClaimService;

@RestController
@RequestMapping("/cms/claim")
public class ClaimController {

    ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/add")
    public String addClaim(@RequestBody ClaimDto claimDto) {
        String response = claimService.addClaim(claimDto);
        return response;
    }

}
