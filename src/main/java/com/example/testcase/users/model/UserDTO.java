package com.example.testcase.users.model;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String name;

    public static UserDTO of(User source) {
        var dto = new UserDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }
}
