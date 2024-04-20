package com.cts.cms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.cms.dto.AdminDto;
import com.cts.cms.dto.ClaimDto;
import com.cts.cms.dto.MemberDto;
import com.cts.cms.entity.Admin;
import com.cts.cms.entity.Claim;
import com.cts.cms.entity.Member;
import com.cts.cms.repository.AdminRepository;
import com.cts.cms.repository.ClaimRepository;
import com.cts.cms.repository.MemberRepository;
import com.cts.cms.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommonController {
    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MemberService memberService;

    List<Long> memberIdList = null;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {

        if(session.getAttribute("username") == null || session.getAttribute("username").equals("")) {
            return "redirect:/login";
        }

        return "dashboard";
    }

	/*
	@PostMapping("/registerAdmin")
	public String adminRegistration(@ModelAttribute AdminDto adminDto) {


		Admin admin = new Admin();

		admin.setUsername(adminDto.getUsername());
		admin.setPassword(adminDto.getPassword());

		adminRepository.save(admin);
		return "redirect:/login";
	}
	*/


    @PostMapping("/checkLogIn")
    public String checkLogIn(@ModelAttribute AdminDto adminDto, HttpSession session, ModelMap modelMap) {
        try {
            String username = adminDto.getUsername();
            if(adminRepository
                    .existsByUsernameAndPassword(username, adminDto.getPassword())) {

                session.setAttribute("username", username);
                return "redirect:/dashboard";
            }
            else {
                modelMap.put("error", "Invalid account");
                return "redirect:/login";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerMember(HttpSession session) {

        if(session.getAttribute("username") == null || session.getAttribute("username").equals("")) {
            return "redirect:/login";
        }

        return "member_registration";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/claimrequest")
    public String claimRequest(Model model, HttpSession session) {


        if(session.getAttribute("username") == null || session.getAttribute("username").equals("")) {
            return "redirect:/login";
        }

        List<String> stringMemberIdLists = null;

        memberIdList = memberService.getAllMemberId();

        if (memberIdList != null || memberIdList.size() > 0) {

            stringMemberIdLists = new ArrayList<>(memberIdList.size());
            for (int i = 0; i < memberIdList.size(); i++) {
                stringMemberIdLists.add("MBC-0000" + memberIdList.get(i));
            }
            model.addAttribute("list", stringMemberIdLists);
        }

        return "claimrequest";
    }

    // member

    // claim

    @PostMapping("/claim")
    public String addClaim(@ModelAttribute ClaimDto claimDto, HttpSession httpSession) {
        Claim claim = new Claim();

        claim.setMemberId(claimDto.getMemberId());
        claim.setRequestDate(claimDto.getRequestDate());
        claim.setClaimReason(claimDto.getClaimReason());
        claim.setInsuranceType(claimDto.getInsuranceType());
        claim.setFinalClaimAmount(claimDto.getFinalClaimAmount());
        claim.setApprovalStatus(claimDto.getApprovalStatus());
        claim.setApprovalDate(claimDto.getApprovalDate());
        claim.setRejectReason(claimDto.getRejectReason());

        claimRepository.save(claim);

        return "redirect:/claimrequest";
    }

}
