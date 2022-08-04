package com.example.testcase.library.model;

import lombok.Data;

@Data
public class AuthorDTO {
    private long id;
    private String name;

    public static AuthorDTO of(Author source) {
        var dto = new AuthorDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }
}
