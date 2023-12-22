package com.company.repository;



import com.company.repository.entity.Company;
import com.company.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompanyRepository extends JpaRepository <Company,Long> {
    Optional<Company> findOptionalByCompanyname(String companyname);
}
