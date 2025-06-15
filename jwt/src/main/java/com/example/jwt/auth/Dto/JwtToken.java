package com.example.jwt.auth.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Builder :
 *  - 객체를 생성할 때, 생성자 대신 가독성 좋고 유연하게 값을 설정할 수 있도록 도와주는 빌더 패턴을 적용합니다.
 *
 * @Data :
 *  - @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 를 모두 포함
 *  - 즉, 모든 필드의 getter/setter 생성 + toString(), equals(), hashCode() 자동 생성.
 *
 * @AllArgsConstructor
 *  - 모든 필드를 파라미터로 갖는 생성자를 자동으로 생성
 */

@Builder
@Data
@AllArgsConstructor
public class JwtToken {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
