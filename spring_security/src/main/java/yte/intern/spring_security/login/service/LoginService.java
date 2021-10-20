package yte.intern.spring_security.login.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import yte.intern.spring_security.login.controller.LoginRequest;
import yte.intern.spring_security.login.util.JwtUtil;

@Service
public class LoginService {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    private final AuthenticationManager authenticationManager;

    public LoginService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String login(LoginRequest loginRequest){
        var token= new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());

        Authentication authenticationToken = authenticationManager.authenticate(token);

        return JwtUtil.generateToken(authenticationToken,secretKey);

    }

}
