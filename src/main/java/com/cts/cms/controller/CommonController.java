package com.cts.cms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.cts.cms.ui.dto.MemberUiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
import com.cts.cms.service.AdminService;
import com.cts.cms.service.ClaimService;
import com.cts.cms.service.InsuranceTypeService;
import com.cts.cms.service.MemberService;
import com.cts.cms.ui.dto.ClaimUiDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommonController {
    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ClaimService claimService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private InsuranceTypeService insuranceTypeService;

    List<Long> memberIdList = null;

    List<String> insuranceList = null;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/claimsearch")
    public String searchClaim(HttpSession session) {

        if(session.getAttribute("username") == null || session.getAttribute("username").equals("")) {
            return "redirect:/login";
        }

        return "search_claim";
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword(HttpSession session) {
        if(session.getAttribute("username") == null || session.getAttribute("username").equals("")) {

        }
        else {
            session.removeAttribute("username");
            session.invalidate();
        }

        return "forgotpassword";
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

    @PostMapping("/doForgotPassword")
    public String implementForgotPassword(@ModelAttribute AdminDto adminDto, HttpSession session, ModelMap modelMap) {

        try {
            String username = adminDto.getUsername();
            if(adminRepository
                    .existsByUsername(username)) {

                String response = adminService.resetPasswordForAdmin(adminDto);

                if (response.equals("success")) {
                    return "redirect:/dashboard";
                }

                return "redirect:/forgotpassword";

            }
            else {
                modelMap.put("error", "Invalid account");
                return "redirect:/forgotpassword";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/forgotpassword";
    }

    @GetMapping("/register")
    public String registerMember(Model model, HttpSession session) {

        if(session.getAttribute("username") == null || session.getAttribute("username").equals("")) {
            return "redirect:/login";
        }
        insuranceList = insuranceTypeService.getAllInsuranceName();
        System.out.println(insuranceList);
        model.addAttribute("insurances", insuranceList);
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

    @PostMapping("/submitForm")
    public String submitForm(@RequestBody String memberId, @ModelAttribute ClaimUiDto claimUiDto) {

        if (memberId == null || memberId.isEmpty()){
            return "redirect:/claimrequest";
        }

        memberId = memberId.replace("MBC-0000", "");
        System.out.println("ID: " + memberId);


        Claim claim = new Claim();
        memberId = claimUiDto.getMemberId().replace("MBC-0000", "");
        Long id = Long.valueOf(memberId);

        claim.setMemberId(Long.valueOf(id));
        claim.setRequestDate(claimUiDto.getRequestDate());
        claim.setClaimReason(claimUiDto.getClaimReason());
        claim.setFinalClaimAmount(Long.valueOf(claimUiDto.getFinalClaimAmount()));
        claim.setInsuranceType(claimUiDto.getInsuranceType());

        claimRepository.save(claim);

        return "redirect:/claimrequest";
    }

    @PostMapping("/registerMember")
    public String registerMember(@ModelAttribute MemberUiDto memberDto) {

        Member member = new Member();
        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        member.setDateOfBirth(memberDto.getDateOfBirth());
        member.setAddress(memberDto.getAddress());
        member.setContactNo(Long.valueOf(memberDto.getContactNo()));
        member.setEmail(memberDto.getEmail());
        member.setGender(memberDto.getGender());
        member.setNomineeCount(Integer.parseInt(memberDto.getNomineeCount()));
        member.setInsuranceType(memberDto.getInsuranceType());
        member.setMaxClaimAmount((long) Double.parseDouble(memberDto.getMaxClaimAmount()));

        Member insertedMember = memberRepository.save(member);

        return "redirect:/dashboard";
    }

    @PostMapping("/fetchFirstName")
    @ResponseBody
    public String fetchFirstName(@RequestParam("memberId") String memberId) {
        return fetchStringData(memberId, memberService::getFirstName);
    }

    @PostMapping("/fetchLastName")
    @ResponseBody
    public String fetchLastName(@RequestParam("memberId") String memberId) {
        return fetchStringData(memberId, memberService::getLastName);
    }

    @PostMapping("/fetchNomineeCount")
    @ResponseBody
    public String fetchNomineeCount(@RequestParam("memberId") String memberId) {
        return fetchIntegerData(memberId, memberService::getNomineeCount);
    }


    @PostMapping("/fetchMaxClaimAmount")
    @ResponseBody
    public String fetchMaxClaimAmount(@RequestParam("memberId") String memberId) {
        return fetchLongData(memberId, memberService::getMaxClaimAmount);
    }

    @PostMapping("/fetchFinalClaimAmount")
    @ResponseBody
    public String fetchFinalClaimAmount(@RequestParam("memberId") String memberId) {
        return fetchLongData(memberId, claimService::getFinalClaimAmount);
    }

    @PostMapping("/fetchInsuranceType")
    @ResponseBody
    public String fetchInsuranceType(@RequestParam("memberId") String memberId) {
        return fetchStringData(memberId, memberService::getInsuranceType);
    }

    @PostMapping("/fetchInsuranceAmount")
    @ResponseBody
    public String fetchInsuranceAmount(@RequestParam("insuranceType") String insuranceType) {
        return fetchDoubleData(insuranceType, insuranceTypeService::getInsuranceAmount);
    }

    @PostMapping("/fetchMaxClaimAmountForMemberRegistration")
    @ResponseBody
    public String fetchMaxClaimAmountForMemberRegistration(@RequestParam("insuranceType") String insuranceType) {

        double maxClaimAmount = insuranceTypeService.getInsuranceAmount(insuranceType);

        if (insuranceType.equals("Vehicle Insurance")) {
            maxClaimAmount = maxClaimAmount * 0.8;
        }
        else if (insuranceType.equals("Home Insurance")) {
            maxClaimAmount = maxClaimAmount * 9.1;
        }
        else if (insuranceType.equals("Life Insurance")) {
            maxClaimAmount = maxClaimAmount;
        }
        else {
            maxClaimAmount = 0;
        }

        return String.valueOf(maxClaimAmount);
    }

    private String fetchDoubleData(String insuranceType, Function<String, Double> getNameFunction) {
        String data = String.valueOf(getNameFunction.apply(insuranceType));
        return data != null ? data : "";
    }

    private String fetchLongData(String memberId, Function<Long, Long> getNameFunction) {
        memberId = memberId.replace("MBC-0000", "");
        Long id = Long.valueOf(memberId);
        System.out.println("Selected Member ID: " + id);
        String data = String.valueOf(getNameFunction.apply(id));
        return data != null ? data : "";
    }

    private String fetchStringData(String memberId, Function<Long, String> getNameFunction) {
        memberId = memberId.replace("MBC-0000", "");
        Long id = Long.valueOf(memberId);
        System.out.println("Selected Member ID: " + id);
        String name = getNameFunction.apply(id);
        return name != null ? name : "";
    }

    private String fetchIntegerData(String memberId, Function<Long, Integer> getNameFunction) {
        memberId = memberId.replace("MBC-0000", "");
        Long id = Long.valueOf(memberId);
        System.out.println("Selected Member ID: " + id);
        String data = String.valueOf(getNameFunction.apply(id));
        return data != null ? data : "";
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