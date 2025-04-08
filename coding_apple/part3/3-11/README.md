## 💡 part3-11 주문기능 2 (@ManyToOne)

### 🔹 주문

```java
// Entity - 시간 알아서 채워줌
@CreationTimestamp
LocalDateTime created;


// Entity - 해당 컬럼과 연결된 테이블들을 가져온다
@ManyToOne
@JoinColumn(name="member_id", foreignKey = @ForeignKey())
private Member memberId;
```
