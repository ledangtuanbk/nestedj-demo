package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Configuration
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // Nếu validate fail thì trả về 400
    public ResponseEntity<Object> handleBindException(BindException e) throws Exception {
        // Trả về message của lỗi đầu tiên
        String errorMessage = "Request không hợp lệ";
        return new ResponseEntity<Object>(e.getAllErrors().get(0).getDefaultMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
