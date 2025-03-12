## 💡 part2-4 상세페이지 만들기 2 & 예외처리

### 🔹 상세페이지 만들기

```java
@GetMapping("/detail/{id}")
    String detail (@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("items", result.get());
        }
        else {
            return "redirect:/list";
        }
        return "detail.html";
    }
```

### 🔹 a링크를 타임리프로 만드는법

```html
<a th:href="@{'/detail/' + ${items.id}}">링크</a>
```
