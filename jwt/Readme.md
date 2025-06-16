[참고](https://gksdudrb922.tistory.com/217)


### 로그인 시 경로
```
[1] MemberController.signIn()
↓
[2] MemberServiceImpl.signIn()
↓
[3] AuthenticationManager.authenticate()
↓
[4] CustomUserDetailsService.loadUserByUsername()
↓
[5] UserDetails 반환 → 인증 성공
↓
[6] JwtTokenProvider.generateToken()
↓
[7] JwtToken 반환 → 클라이언트 전달
```

### 다른 곳에서 사용할 때 수정할 부분
#### 1. application.properties