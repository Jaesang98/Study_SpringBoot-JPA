## 💡 part2-1 상품 추가기능 1 (Map 자료형)

### 🔹 Map

- 오브젝트 같은 느낌임

```java
// 만드는방법
Map<String, String> test = new HashMap<>();
test.put("name", "kim");
```

### 🔹 데이터 받기

```html
<!-- wrtie.html -->
<form action="/add" method="POST">
  <input name="title" />
  <input name="price" />
  <button type="submit">버튼</button>
</form>
```

```java
// controller
@PostMapping("/add")
    String addPost (@RequestParam Map formData) {
        System.out.println(formData.get("title"));
        System.out.println(formData.get("price"));
        return "redirect:/list";
    }

or

@PostMapping("/add")
    String addPost (String title, String price) {
        System.out.println(title);
        System.out.println(price);
        return "redirect:/list";
    }
```
