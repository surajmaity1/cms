package com.cts.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cms.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    List<Member> findByFirstNameOrLastName(String firstName, String lastName);
    List<Member> findByInsuranceType(String insuranceType);
}