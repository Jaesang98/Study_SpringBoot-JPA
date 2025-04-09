package com.example.shop.member;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @GetMapping("/register")
    String register() {
        return "register.html";
    }

    @PostMapping("/member")
    String member(String displayName, String username, String password) {
        Member member = new Member();
        member.setDisplayName(displayName);
        member.setUsername(username);
        member.setPassword(new BCryptPasswordEncoder().encode(password));
        memberRepository.save(member);
        return "redirect:/list";
    }


    @GetMapping("/login")
    String login() {
        return "login.html";
    }

    @GetMapping("/my-page")
    String myPage(Authentication auth) {
        return "mypage.html";
    }

    @GetMapping("/user/1")
    @ResponseBody
    MemberDto getUser() {
        var a = memberRepository.findById(1L);
        var result = a.get();
        var data = new MemberDto(result.getUsername(), result.getDisplayName());
        return data;
    }

    @PostMapping("/login/jwt")
    @ResponseBody
    String loginJWT(@RequestBody Map<String, String> data, HttpServletResponse response) {

        var authToken = new UsernamePasswordAuthenticationToken(data.get("username"), data.get("password"));
        var auth = authenticationManagerBuilder.getObject().authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);

        var jwt = JwtUtil.createToken(SecurityContextHolder.getContext().getAuthentication());
        System.out.println(jwt);

        var cookie = new Cookie("jwt", "jwt");
        cookie.setMaxAge(10);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        return jwt;
    }

    @GetMapping("/my-page/jwt")
    @ResponseBody
    String mypageJWT(Authentication auth) {
        var user = (CustomUser) auth.getPrincipal();
        System.out.println(user);

        return "";
    }
}

class MemberDto {
    public String username;
    public String displayName;

    public MemberDto(String a, String b) {
        this.username = a;
        this.displayName = b;
    }
}