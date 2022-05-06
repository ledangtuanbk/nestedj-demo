package com.example.demo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child extends Parent{
    private String childName;

    @Builder
    public Child(String parentName, String childName){
        super(parentName);
        this.childName = childName;
    }
}
