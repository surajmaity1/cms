package com.cts.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cms.dto.AdminDto;
import com.cts.cms.entity.Admin;
import com.cts.cms.service.AdminService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cms/admin")
public class AdminController {
    AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public String registerAdmin(@RequestBody AdminDto adminDto) {
        String response= adminService.registerAdmin(adminDto);
        return "Success: Admin Registration";
    }


    @PostMapping("/login")
    public String logInAdmin(@RequestBody AdminDto adminDto, HttpSession httpSession, ModelMap modelMap) {
        String response = adminService.loginAdmin(adminDto, httpSession, modelMap);
        return response;
    }

    @PutMapping("/resetPassword")
    public String resetPasswordForAdmin(@RequestBody AdminDto adminDto) {
        String response = adminService.resetPasswordForAdmin(adminDto);
        return response;
    }

    @GetMapping("/logout")
    public String logout_user(HttpSession session)
    {
        session.removeAttribute("username");
        session.invalidate();
        return "Logout Successful";
    }
}
