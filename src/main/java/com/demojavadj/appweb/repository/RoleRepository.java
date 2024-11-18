package com.demojavadj.appweb.repository;

import com.demojavadj.appweb.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
