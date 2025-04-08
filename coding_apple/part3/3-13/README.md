## 💡 part3-13 주문기능 4 (@OneToMany)

### 🔹 ManyToOne

- 전부다 쓸거 아니면 LAZY
- 전부다 쓸거면 fetch 쓰는게 좋음

```java
// 항상 가져옴
@ManyToOne(fetch = FetchType.EAGER)

// 필요할떄만 가져옴
@ManyToOne(fetch = FetchType.LAZY)
```

### 🔹 OneToMany

- 행들 자동출력

```java
    @OneToMany(mappedBy = "member")
    List<Sales> sales = new ArrayList<>();
```

### 🔹 결론

- 현재테이블 = OneToMany, 상대테이블 = ManyToOne
- OneToMany는 별루 안씀
- 대신 테이블 관계파악, 행 지울 때 관련된 행 자동삭제 가능
