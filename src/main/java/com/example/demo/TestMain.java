package com.example.demo;

public class TestMain {
    public static void main(String[] args) {
        Child child  = Child.builder()
                .parentName("parent")
                .childName("child")
                .build();
        System.out.println(child.toString());
    }
}
