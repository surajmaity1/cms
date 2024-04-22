package com.cts.cms.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberUiDto {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String contactNo;
    private String email;
    private String nomineeCount;
    private String insuranceType;
    private String maxClaimAmount;
    private String gender;
}
