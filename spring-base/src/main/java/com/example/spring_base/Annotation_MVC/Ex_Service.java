package com.example.spring_base.Annotation_MVC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * @Service : 비즈니스 로직을 담는 클래스
 */
@Service
@RequiredArgsConstructor
public class Ex_Service {
    private final Ex_Repository ex_repository;

    public Map<String, Object> findId(String id) {
        Optional<Ex_Entity> result = ex_repository.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (result.isPresent()) {
            Ex_Dto dto = Ex_Dto.to_Dto(result.get());
            response.put("response", result.get());
        } else {
            response.put("response", "값이 없음");
        }

        return response;
    }

    public Map<String, Object> findName(String name) {
        Optional<Ex_Entity> result = ex_repository.findByName(name);
        Map<String, Object> response = new HashMap<>();

        if (result.isPresent()) {
            Ex_Dto dto = Ex_Dto.to_Dto(result.get());
            response.put("response", result.get());
        } else {
            response.put("response", "값이 없음");
        }

        return response;
    }
}
