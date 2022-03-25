package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.exsio.nestedj.NestedNodeRepository;

import java.util.Random;

@Service
public class TestNodeService {

    @Autowired
    NestedNodeRepository<Long, TestNode> testNodeNestedNodeRepository;

    @Transactional
    public void initNode() {
        TestNode testNode = new TestNode();
        Random random = new Random(100);
        testNode.setName("Name " + random);
        testNodeNestedNodeRepository.insertAsFirstRoot(testNode);
    }

    @Transactional
    public TestNode createNode(TestNodeInput testNodeInput) {
        TestNode testNodeA = new TestNode();
        testNodeA.setName("A");
        testNodeNestedNodeRepository.insertAsFirstRoot(testNodeA);

        TestNode testNodeB = new TestNode();
        testNodeB.setName("B");
        testNodeNestedNodeRepository.insertAsLastChildOf(testNodeB, testNodeA);

        TestNode testNodeC = new TestNode();
        testNodeC.setName("C");
        testNodeNestedNodeRepository.insertAsLastChildOf(testNodeC, testNodeA);

        TestNode testNodeD = new TestNode();
        testNodeD.setName("D");
        testNodeNestedNodeRepository.insertAsLastChildOf(testNodeD, testNodeB);

        TestNode testNodeE = new TestNode();
        testNodeE.setName("E");
        testNodeNestedNodeRepository.insertAsLastChildOf(testNodeE, testNodeB);

        TestNode testNodeF = new TestNode();
        testNodeF.setName("F");
        testNodeNestedNodeRepository.insertAsLastChildOf(testNodeF, testNodeC);
        TestNode testNodeG = new TestNode();
        testNodeG.setName("G");
        testNodeNestedNodeRepository.insertAsLastChildOf(testNodeG, testNodeC);
        TestNode testNodeI = new TestNode();
        testNodeI.setName("I");
        testNodeNestedNodeRepository.insertAsLastChildOf(testNodeI, testNodeC);

        TestNode testNodeH = new TestNode();
        testNodeH.setName("H");
        testNodeNestedNodeRepository.insertAsLastChildOf(testNodeH, testNodeG);

        return testNodeB;
    }


    @Autowired
    JpaTestHelper jpaTestHelper;

    @Transactional
    public TestNode findNode(String symbol) {
        return jpaTestHelper.findNode(symbol);
    }

}
