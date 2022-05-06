package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.exsio.nestedj.model.Tree;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestNodeService testNodeService;

    @Autowired
    ModelMapper modelMapper;

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

    @PostMapping("/data")
    public String test(
            @Valid @RequestBody TestInput testInput
    ) {
        return LocalTime.now().toString() + testInput.toString();
    }

//    @Autowired
//    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/init-person-address")
    public String person() {
//        Address address = Address.builder()
//                .name("HN").build();
//        addressRepository.save(address);
//
//        Person person = Person.builder()
//                .name("Tuan")
//                .build();
//        personRepository.save(person);
//
//        PersonAddress personAddress = PersonAddress.builder()
//                .person(person)
//                .address(address)
//                .build();
//        personAddressRepository.save(personAddress);
        return LocalTime.now().toString();
    }

    @Autowired
    ObjectMapperUtils objectMapperUtils;

//    @GetMapping("/person/{id}")
//    public List<PersonDTO> getPerson(@PathVariable("id") Long id) {
//        Person person = personRepository.getById(id);
//        Person person2 = personRepository.getById(2L);
//        return objectMapperUtils.mapAll(Arrays.asList(person2, person), PersonDTO.class);
//    }

    @GetMapping("/get")
    public PersonDTO get() {

        Address address = Address.builder()
                .id(10000L)
                .name("HN")
                .build();

        PersonAddress personAddress = PersonAddress.builder()
                .address(address)
                .build();

        Person person = Person.builder()
                .name("tuan")
                .id(1L)
                .personAddresses(Arrays.asList(personAddress))
                .build();
        PersonDTO map = objectMapperUtils.map(person, PersonDTO.class);
        return map;
    }

    @Autowired
    TestARepository testARepository;

    @Autowired
    TestBRepository testBRepository;

    @GetMapping("/test-a")
    public TestAResponse testA() {
        TestB testB = TestB.builder()
                .name("testB")
                .build();
        TestA testA = TestA.builder()
                .testB(testB)
                .name("testA")
                .build();

        testARepository.save(testA);
        testB.setTestA(testA);
//        testBRepository.save(testB);
        return modelMapper.map(testA, TestAResponse.class);
    }

    @GetMapping("/test-a-remove/{id}")
    public TestBResponse testARemove(
            @PathVariable("id") Long id) {
        TestA testA = testARepository.getById(id);
        testA.setTestB(null);

//        testARepository.delete(testA);
        TestB testB = testBRepository.getById(id);
        return modelMapper.map(testB, TestBResponse.class);
    }

}
