package com.vighnesh.battleship.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class User {
    private String name;
    private String email;
    public String password;
}
