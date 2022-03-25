package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestNodeService testNodeService;

    @GetMapping("/get/{value}")
    public List<User> get(@PathVariable("value") Long value) {
        System.out.println("value " + value);
        return userRepository.getUsers(value);
    }

    @GetMapping("/find-node/{name}")
    public TestNode findNode(@PathVariable("name") String name) {
        return testNodeService.findNode(name);
    }

    @PostMapping("/create-node")
    public TestNode nestedNode(@RequestBody TestNodeInput testNodeInput) {
        return testNodeService.createNode(testNodeInput);
    }
}
