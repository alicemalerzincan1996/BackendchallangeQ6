package com.company.repository;



import com.company.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository <User,Long> {
    Optional<User> findOptionalByUsername(String username);
    Optional<User> findOptionalByName(String name);
    Optional<User> findOptionalBySurname(String surname);


}
