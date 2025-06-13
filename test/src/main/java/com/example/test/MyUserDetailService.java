package com.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * implements : 인터페이스를 구현할 때 사용하는 키워드
 *
 * @override : 인터페이스의 메서드를 재정의할 때 사용
 */

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final BasicRepository basicRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var result = basicRepository.findByUsername(username);
        if(result.isEmpty()) {
            throw new UsernameNotFoundException("아이디 없음");
        }
        var user = result.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("일반유저"));

        var a = new CustomUser(user.getUsername(), user.getPassword(), authorities);
        a.title = user.getTitle();
        return a;
    }
}

class CustomUser extends User {
    public String title;

    public CustomUser(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
    )
    {
        super(username, password, authorities);
    }
}
