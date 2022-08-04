package com.example.testcase.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

}
