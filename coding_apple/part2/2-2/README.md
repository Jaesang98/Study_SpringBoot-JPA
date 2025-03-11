## 💡 part2-2 상품 추가기능 2 & Navbar 만들기

### 🔹 값 DB에 넣기

- 롬복으로 Getter Setter만드는건 의미가없기때문에 그냥 직접 만드는게 좋다

```java
@PostMapping("/add")
    String addPost (String title, Integer price) {
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        return "write.html";
    }

or

@PostMapping("/add")
    String addPost (@ModelAttribute Item item) {
        itemRepository.save(item);
        return "redirect:/list";
    }

```

### 🔹 fragment

- 타임리프 문법
- 별도의 파일을 import해서 사용가능

```html
<!-- nav.html -->
<div class="nav" th:fragment="navbar">
  <a class="logo">SpringMall</a>
  <a>List</a>
  <a>Write</a>
</div>

<!-- write.html -->
<div th:replace="~{ nav.html::navbar }"></div>
```
