package com.cts.cms.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cts.cms.dto.MemberDto;
import com.cts.cms.entity.Member;
import com.cts.cms.repository.MemberRepository;
import com.cts.cms.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

    MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String registerMember(MemberDto memberDto) {

        Member member = new Member();
        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        member.setDateOfBirth(memberDto.getDateOfBirth());
        member.setAddress(memberDto.getAddress());
        member.setContactNo(memberDto.getContactNo());
        member.setEmail(memberDto.getEmail());
        member.setGender(memberDto.getGender());
        member.setNomineeCount(memberDto.getNomineeCount());
        member.setInsuranceType(memberDto.getInsuranceType());
        member.setMaxClaimAmount(memberDto.getMaxClaimAmount());

        Member insertedMember = memberRepository.save(member);
        Long id = insertedMember.getId();
        return "Dear Admin, the member added successfully with MBC-0000" + id;
    }

    @Override
    public List<Long> getAllMemberId() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(Member::getId)
                .collect(Collectors.toList());
    }

    @Override
    public String getFirstName(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if(!member.isPresent()) {
            return "Invalid id";
        }

        return member.get().getFirstName();
    }

    @Override
    public String getLastName(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if(!member.isPresent()) {
            return "Invalid id";
        }

        return member.get().getLastName();
    }

    @Override
    public int getNomineeCount(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if(!member.isPresent()) {
            return 0;
        }

        return member.get().getNomineeCount();
    }

    @Override
    public Long getMaxClaimAmount(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if(!member.isPresent()) {
            return (long) 0;
        }

        return member.get().getMaxClaimAmount();
    }

    @Override
    public String getInsuranceType(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        if(!member.isPresent()) {
            return "Invalid id";
        }

        return member.get().getInsuranceType();
    }

    @Override
    public String updateMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);

        return "";
    }
}