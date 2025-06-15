package com.example.spring_base.Annotation_MVC.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * @ManyToOne : 다른 테이블 조인
 *  - LAZY : 필요할때만 가져옴
 *  - EAGER : 미리 가져옴
 *
 * @JoinColumn : 컬럼명
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
    @JoinColumn(
            name="ex_entity_id"
    )
    private Ex_Entity ex_entity;
}
