package com.example.jwt.auth.Filter;

import com.example.jwt.auth.Dto.JwtToken;
import com.example.jwt.auth.Provider.JwtTokenProvider;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 1. Request Header에서 JWT 토큰 추출
        String accessToken = resolveToken(httpRequest);

        // 2. validateToken으로 토큰 유효성 검사
        if (StringUtils.hasText(accessToken)) {
            if (jwtTokenProvider.validateToken(accessToken)) {
                // accessToken이 유효한 경우
                Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else if (jwtTokenProvider.isTokenExpired(accessToken)) {
                // accessToken이 만료되었지만, 형식은 맞는 경우 → refreshToken 검사
                String refreshToken = httpRequest.getHeader("refreshToken");

                if (StringUtils.hasText(refreshToken) && jwtTokenProvider.validateToken(refreshToken)) {;
                    // refreshToken도 유효하면 새로운 accessToken 발급
                    Authentication authentication = jwtTokenProvider.getAuthentication(refreshToken);
                    System.out.println("authentication+++++" + authentication);
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    JwtToken newTokens = jwtTokenProvider.generateToken(authentication);
                    httpResponse.setHeader("accessToken", newTokens.getAccessToken());
                    httpResponse.setHeader("refreshToken", newTokens.getRefreshToken());
                }
                else {
                    httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    httpResponse.setContentType("application/json;charset=UTF-8");
                    httpResponse.getWriter().write("{\"message\": \"refreshToken이 만료되었거나 유효하지 않습니다. 다시 로그인하세요.\"}");
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    // Request Header에서 토큰 정보 추출
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}