package com.example.spring_base.Annotation_MVC.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/*
 * @Entity : JPA 기능으로 자동으로 테이블 생성 or 매핑
 *
 * @ToString : sout 또는 log 출력 시 객체의 필드값을 문자열로 자동 출력
 * - 안쓰면 출력 시 객체 주소형태로 나옴
 *
 * @Getter @Setter : getter / setter 메서드를 자동 생성
 */
@Entity
@Getter @Setter
@ToString
public class Ex_Entity {
    /*
     * @Id : 기본 키(PK)로 지정 / 반드시 하나 이상 있어야 한다 / 보통 Long, Integer 등 사용
     *  - @GeneratedValue(strategy = GenerationType.IDENTITY) : 추가될 때 마다 Auto increment 기능을 부여
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /*
     * @Column : 필드를 DB의 컬럼으로 매핑하며, 다양한 속성 지정 가능
     *  - nullable / unique / columnDefinition 등등
     */
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;
}
