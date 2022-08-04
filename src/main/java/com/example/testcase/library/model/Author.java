package com.example.testcase.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
}
