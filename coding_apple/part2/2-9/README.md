## 💡 part2-9 삭제기능 1 (AJAX, query string)

### 🔹 AJAX

- html의 form은 get post밖에 못하는데 얘는 다됨

```javascript
document.querySelectorAll(".btn")[0].addEventListener("click", function () {
  fetch("/test1", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title: "kim", price: 123 }),
  });
});

or;

// 이건 Get
document.querySelectorAll(".btn")[0].addEventListener("click", function () {
  fetch("/test1?title=kim&price=123");
});
```

```java
@PostMapping("/test1")
    String test1 (@RequestBody Map<String, Object> body) {
        System.out.println(body);
        return "redirect:/list";
    }
```
