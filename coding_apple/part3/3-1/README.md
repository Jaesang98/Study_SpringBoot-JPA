## 💡 part3-1 object를 변환할 땐 DTO

### 🔹 DTO만들기기

- DTO 쓰면 타입체크가 쉬움
- 재사용이 쉬움
- 다른데도 사용가능

```java
// Controller
@GetMapping("/user/1")
    @ResponseBody
    Member getUser() {
        var a = memberRepository.findById(1L);
        var result = a.get();
        var data = new MemberDto(result.getUsername(), result.getDisplayName());
        return result;
    }

// DTO
class MemberDto {
    public String username;
    public String displayName;

    public MemberDto(String a, String b) {
        this.username = a;
        this.displayName = b;
    }
}
```
