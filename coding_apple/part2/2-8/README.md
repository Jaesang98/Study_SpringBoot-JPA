## 💡 part2-8 수정기능 2 (숙제)

### 🔹 지난시간에 배운것

- 인풋에 값을 미리 추가해주려면 th:value

```java
@PostMapping("/edit")
    String editPost (String title, Integer price, Long id) {
        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "redirect:/list";
    }
```

```html
<form action="/edit" method="POST">
  <input name="id" th:value="${items.id}" style="display:none;" />
  <input name="title" th:value="${items.title}" />
  <input name="price" th:value="${items.price}" />
  <button type="submit">버튼</button>
</form>
```
