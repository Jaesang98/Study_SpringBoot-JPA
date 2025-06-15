package com.example.spring_base.Inheritance;

public class ChildExtend extends ParentExtend{
    // 상속
    public String address = "수원";

    // 오버라이딩
    public void human() {
        System.out.println(this.name + "이는" + this.age + "살" + this.address + "에 살아요");
    }
}
