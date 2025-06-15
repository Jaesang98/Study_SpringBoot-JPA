package com.example.spring_base.Annotation_MVC.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * @ManyToOne : 다대일(N:1) 관계 설정 시 사용
 *  - 여러 엔티티(자식)가 하나의 엔티티(부모)를 참조할 때 사용
 *  - 주로 외래키(FK)를 가진 쪽에 선언함
 */


@Entity
@Getter @Setter
@ToString
public class Ex_Entity_List {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String listname;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ex_Entity ex_entity;
}
