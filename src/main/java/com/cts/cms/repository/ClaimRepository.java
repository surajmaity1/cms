package com.cts.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cms.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long>{
    Optional<Claim> findByMemberId(Long memberId);
    List<Claim> findByApprovalStatus(Boolean approvalStatus);
}
