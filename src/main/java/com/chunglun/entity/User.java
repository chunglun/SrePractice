package com.chunglun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    private String name;
    private String breed;
    private int birthYear;

    public User(User user) {
        this(user.getUserId(), user.getName(), user.getBreed(), user.getBirthYear());
    }
}
