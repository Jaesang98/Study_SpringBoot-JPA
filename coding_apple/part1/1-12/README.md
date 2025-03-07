## 💡 part1-12 public private protected static (access modifiers)

### 🔹 아무것도 안붙임

- package-private이라함
- 같은 폴더의 클래스에서만 사용가능

### 🔹 public

- 모든 곳에서 가져다쓸 수 있다는 뜻

### 🔹 private

- 다른 클래스에서 사용 불가

### 🔹 protected

- 아무것도 안붙인 것과 같음
- 상속한 클래스는 맘대로 사용가능

### 🔹 getter, setter

- private된 변수를 뽑아내고 수정하기 위해 만드는 함수

```java
private String title = 'test'

// getter
public String getTitle() {
  return title;
}

// setter
public void setTitle(String title) {
  this.title = title;
}

or
@Getter
@Setter
public class Item {
  private String title = 'test'
}
```
