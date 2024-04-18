package com.cts.cms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cms.entity.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Long>{
    Boolean existsByUsername(String username);
    Boolean existsByUsernameAndPassword(String username, String password);
    Optional<Admin> findByUsername(String username);
}
