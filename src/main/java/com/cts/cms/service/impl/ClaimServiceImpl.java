
package com.cts.cms.service.impl;

import org.springframework.stereotype.Service;

import com.cts.cms.dto.ClaimDto;
import com.cts.cms.entity.Claim;
import com.cts.cms.repository.ClaimRepository;
import com.cts.cms.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService{
    ClaimRepository claimRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Override
    public String addClaim(ClaimDto claimDto) {
        Claim claim = new Claim();

        claim.setMemberId(claimDto.getMemberId());
        claim.setRequestDate(claimDto.getRequestDate());
        claim.setClaimReason(claimDto.getClaimReason());
        claim.setInsuranceType(claimDto.getInsuranceType());
        claim.setFinalClaimAmount(claimDto.getFinalClaimAmount());
        claim.setApprovalStatus(claimDto.getApprovalStatus());
        claim.setApprovalDate(claimDto.getApprovalDate());
        claim.setRejectReason(claimDto.getRejectReason());
		
		/*
		claim.set(claimDto.get());
		claim.set(claimDto.get());
		*/
        claimRepository.save(claim);
        return "Success: Claim created";
    }

}