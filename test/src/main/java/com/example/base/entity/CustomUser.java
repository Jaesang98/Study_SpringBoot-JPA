package com.example.base.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {
    private final String address;
    private final String number;
    private final String image;

    public CustomUser(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            String address,
            String number,
            String image
    ) {
        super(username, password, authorities);
        this.address = address;
        this.number = number;
        this.image = image;
    }
}
