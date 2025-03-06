## 💡 part1-2 개발환경 셋팅 / Spring Boot 3 프로젝트 생성

### 🔹 다운로드, 생성

- [인텔리제이 다운받기](https://www.jetbrains.com/ko-kr/idea/download/?section=windows)
- [프로젝트 생성](https://start.spring.io/)
  - Project : Gradle - Groovy
  - Language : Java
  - Spring Boot : 소괄호없는거
  - Project Meatdata : Group(회사), Artifact(프로젝트명), packaging(Jar), Java(17)
  - Dependencies : Spring Web, Spring Boot DevTools 적용

### 🔹 세팅

- file/projectStruct 에서 jdk버전 확인 (내가 생성한것보다 높은거로)
- file/settings/buildTools/gradle 에서 Build and run using, Run tests using 를 intellij IDEA로 바꿔준다
- file/settings/java compiler 에서 Additional command line parameters에 -parameters 입력

### 🔹 파일설명, 실행

- ShopApplication : 서버실행하는곳
- resources : html css js 이미지등 보관하는곳
- application.properties : 환경설정
- gradle : 코드 바꾸기, 라이브러리 관리, 테스트 등을 해준다

```bash
# Run
ShopApplication

# 웹 실행 (8080이기본)
http://localhost:8080/
```
