package com.saudrav.controller;

import com.saudrav.dto.AuthRequest;
import com.saudrav.dto.AuthResponse;
import com.saudrav.dto.UserRegistration;
import com.saudrav.dto.UserRegistration;
import com.saudrav.entity.UserRecords;
import com.saudrav.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserRegistration user) {
    	UserRecords userRecords = new UserRecords();
    	userRecords.setName(user.getName());
    	userRecords.setEmail(user.getEmail());
    	userRecords.setUsername(user.getUsername());
    	userRecords.setPassword(user.getPassword());
    	userRecords.setRole("USER");
        return service.saveUser(userRecords);
    }

    @PostMapping("/token")
    public ResponseEntity<AuthResponse> getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
        	AuthResponse authResponse = service.generateTokenandUserRole(authRequest.getUsername());
            return ResponseEntity.status(HttpStatus.OK).body(authResponse);
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
