package com.example.spring_base.Inheritance;

public class ChildImplement implements ParentImplement {
    private String name = "재상";
    private String age = "18";
    private String address = "수원";

    @Override
    public void human() {
        System.out.println(name + "이는" + age + "살 " + address + "에 살아요");
    }
}
