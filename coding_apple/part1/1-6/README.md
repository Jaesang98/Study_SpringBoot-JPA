## 💡 part1-6 상품목록 페이지 만들기 (Thymeleaf)

### 🔹 Thymeleaf

- `build.gradle` 파일에서 설치
- `dependencies에` `implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'`입력
- html파일은 templates에 넣는다

```java
@Controller
public class ItemController {
    @GetMapping("/list")
    String list (Model model) {
        model.addAttribute("전달할데이터이름", "데이터");
        return "list.html";
    }
}
```

```html
<!-- 전달받은 데이터를 적용 -->
<div>
  <h4 th:text="${name}"></h4>
</div>
```
