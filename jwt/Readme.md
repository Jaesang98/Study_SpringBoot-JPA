# JWT 로그인 커스텀


## 로그인 시 경로
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

## 기능
- 로그인 기능 구현
- `accessToken`, `refreshToken` 발급
  - 현재는 둘 다 사용자 정보를 포함하지만, **실제로는 refreshToken에 사용자 정보를 넣지 않는 것이 보안상 권장됨**
- `accessToken` 만료 시 → `refreshToken` 유효하면 새 토큰 발급
- `refreshToken`도 만료되었거나 유효하지 않으면 → `401 Unauthorized` 응답
- 회원가입은 간단하므로 설명 생략

## 커스터마이징 할 경우
#### 1. application.properties
- DB정보, jwt.secret

#### 2. entity 변겅
- Entity/Member : DB에서 찾을 아이디

- MemberController : 파라미터

- SignInDto : 클라에서 받을 것

- CustomUserDetailsService : loadUserByUsername의 파라미터, createUserDetails의 빌더

- MemberServiceImpl : 파리미터

- MemberRepository : findBy~~~

## 참고 게시글
[참고](https://gksdudrb922.tistory.com/217)
