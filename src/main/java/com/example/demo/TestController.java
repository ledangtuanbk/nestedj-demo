package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.exsio.nestedj.model.Tree;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestNodeService testNodeService;

    @GetMapping("/init-tree")
    public TestNode initTree() {
        return testNodeService.initTree();
    }

    @GetMapping("/build-tree")
    public void buildTree() {
        testNodeService.buildTree();
    }

    @GetMapping("/get/{value}")
    public List<User> get(@PathVariable("value") Long value) {
        System.out.println("value " + value);
        return userRepository.getUsers(value);
    }

    @GetMapping("/find-node/{name}")
    public List<TestNode> findNode(@PathVariable("name") String name) {
        return testNodeService.findNode(name);
    }

    @GetMapping("/find-node-by-level/{level}")
    public List<TestNode> findNode(@PathVariable("level") Integer level) {
        return testNodeService.findNodeByLevel(level);
    }

    @PostMapping("/create-new-node/{parentId}")
    public TestNode createNewNode(@RequestBody TestNodeInput testNodeInput, @PathVariable("parentId") Long parentId) {
        return testNodeService.createNewNode(testNodeInput, parentId);
    }

    @GetMapping("/get-tree/{id}")
    public Tree<Long, TestNode> getTree(@PathVariable("id") Long id) {
        return testNodeService.getTree(id);
    }
}
