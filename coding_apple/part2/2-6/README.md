## 💡 part2-6 Service 레이어로 분리하려면

### 🔹 레이어로 분리

- Controller는 보통 데이터나 html을 보내는 역할을 한다
- Service는 검사 및 DB입출력을 할 때 사용한다

```java
// Service.java
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }
}

// Controller
private final ItemService itemService;
@PostMapping("/add")
    String addPost (String title, Integer price) {
        itemService.saveItem(title, price);
        return "redirect:/list";
    }
```
