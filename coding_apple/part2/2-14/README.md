## 💡 part2-14 로그인 기능 1

### 🔹 로그인 세팅

- html만들기

```java
// 폼으로 로그인 한다라는 뜻
// SecurityConfig.java
http.formLogin((formLogin) -> formLogin.loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/fail")
        )

// MyUserDetailsService.java
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        DB에서 username을 가진 유저를 찾아와서
//        return new User(유저아이디, 비번, 권한) 해주세요
    }
}

// interface파일
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findAllByUsername(String username);
}

```

```html
<!-- 에러가 난 경우 보여줌 -->
<div th:if="${param.error}">아이디 비번틀림</div>
```
