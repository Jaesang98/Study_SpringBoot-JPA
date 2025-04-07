## 💡 part3-8 검색기능 1 (index)

### 🔹 간단함

```java
// Repository.interface
package com.example.shop.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findPageBy(Pageable page);
    List<Item> findAllByTitleContains(String title);
}


// Item.java
package com.example.shop.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter
@Getter
@Table(indexes = @Index(columnList = "title", name = "작명"))
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private String title;
    private Integer price;
}


// Controller.java
    @PostMapping("/search")
    String postSearch(@RequestParam String searchText) {
        var result = itemRepository.findAllByTitleContains(searchText);
        System.out.println(result);
        return "redirect:/list";
    }
```
