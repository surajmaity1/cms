package com.cts.cms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cms.dto.MemberDto;
import com.cts.cms.entity.Member;
import com.cts.cms.service.MemberService;

@RestController
@RequestMapping("/cms/member")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/add")
    public String registerMember(@RequestBody MemberDto memberDto) {
        String response = memberService.registerMember(memberDto);
        return response;
    }

    @PutMapping("/update/{id}")
    public String updateMember(@PathVariable("id") Long id) {
        String response = memberService.updateMember(id);
        return response;
    }

    @GetMapping("/all")
    public List<Long> getAllMemberId() {
        return memberService.getAllMemberId();
    }

    @GetMapping("/firstName/{id}")
    public String getFirstName(@PathVariable("id") Long id) {
        return memberService.getFirstName(id);
    }

    @GetMapping("/lastName/{id}")
    public String getLastName(@PathVariable("id") Long id) {
        return memberService.getLastName(id);
    }

    @GetMapping("/nomineeCount/{id}")
    public int getNomineeCount(@PathVariable("id") Long id) {
        return memberService.getNomineeCount(id);
    }

    @GetMapping("/maxClaimAmount/{id}")
    public Long getMaxClaimAmount(@PathVariable("id") Long id) {
        return memberService.getMaxClaimAmount(id);
    }

    @GetMapping("/insuranceType/{id}")
    public String getInsuranceType(@PathVariable("id") Long id) {
        return memberService.getInsuranceType(id);
    }
}
