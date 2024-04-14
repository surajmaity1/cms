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
public class RegisterDto {
    private String name;
    private Date dateOfBirth;
    private String address;
    private Long contactNo;
    private String username;
    private String email;
    private String password;
    private String gender;
    private int nominees;
    private String insuranceType;
    private Long maxClaimAmount;
}
