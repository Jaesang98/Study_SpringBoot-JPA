## 💡 part2-3 상세페이지 만들기 1 (Optional)

### 🔹 Optional

- null일 수도 있고 아닐 수도 있다는 타입

```java
@GetMapping("/detail/{id}")
    String detail () {
        Optional<Item> result = itemRepository.findById(1L);
        return "detail.html";
    }
```
