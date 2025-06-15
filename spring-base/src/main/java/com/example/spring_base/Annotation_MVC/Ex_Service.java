package com.example.spring_base.Annotation_MVC;

import com.example.spring_base.Annotation_MVC.dto.EX_List_Dto;
import com.example.spring_base.Annotation_MVC.dto.Ex_Dto;
import com.example.spring_base.Annotation_MVC.entitiy.Ex_Entity;
import com.example.spring_base.Annotation_MVC.entitiy.Ex_Entity_List;
import com.example.spring_base.Annotation_MVC.repository.Ex_List_Repository;
import com.example.spring_base.Annotation_MVC.repository.Ex_Repository;
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
    private final Ex_List_Repository ex_list_repository;

    public Map<String, Object> findId(Long id) {
        Optional<Ex_Entity> result = ex_repository.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (result.isPresent()) {
            Ex_Dto dto = Ex_Dto.to_Dto(result.get());
            response.put("response", dto);
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
            response.put("response", dto);
        } else {
            response.put("response", "값이 없음");
        }

        return response;
    }

    public Map<String, Object> findList(Long id) {
        Optional<Ex_Entity_List> result = ex_list_repository.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (result.isPresent()) {
            EX_List_Dto dto = EX_List_Dto.to_Dto(result.get());
            response.put("response", dto);
        } else {
            response.put("response", "값이 없음");
        }

        return response;
    }
}
