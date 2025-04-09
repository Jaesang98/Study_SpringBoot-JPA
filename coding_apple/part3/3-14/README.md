## 💡 part3-14 JWT 회원기능 1 (수동 로그인기능)

### 🔹 JWT

```java
// build
implementation 'io.jsonwebtoken:jjwt-api:0.12.5'
implementation 'io.jsonwebtoken:jjwt-gson:0.12.5'
implementation 'io.jsonwebtoken:jjwt-impl:0.12.5'

// Controller
private final AuthenticationManagerBuilder authenticationManagerBuilder;

@PostMapping("/login/jwt")
    @ResponseBody
    String loginJWT(@RequestBody Map<String, String> data) {

        var authToken = new UsernamePasswordAuthenticationToken(data.get("username"), data.get("password"));
        var auth = authenticationManagerBuilder.getObject().authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:/list";
    }

// Util
package com.example.shop.member;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    static final SecretKey key =
            Keys.hmacShaKeyFor(Decoders.BASE64.decode(
                    "jwtpassword123jwtpassword123jwtpassword123jwtpassword123jwtpassword"
            ));

    // JWT 만들어주는 함수
    public static String createToken() {

        String jwt = Jwts.builder()
                .claim("username", "어쩌구")
                .claim("displayName", "저쩌구")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 10000)) //유효기간 10초
                .signWith(key)
                .compact();
        return jwt;
    }

    // JWT 까주는 함수
    public static Claims extractToken(String token) {
        Claims claims = Jwts.parser().verifyWith(key).build()
                .parseSignedClaims(token).getPayload();
        return claims;
    }

}
```

```html
<form>
  <input name="username" id="username" />
  <input name="password" id="password" type="password" />
</form>
<button onclick="loginJWT()">전송</button>
<script>
  function loginJWT() {
    fetch("/login/jwt", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: document.querySelector("#username").value,
        password: document.querySelector("#password").value,
      }),
    })
      .then((r) => r.text())
      .then((r) => {
        console.log(r);
      });
  }
</script>
```
