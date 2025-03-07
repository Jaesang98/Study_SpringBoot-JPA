## 💡 part1-11 HTML에 서버데이터 넣으려면

### 🔹 타임리프

- 반복문 사용 및 적용

```html
<div class="card" th:each="items : ${items}">
  <img src="https://placehold.co/300" />
  <div>
    <h4 th:text="${items.title}">바지</h4>
    <p th:text="${items.price}">7억</p>
  </div>
</div>
```

### 🔹 @ToString

- 롬복을 통해 데이터를 뽑아준다

```bash
Entity파일에서 @ToString 선언해준다
Controller파일에서 System.out.println(result.toString()); 선언
```
