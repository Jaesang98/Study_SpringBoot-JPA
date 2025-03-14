## 💡 part2-12 Spring Security 설치와 셋팅, Hashing

### 🔹 Spring Security

- Session id는 랜덤한 문자열
- 처음 설정하면 로그인 페이지 뜨는데 터미널에 문자 뜨니까 그거 사용하면됨
- FilterChain은 요청과 응답사이에 자동으로 실행해주고 싶은 코드를 담는곳

```Bash
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.1.1.RELEASE'
```

```java
// SecurityConfig.java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 다른사이트에서 api요청하는것 그게 csrf공격
        http.csrf((csrf -> csrf.disable()));
        http.authorizeHttpRequests((authorize) ->
                // /**은 아무 url이라는 뜻,  permitAll()은 항상 허용하겠다 라는뜻 즉 모든 url 로그인 검사를 끔
                authorize.requestMatchers("/**").permitAll()
        );
        return http.build();
    }
}
```

### 🔹 Hashing

- 문자열을 암호화
- 같은 걸 암호화하면 똑같은 암호화 문자가 나옴

```java
new BCryptPasswordEncoder().encode("문자")
```
