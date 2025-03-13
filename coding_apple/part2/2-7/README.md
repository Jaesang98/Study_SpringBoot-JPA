## 💡 part2-7 수정기능 1

### 🔹 지난시간에 배운것

- 인풋에 값을 미리 추가해주려면 th:value

```java
    @GetMapping("/edit/{id}")
    String edit (@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("items", result.get());
        }
        else {
            return "redirect:/list";
        }
        return "edit.html";
    }
```
