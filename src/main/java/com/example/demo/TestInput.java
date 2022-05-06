package com.example.demo;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TestInput {

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Email
    private String email;

}
