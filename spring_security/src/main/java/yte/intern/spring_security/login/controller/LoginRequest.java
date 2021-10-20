package yte.intern.spring_security.login.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginRequest {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
