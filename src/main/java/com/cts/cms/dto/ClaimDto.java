package com.cts.cms.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDto {
    private Long memberId;
    private String requestDate;
    private String claimReason;
    private String insuranceType;
    private Long finalClaimAmount;
    private Boolean approvalStatus;
    private String approvalDate;
    private String rejectReason;
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public String getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
    public String getClaimReason() {
        return claimReason;
    }
    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }
    public String getInsuranceType() {
        return insuranceType;
    }
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
    public Long getFinalClaimAmount() {
        return finalClaimAmount;
    }
    public void setFinalClaimAmount(Long finalClaimAmount) {
        this.finalClaimAmount = finalClaimAmount;
    }
    public Boolean getApprovalStatus() {
        return approvalStatus;
    }
    public void setApprovalStatus(Boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    public String getApprovalDate() {
        return approvalDate;
    }
    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }
    public String getRejectReason() {
        return rejectReason;
    }
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

}
