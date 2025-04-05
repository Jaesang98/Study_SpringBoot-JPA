package com.example.shop.member;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

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
}
