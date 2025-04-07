## 💡 part3-2 페이지 나누기 (pagination)

### 🔹 DTO만들기기

- DTO 쓰면 타입체크가 쉬움

```java
// Repository
package com.example.shop.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findPageBy(Pageable page);
}


// Controller
@GetMapping("/list/page/{page}")
String getListPage(Model model, @PathVariable Integer page) {
    Page<Item> result = itemRepository.findPageBy(PageRequest.of(page-1,5));
    model.addAttribute("items", result);
    return "list.html";
}
```
