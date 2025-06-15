package com.example.spring_base.Annotation_MVC;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/*
 * JpaRepository<엔티티, ID 타입> :
 *  - 첫 번째 타입은 엔티티 클래스 (예: BasicEntity)
 *  - 두 번째 타입은 해당 엔티티의 기본키(PK)의 타입 (예: Long)
 *  - 기본적인 CRUD 메서드(findAll, findById 등)를 자동으로 제공
 *
 * findBy : 하나만 가져옴
 * findAll : 모두다 가져옴
 * findPageBy : 페이지네이션
 */

public interface Ex_Repository extends JpaRepository<Ex_Entity, String> {

    // Derived query methods
    Optional<Ex_Entity> findByName(String name);
}
