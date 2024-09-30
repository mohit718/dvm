package com.ms.SVM.DAL;

import com.ms.SVM.Entity.Role;
import com.ms.SVM.Model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
