package com.example.spring_base.Constructor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 객체 생성자 자동 호출 (DI 방식)
 * - Spring이 Test 객체를 자동 생성하고 주입
 * - Test는 @Component로 Bean 등록되어 있어야 함
 * - 실제 서비스 개발에서 선호되는 방식
 */

@Controller
@RequiredArgsConstructor
public class Constructor2 {
    private final Test test;

    @GetMapping("/constructor2")
    @ResponseBody
    public String fc() {
        test.userid = "jsnam2";
        test.username = "재상2";

        System.out.println(test.userid);
        System.out.println(test.username);
        System.out.println(test.Hello());
        return "test";
    }
}