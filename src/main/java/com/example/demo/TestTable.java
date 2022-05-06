package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "test")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestTable {
    @Id
    private Long id;

    private String name;
}
