package com.example.demo;

import pl.exsio.nestedj.config.jpa.discriminator.MapJpaTreeDiscriminator;

import java.util.Collections;

public class TestJpaTreeDiscriminator extends MapJpaTreeDiscriminator<Long, TestNode> {

    public TestJpaTreeDiscriminator() {
        super(Collections.singletonMap("discriminator", () -> "tree_1"));
    }
}
