package com.cts.cms.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private Long contactNo;
    private String email;
    private String gender;
    private int nomineeCount;
    private String insuranceType;
    private Long maxClaimAmount;
}
