package com.example.base.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/*
 * final : 변수 수정이 불가능
 * static : new 키워드로 뽑지 않아도 직접 사용가능 / 유틸에 쓴다
 *
 * 접근제어자
 *  - public : 어디서나 사용가능
 *  - default : 폴더 내 사용가능
 *  - protected : 폴더 내 사용가능
 *  - private : 같은 클래스에서만 사용가능
 */

/*
 * model : 뷰 데이터를 전달할 때 사용
 *
 * List<타입> : 리스트 자료형
 *  - Object : 아무 타입 다 들어갈 수 있음
 *  - String / Integer / Entity / DTO
 *  - ArrayList LinkedList등이 있는데 걍 List쓰면됨
 *
 * Map<key, value> :
 *  - map 자료형 대부분 마지막 Response Key에 Result Value를 넣어준다
 *  - HashMap LinkedHashMap TreeMap 등이있는데 걍 Map쓰면됨
 * 
 * Optional<타입> : 값이 있을 수도있고 없을수도 있는 자료형
 *  - isPresent() : 값이 있으면 True
 *  - isEmpty() : 값이 없으면 True
 */


/*
 * Constructor : 함수 호출 시 초기값을 설정 하는 생성자
 */

@RestController
public class DataController {
    // final
    final String name = "남재상";

    // model
    @GetMapping("/model")
    Model model(Model model) {
        model.addAttribute("name", "value");
        return model;
    }

    // ArrayList<Type> / return 타입과 함수 타입 맞춰줘야함
    @GetMapping("/List")
    List<String> List () {
        List<String> list = new ArrayList<>();
        list.add("Strong");
        list.add("JaeSang");
        return list;
    }

    // Map<Key, Value>
    @GetMapping("/Map")
    Map<String, String> Hash () {
        Map<String, String> hash = new HashMap<>();
        hash.put("key1", "value1");
        return hash;
    }

    // Optional
    //    @GetMapping("/Optional")
    //    Map<String, String> Optional () {
    //        BasicController 40번째줄
    //    }
    
    // 생성자
    Test test = new Test("bbb");

    //접근제어자 / static
    public void callTest2() {
        Test2.test5 = "바로호출";
        Test2 test2 = new Test2();
        test2.test1 = "호출됨";
        test2.test2 = "호출됨";
        test2.test4 = "호출됨";
        // test2.test3 = "호출안됨";
    }
    

}

// 생성자
class Test {
    String test ="aaa";

    // Constructor
    Test(String name) {
        this.test = name;
    }
}

// 접근제어자
class Test2 {
    // public / protected / default / private
    public String test1 = "test1";
    String test2 = "test2";
    private String test3 = "test3";
    protected String test4 = "test4";

    // static
    static String test5 = "a";
}