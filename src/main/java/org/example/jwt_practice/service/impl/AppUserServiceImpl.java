package org.example.jwt_practice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.jwt_practice.model.entity.AppUser;
import org.example.jwt_practice.repository.AppUserRepository;
import org.example.jwt_practice.service.AppUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = appUserRepository.getUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException("User not found");
        System.out.println("User logging in: " + email);
        System.out.println("Authorities found: " + user.getAuthorities());

        return user;
    }


}
