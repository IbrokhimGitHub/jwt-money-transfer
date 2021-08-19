package uz.pdp.jwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uz.pdp.jwtmoneytransfer.securtity.JwtProvider;
import uz.pdp.jwtmoneytransfer.service.AuthorizationService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticatidonManager;
    @PostMapping("login")
    public HttpEntity<?> loginToSystem(@RequestBody ){
        try{

        }
    }
}
