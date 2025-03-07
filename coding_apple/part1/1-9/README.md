## 💡 part1-9 테이블 만들기 (Entity)

### 🔹 테이블 만들기

- orm 라이브러리가 있는경우

```java
// Item
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false, unique = true)
    @Column(columnDefinition = "Text")
    @Column(length = 1000)
    public String title;
    public Integer price;
}
```
