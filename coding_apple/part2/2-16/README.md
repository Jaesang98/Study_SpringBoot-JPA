## 💡 part2-16 로그인 기능 3 (유저정보 커스터마이징, CSRF)

### 🔹 세션 유지기간

```java
server.servlet.session.timeout=5s
server.servlet.session.cookie.max-age=5s
```

### 🔹 CSRF 토큰

```java
// SecurityConfig
@Bean
  public CsrfTokenRepository csrfTokenRepository() {
    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
    repository.setHeaderName("X-XSRF-TOKEN");
    return repository;
  }

  http.csrf(csrf -> csrf.csrfTokenRepository(csrfTokenRepository())
       .ignoringRequestMatchers("/login")
)
```
