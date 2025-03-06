## 💡 part1-5 웹서버와 웹페이지 만들기 (Controller)

### 🔹 문자를 return

- `@Controller`를 붙이면 알아서 main함수에서 실행이됨
- `@ResponseBody`를 붙이면 문자 그대로 보내주세요 라는 뜻

```java
// 문자를 return
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    String hello() {
        return "안녕하세요";
    }
}
```

### 🔹 html을 return

- resource/static 폴더에 html파일 생성
- html의 경로는 static을기준

```java
// html을 return
public class BasicController {
    @GetMapping("/")
    String hello() {
        return "index.html";
    }
}

```
