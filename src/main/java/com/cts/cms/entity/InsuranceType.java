package com.cts.cms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "insurancetype")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private Long insuranceId;

    @Column(name = "insurance_type", nullable = false, unique = true)
    private String insuranceType;

    @Column(name = "insured_amount", nullable = false)
    private Double insuredAmount;
}
