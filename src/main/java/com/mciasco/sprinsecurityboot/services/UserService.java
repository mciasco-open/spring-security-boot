package com.mciasco.springsecurityboot.services;

import com.mciasco.springsecurityboot.domain.User;
import com.mciasco.springsecurityboot.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        if(user == null)
            user = new User();

        userRepository.saveAndFlush(user);

        return user;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
