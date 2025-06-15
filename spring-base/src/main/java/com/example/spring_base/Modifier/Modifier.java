package com.example.spring_base.Modifier;

/**
 * static : 선언 시 다른 클래스에서 객체 호출 없이 사용가능
 * - 상수정의, 유틸리티 메서드에 사용한다
 *
 * final : 값을 변경할 수 없당
 **/
public class Modifier {
    public static String name = "재상!";
    public static final String age = "18";

    public static String name() {
        return "재상재상!";
    }
}
