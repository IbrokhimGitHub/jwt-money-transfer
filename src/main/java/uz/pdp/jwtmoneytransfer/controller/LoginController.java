package uz.pdp.jwtmoneytransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uz.pdp.jwtmoneytransfer.payload.LoginDto;
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
    public HttpEntity<?> loginToSystem(@RequestBody LoginDto loginDto) {
        try {
            Authentication authenticate = authenticatidonManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(),
                    loginDto.getPassword()
            ));
            String token = jwtProvider.tokenGenerator(loginDto.getUsername());
            System.out.println(authenticate);
            System.out.println(token);
            return ResponseEntity.ok(token);
        }catch (BadCredentialsException e){
            return ResponseEntity.status(401).body("went wrong");
        }
    }
}
