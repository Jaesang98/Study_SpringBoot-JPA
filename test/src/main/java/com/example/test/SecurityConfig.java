package com.example.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * @Configuration : 설정 클래스를 나타내며, 내부에 정의된 @Bean 메서드들을 스프링 컨테이너에 등록함
 *
 * @EnableWebSecurity : Spring Security 필터 체인을 등록 / 로그인, 인증, 권한 설정 등을 커스터마이징
 *
 * @Bean : 객체를 생성해서 스프링 컨테이너에 등록할 때 사용
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // 모든 유저의 요청과 서버 응답사이에 자동으로 실행
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // csrf 비활성화 : csrf(사이트 간 요청 위조) 내가 만든 api를 다른 사이트에서 사용하는것을 말한다
        http.csrf((csrf)-> csrf.disable());

        // 특정 페이지 로그인 검사여부
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
        );

        // 로그아웃
        http.logout(logout -> logout.logoutUrl("/logout"));
        return http.build();
    }
}
