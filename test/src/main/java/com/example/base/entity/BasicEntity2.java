package com.example.base.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * @ManyToOne : 다른 테이블 조인
 * @JoinColumn : 컬럼명
 */

@Entity
@Getter @Setter
@ToString
public class BasicEntity2 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name="basicId"
    )
    private BasicEntity basicEntity;

    @Column(nullable = false)
    private String good;
}
