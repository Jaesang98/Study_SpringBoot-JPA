## 💡 part2-11 Session, JWT, OAuth 개념 설명

### 🔹 Session

- Session id는 랜덤한 문자열
- 유저의 Get / Post 요청마다 로그인 상태 체크
- DB조회를 많이해서 부담이 될 수 있음

### 🔹 JWT

- JSON Web Token방식
- 로그인 날짜, 아이디, 유효기간 등을 암호화해서 보냄
- Get / Post 요청마다 DB조회를 안해서 부담이 적음
- 유저가 많으면 사용하기 좋음
- 다른사람이 사용 or 상대 강제로그아웃 하기 힘듬

### 🔹 OAuth

- 로그인했을 때 사용권한을 대여
- 카카오로 로그인 이런거랑 비슷한 느낌
