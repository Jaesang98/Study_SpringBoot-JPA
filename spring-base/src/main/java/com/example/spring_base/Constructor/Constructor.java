package com.example.spring_base.Constructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 객체 생성자 수동 호출
 * - Spring이 아닌 직접 new Test()로 객체 생성
 * - Spring이 관리하는 Bean이 아님
 * - Test 클래스에 @Component가 있어도, 여기선 무시됨
 */

@Controller
public class Constructor {
    Test test = new Test();

    @GetMapping("/constructor")
    @ResponseBody
    public String fc() {
        test.userid = "jsnam";
        test.username = "재상";

        System.out.println(test.userid);
        System.out.println(test.username);
        System.out.println(test.Hello());
        return "test";
    }
}