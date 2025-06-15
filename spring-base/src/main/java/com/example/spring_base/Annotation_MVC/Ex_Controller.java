package com.example.spring_base.Annotation_MVC;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/*
 * @PreAuthorize("isAuthenticated()") : ()가 참인경우에만 API 실행
 */


/*
 * @Controller : 뷰(View)를 반환할 때 사용. (주로 JSP, Thymeleaf 등과 함께)
 * @ResponseBody : 문자열 그대로 클라이언트에 출력, 뷰(View)를 반환할 때는 삭제해야함
 * @RestController : JSON, XML 등의 데이터를 반환할 때 사용. (@Controller + @ResponseBody)
 *
 * @RequiredArgsConstructor : Constructor 자동생성 / final 또는 @NonNull 붙은 필드만 파라미터로 받음
 */
@RestController
@RequiredArgsConstructor
public class Ex_Controller {
    private final Ex_Service ex_service;

    /*
     * @GetMapping("/경로") :  GET 방식으로 들어오는 URL 요청을 해당 메서드에 연결
     *   - @RequestParam : 쿼리 파라미터를 메서드 매개변수로 받음
     */
    @GetMapping("/annotation/getController")
    Map<String, Object> GET_Controller(@RequestParam(value = "id", required = false) Long id)  {
        if (id == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("response", "id 파라미터가 없습니다.");
            return response;
        }
        return ex_service.findId(id);
    }

    @GetMapping("/annotation/getController2")
    Map<String, Object> GET_Controller2(@RequestParam(value = "name", required = false) String name)  {
        if (name == null || name.trim().isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("response", "name 파라미터가 없습니다.");
            return response;
        }
        return ex_service.findName(name);
    }

    @GetMapping("/annotation/getController3")
    Map<String, Object> GET_Controller3(@RequestParam(value = "id", required = false) Long id)  {
        if (id == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("response", "id 파라미터가 없습니다.");
            return response;
        }
        return ex_service.findList(id);
    }


    /*
     * @PostMapping : POST 방식으로 들어오는 URL 요청을 해당 메서드에 연결
     *   - @RequestBody 타입 변수 : 요청 본문(JSON 등)을 객체로 매핑해 받음
     */
    @PostMapping("/annotation/postController")
    String POST_Controller(@RequestBody(required = false) String name)  {
        if (name == null || name.isEmpty()) {
            return "이름이 없습니다!";
        }
        return "제이름은 재상입니다.";
    }
}
