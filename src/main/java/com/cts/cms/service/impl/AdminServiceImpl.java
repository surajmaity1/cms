package com.cts.cms.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.cts.cms.dto.AdminDto;
import com.cts.cms.entity.Admin;
import com.cts.cms.repository.AdminRepository;
import com.cts.cms.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService{
    AdminRepository adminInfoRepository;

    public AdminServiceImpl(AdminRepository adminInfoRepository) {
        this.adminInfoRepository = adminInfoRepository;
    }

    @Override
    public String registerAdmin(AdminDto adminDto) {
        // TODO Auto-generated method stub
        Admin admin = new Admin();

        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());

        adminInfoRepository.save(admin);
        return "Success: Admin registered";
    }

    @Override
    public String loginAdmin(AdminDto adminDto, HttpSession httpSession, ModelMap modelMap) {

        try {
            String username = adminDto.getUsername();
            if(adminInfoRepository
                    .existsByUsernameAndPassword(username, adminDto.getPassword())) {

                httpSession.setAttribute("username", username);
                return "success";
            }
            else {
                modelMap.put("error", "Invalid account");
                return "Invalid account";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "Login failed";
    }

    @Override
    public String resetPasswordForAdmin(AdminDto adminDto) {
        // TODO Auto-generated method stub
        String username = adminDto.getUsername();
        Boolean checkExistanceOfAdmin = adminInfoRepository.existsByUsername(username);

        if(!checkExistanceOfAdmin) {
            return "Admin with given username not exist";
        }

        Admin admin = adminInfoRepository.findByUsername(username).get();

        admin.setPassword(adminDto.getPassword());

        adminInfoRepository.save(admin);

        return "password changed successfully";
    }


}