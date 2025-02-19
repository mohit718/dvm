package com.ms.SVM.DAL;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    // Additional query methods can be defined here
}
