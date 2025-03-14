package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    String register () {
        return "register.html";
    }

    @PostMapping("/member")
    String addMember (String username, String password, String displayName) {
        Member member = new Member();
        member.setUsername(username);
        var hash = passwordEncoder.encode(password);
        member.setPassword(hash);
        member.setDisplayName(displayName);

        memberRepository.save(member);
        return "redirect:/list";
    }

    @GetMapping("/login")
    String login () {
        return "login.html";
    }

    @GetMapping("/my-page")
    String myPage (Authentication auth) {
//        CustomUser user = (CustomUser) auth.getPrincipal();
//        System.out.println(user.displayName);
        return "mypage.html";
    }
}
