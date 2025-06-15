package com.example.jwt.auth.Service;

import com.example.jwt.auth.Dto.JwtToken;

public interface MemberService {
    JwtToken signIn(String username, String password);
}
