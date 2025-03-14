## 💡 part2-13 가입기능 만들기

### 🔹 숙제

- 숙제임

### 🔹 dependency injection

- 객체가 직접 다른 객체를 생성하는 게 아니라, 필요한 객체를 외부에서 넣어주는 방식
- 남이 만든 클래스의 object 를 ID로 쓰고 싶으면 @Bean 사용

```java
@Bean
    PasswordEncoder 함수() {
        return new BCryptPasswordEncoder();
    }
```
