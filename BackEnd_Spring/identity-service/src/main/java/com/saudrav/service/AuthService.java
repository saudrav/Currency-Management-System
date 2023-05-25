package com.saudrav.service;

import com.saudrav.dto.AuthResponse;
import com.saudrav.entity.UserRecords;
import com.saudrav.jwtUtil.JwtService;
import com.saudrav.repository.UserRecordsRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRecordsRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserRecords userRecords) {
    	
    	userRecords.setPassword(passwordEncoder.encode(userRecords.getPassword()));
    	Optional<UserRecords> credential = repository.findByUsername(userRecords.getUsername());
    	if(credential.isEmpty()) {
    		repository.save(userRecords);
            return "user added to the system";
    	}
    	return "User "+userRecords.getUsername()+" already exist in sysytem";
    }
    

    public AuthResponse generateTokenandUserRole(String username) {
    	
    	Optional<UserRecords> credential = repository.findByUsername(username);
    	
    	return new AuthResponse(username, jwtService.generateToken(username), credential.get().getRole());    	
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}
