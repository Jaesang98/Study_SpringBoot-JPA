## 💡 part3-9 검색기능 2 (full text index)

### 🔹 full text index

- 컬럼에 있는 문장들에서 단어들을 다 추출해준 다음에 그 단어들을 정렬해두는 식으로 동작
- 영어는 ㄱㅊ은데 한국어 일본어 중국어는 n-gram parser사용해야함

```sql
-- 인덱스생성
CREATE FULLTEXT INDEX title_search
ON shop.item(title) WITH PARSER ngram;

```

```java
// Controller
@PostMapping("/search")
    String postSearch(@RequestParam String searchText) {
        var result = itemRepository.rawQuery1(searchText);
        System.out.println(result);
        return "redirect:/list";
    }


// Repository.js
package com.example.shop.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findPageBy(Pageable page);
    List<Item> findAllByTitleContains(String title);

    @Query(value = "select * from shop.item where match(title) against(?1)", nativeQuery = true)
    List<Item> rawQuery1(String text);
}

```
