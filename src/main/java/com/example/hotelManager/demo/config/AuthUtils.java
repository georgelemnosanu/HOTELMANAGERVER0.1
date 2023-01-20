package com.example.hotelManager.demo.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
public class AuthUtils {
    public static boolean isAdmin(Authentication authentication){
        return authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList()
                .contains("ROLE_ADMIN");
    }

    public static boolean isCleaner(Authentication authentication){
        return authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList().contains("ROLE_CLEANER");
    }

}