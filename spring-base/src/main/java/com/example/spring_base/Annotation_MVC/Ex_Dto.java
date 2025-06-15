package com.example.spring_base.Annotation_MVC;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/*
 * @Builder : 객체 생성 시 필드 순서에 상관없이 명확하게 설정할 수 있음
 */

@Getter @Setter
@Builder
public class Ex_Dto {
    private Long id;
    private String name;
    private String nickname;

    public static Ex_Dto to_Dto(Ex_Entity entity) {
        return Ex_Dto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .nickname(entity.getNickname())
                .build();
    }
}
