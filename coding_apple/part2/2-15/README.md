## 💡 part2-15 로그인 기능 2

### 🔹 로그인한 사용자의 정보

- 셋팅만 하면 세션방식 로그인 기능 구현 끝
- 클래스에 가이드 주려면 interface/implements
- Controller에서 유저 로그인 정보 출력가능
- 타임리프 파일에서도 가능

```java
// MyUserDetailsService.java
public class MyUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        DB에서 username을 가진 유저를 찾아와서
//        return new User(유저아이디, 비번, 권한) 해주세요
        var result = memberRepository.findAllByUsername(username);
        if(result.isEmpty()) {
            throw new UsernameNotFoundException("그런 아이디 없음");
        }
        var user = result.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("일반유저"));
        return new User(user.getUsername(), user.getPassword(),authorities);
    }
}

// controller.java
public String myPage(Authentication auth) {
    System.out.println(auth);
    System.out.println(auth.getName()); //아이디출력가능
    System.out.println(auth.isAuthenticated()); //로그인여부 검사가능
    System.out.println(auth.getAuthorities().contains(new SimpleGrantedAuthority("일반유저")));
    return "mypage.html";
  }

// SecurityFilterChain
http.logout( logout -> logout.logoutUrl("/logout") );
```

```html
<span sec:authentication="principal"></span>
<span sec:authentication="principal.username"></span>
<span sec:authentication="principal.authorities"></span>
```
