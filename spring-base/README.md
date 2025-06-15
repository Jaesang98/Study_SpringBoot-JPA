# Spring / Java 기본

## 세팅

### spring initializr

- Packaging : Jar
- Java : 17
- Dependencies : Spring Web / Lombok / Thymeleaf / JPA / Mysql

### 환경설정

- Project Structure : project에서 Openjdk 확인
- Settings:
  - Gradle에서 Build and Run `intellij IDEA` 로 설정
  - Java Compiler에서 -parameters로 설정

## Spring Boot MVC 처리 흐름

```text
[1] 클라이언트 요청 (브라우저, Postman 등)
 ↓
[2] DispatcherServlet (프론트 컨트롤러)
 ↓
[3] HandlerMapping → 어떤 Controller가 요청을 처리할지 탐색
 ↓
[4] Controller (비즈니스 로직을 실행하거나 Service 호출)
 ↓
[5] Service (데이터 가공/처리 등 비즈니스 로직)
 ↓
[6] Repository (DB 접근)
 ↓
[7] 처리된 데이터 → Controller로 리턴
 ↓
[8] ViewResolver (응답할 View를 선택, 보통 JSON 응답)
 ↓
[9] 클라이언트에게 응답
```
