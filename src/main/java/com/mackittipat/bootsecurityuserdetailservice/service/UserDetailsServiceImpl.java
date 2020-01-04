package com.mackittipat.bootsecurityuserdetailservice.service;

import com.mackittipat.bootsecurityuserdetailservice.model.User;
import com.mackittipat.bootsecurityuserdetailservice.model.UserRole;
import com.mackittipat.bootsecurityuserdetailservice.repository.UserRepository;
import com.mackittipat.bootsecurityuserdetailservice.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserRole userRole = userRoleRepository.findByUserId(user.getId());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(userRole.getRole()))
        );

        return userDetails;
    }
}
