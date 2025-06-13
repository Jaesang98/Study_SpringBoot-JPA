package com.example.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

/* 애너테이션 설명
 * 
 * BasicController 클래스를 Controller / Test 함수를 API 라고 칭한다
 *
 * @Controller : 뷰(View)를 반환할 때 사용. (주로 JSP, Thymeleaf 등과 함께)
 *
 * @ResponseBody : 문자열 그대로 클라이언트에 출력, 뷰(View)를 반환할 때는 삭제해야함
 *
 * @RestController : JSON, XML 등의 데이터를 반환할 때 사용. (@Controller + @ResponseBody)
 *
 * @GetMapping("/경로") :  GET 방식으로 들어오는 URL 요청을 해당 메서드에 연결
 *   - @RequestParam("파라미터") 타입 변수 : 쿼리 파라미터를 메서드 매개변수로 받음
 *
 * @PostMapping : POST 방식으로 들어오는 URL 요청을 해당 메서드에 연결
 *   - @RequestBody 타입 변수 : 요청 본문(JSON 등)을 객체로 매핑해 받음
 *
 * @RequiredArgsConstructor : Constructor 자동생성 / final 또는 @NonNull 붙은 필드만 파라미터로 받음
 * 
 * @PreAuthorize("isAuthenticated()") : ()가 참인경우에만 API 실행
 */


/*
 * ResponseEntity : HTTP 상태 코드, 헤더, 바디를 직접 설정해서 반환할 수 있게 해주는 객체
 *  - 자세한 사항은 HTTP status code 가이드 확인
 *
 * Spring IoC Container :
 *  - 객체(Bean)를 생성하고, 생명주기 및 의존성을 관리하는 컨테이너
 *  - ApplicationContext가 대표적인 IoC 컨테이너
 *
 * Bean :
 *  - Spring IoC Container가 생성하고 관리하는 객체
 *  - @Component, @Service, @Repository, @Controller 등을 통해 등록됨
 */


@Controller
@RequiredArgsConstructor
public class BasicController {
    private final BasicRepository basicRepository;
    private final BasicService basicService;

    @GetMapping("/")
    @ResponseBody
    private List<BasicEntity> Get(@RequestParam("name") String name) {
        // 타입은 Entity로
        List<BasicEntity> result = basicRepository.findAll();
        Optional<BasicEntity> result2 = basicRepository.findById(1L);

        if (result2.isPresent()) {
            System.out.println(result2.get());
        }
        return result;
    }

    @PostMapping("/")
    @ResponseBody
    private ResponseEntity<Map<String,Object>> Post(@RequestBody BasicEntity basic) {
        Map<String, Object> result = new HashMap<>();

        // try catch는 글로벌 Excepiton보다 우선순위가 높다
        try {
            basicRepository.save(basic);
            result.put("result", basic);

            return ResponseEntity.ok(result);
        }
        catch (Exception e) {
            result.put("error", e.getMessage());
            return ResponseEntity.status(500).body(result);
        }
    }

    @GetMapping("/Service")
    @ResponseBody
    private List<BasicEntity> Service(@RequestParam("service") BasicEntity data) {
        return basicService.Service(data);
    }

    @GetMapping("/userInfo")
    @ResponseBody
    // 현재 로그인 된 유저의 정보
    private Authentication user(Authentication auth) {
        System.out.println(auth);
        System.out.println(auth.getAuthorities().contains(new SimpleGrantedAuthority("User"))); //권한 가지고있는지 확인

        // getPrincipal() : 로그인한 사용자의 주요 정보를 가져오는 메소드
        CustomUser result = (CustomUser) auth.getPrincipal();
        System.out.println(result.title);
        return auth;
    }
}
