package com.example.jwt.auth.Service;

import com.example.jwt.auth.Dto.JwtToken;
import com.example.jwt.auth.Provider.JwtTokenProvider;
import com.example.jwt.auth.Repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public JwtToken signIn(String email, String password) {
        // 1. 전달받은 email과 password로 인증용 객체 생성
        //    → "이 사용자가 로그인하려고 합니다" 라는 의미
        //    ※ 이 시점에서는 인증이 완료되지 않은 상태 (authenticated = false)
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);

        // 2. 인증 처리 수행
        //    → 실제 DB에서 유저 정보를 조회하고, 비밀번호가 맞는지 확인
        //    → 내부적으로 CustomUserDetailsService.loadUserByUsername()가 실행됨
        Authentication authentication =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 성공 시, 해당 사용자 정보를 바탕으로 JWT 토큰 생성
        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

        return jwtToken;
    }
}