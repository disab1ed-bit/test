package com.example.testcase.library.model;

import lombok.Data;

@Data
public class BookDTO {
    private long id;
    private String name;

    public static BookDTO of(Book source) {
        var dto = new BookDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }
}
