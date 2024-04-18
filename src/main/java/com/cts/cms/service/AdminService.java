package com.cts.cms.service;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.cts.cms.dto.AdminDto;
import com.cts.cms.entity.Admin;

import jakarta.servlet.http.HttpSession;

public interface AdminService {
    public String registerAdmin(AdminDto adminDto);
    public String loginAdmin(AdminDto adminDto, HttpSession httpSession, ModelMap modelMap);
    public String resetPasswordForAdmin(AdminDto adminDto);
}
