package com.example.spring_base.Inheritance;

public class ExampleExtend {
    ChildExtend childExtend = new ChildExtend();

    public void example() {
        System.out.println(childExtend.name);

        childExtend.human();
    }
}
