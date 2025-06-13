package com.example.test;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * @Entity : JPA 기능으로 자동으로 테이블 생성 or 매핑
 *
 * @Id : 기본 키(PK)로 지정 / 반드시 하나 이상 있어야 한다 / 보통 Long, Integer 등 사용
 *  - @GeneratedValue(strategy = GenerationType.IDENTITY) : 추가될 때 마다 Auto increment 기능을 부여
 *
 * @Column : 필드를 DB의 컬럼으로 매핑하며, 다양한 속성 지정 가능
 *  - nullable = false        : 해당 컬럼은 null을 허용하지 않음 (NOT NULL)
 *  - unique = true           : 해당 컬럼 값은 유일해야 함 (UNIQUE 제약조건)
 *  - columnDefinition = "TEXT" : DB 컬럼의 타입을 직접 지정 (예: TEXT, VARCHAR 등)
 *
 * @ToString : sout 또는 log 출력 시 객체의 필드값을 문자열로 자동 출력
 * - 안쓰면 출력 시 객체 주소형태로 나옴
 * 
 * @Getter @Setter : getter / setter 메서드를 자동 생성
 */

@Entity
@Getter @Setter
@ToString
public class BasicEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String title;

    @Column(nullable = false, unique = true)
    private String userid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    private Integer price;
}
