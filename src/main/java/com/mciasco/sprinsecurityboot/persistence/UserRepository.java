package com.mciasco.springsecurityboot.persistence;


import com.mciasco.springsecurityboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
