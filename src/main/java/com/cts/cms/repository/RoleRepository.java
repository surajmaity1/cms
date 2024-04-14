package com.cts.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.cms.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
