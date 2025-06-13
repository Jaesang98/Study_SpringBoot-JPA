package com.example.base.service;

import com.example.base.entity.BasicEntity;
import com.example.base.entity.CustomUser;
import com.example.base.repository.BasicRepository;
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
import java.util.Optional;

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
        // DB에서 사용자 조회
        username = "재상";
        Optional<BasicEntity> result = basicRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        BasicEntity user = result.get();

        // 권한 설정
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); // 권한 명은 ROLE_ 로 시작해야 함

        // CustomUser 리턴
        return new CustomUser(
                user.getUsername(),
                user.getPassword(),
                authorities,
                user.getAddress(),
                user.getNumber(),
                user.getImage()
        );
    }
}