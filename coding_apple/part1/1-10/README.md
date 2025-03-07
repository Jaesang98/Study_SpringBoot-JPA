## 💡 part1-10 DB 데이터 출력하려면

### 🔹 Lombok

- 필요한 코드를 자동으로 생성해줘서 자바 코드 양을 매우 줄여주는 간단한 라이브러리

```bash
# gradle
compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'

# setting
annotation processors
Enable annotation processing 체크

plugin lombok 다운
```

### 🔹 DB데이터 입출력

- interface 파일생성

```java
//interface
public interface ItemRepository extends JpaRepository<Item, Long> {

}

//Controller
@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list (Model model) {
        List<Item> result = itemRepository.findAll();
        System.out.println(result.get(0));
        model.addAttribute("name", "홍길동");
        return "list.html";
    }
}

```
