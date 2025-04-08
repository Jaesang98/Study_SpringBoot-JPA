## 💡 part3-12 주문기능 3 (JOIN FETCH)

### 🔹 ManyToOne 단점

- select문을 너무 많이 가져온다

### 🔹 ManyToOne 극복

- JPQL사용

```java
    @Query(value = "SELECT s FROM Sales s JOIN FETCH s.member")
    List<Sales> customFindAll();
```
