package com.cts.cms.service;

import java.util.List;

import com.cts.cms.dto.MemberDto;
import com.cts.cms.entity.Member;

public interface MemberService {
    public String registerMember(MemberDto memberDto);
    public String updateMember(Long id);
    public List<Long> getAllMemberId();
    public String getFirstName(Long id);
    public String getLastName(Long id);
    public int getNomineeCount(Long id);
    public Long getMaxClaimAmount(Long id);
    public String getInsuranceType(Long id);
}
