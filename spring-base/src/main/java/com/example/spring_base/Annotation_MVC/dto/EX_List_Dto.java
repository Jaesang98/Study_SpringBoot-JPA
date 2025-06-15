package com.example.spring_base.Annotation_MVC.dto;

import com.example.spring_base.Annotation_MVC.entitiy.Ex_Entity;
import com.example.spring_base.Annotation_MVC.entitiy.Ex_Entity_List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class EX_List_Dto {
    private String username;
    private String usernickname;
    private String listname;
    private String listdescription;

    public static EX_List_Dto to_Dto(Ex_Entity_List entity_list) {
        Ex_Entity ex_entity = entity_list.getEx_entity();

        return EX_List_Dto.builder()
                .username(ex_entity.getName())
                .usernickname(ex_entity.getNickname())
                .listname(entity_list.getListname())
                .listdescription(entity_list.getDescription())
                .build();
    }
}
