package com.example.demo;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Builder
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;


}
