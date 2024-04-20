package com.cts.cms.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimUiDto {

    private String memberId;
    private String requestDate;
    private String claimReason;
    private String finalClaimAmount;
    private String insuranceType;
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
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
    public String getFinalClaimAmount() {
        return finalClaimAmount;
    }
    public void setFinalClaimAmount(String finalClaimAmount) {
        this.finalClaimAmount = finalClaimAmount;
    }
    public String getInsuranceType() {
        return insuranceType;
    }
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
    @Override
    public String toString() {
        return "ClaimUiDto [memberId=" + memberId + ", requestDate=" + requestDate + ", claimReason=" + claimReason
                + ", finalClaimAmount=" + finalClaimAmount + ", insuranceType=" + insuranceType + "]";
    }

}
