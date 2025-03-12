## 💡 part2-5 REST API의 예외처리 방법

### 🔹 REST API의 예외처리

- 개꿀팁 ajax로 서버통신하면 서버에서 redirect불가능
- 에러나면 status를 보내줘야함

```java
ResponseEntity<String > detail (@PathVariable Long id, Model model) {
    try {

    }
    catch (Exception e) {
        return ResponseEntity.status(400).body("니잘못임");
    }
}
```

### 🔹 status

- HttpStatus 쓰면편함

```java
ResponseEntity.status(HttpStatus.NOT_FOUND).body("니잘못임");
```

### 🔹 퍼블릭 에러파일

- 에러나는 상황을 만들어놓은 파일
- 다른 컨트롤러에서 `throw new Exception();` 가 나오면 퍼블릭파일 호출

```java
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(){
        return ResponseEntity.status(400).body("에러남!");
    }
}
```
