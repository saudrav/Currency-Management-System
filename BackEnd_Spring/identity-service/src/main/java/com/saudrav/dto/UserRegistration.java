package com.saudrav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {

    private int id;
    private String name;
    private String email;
    private String username;  
    private String password;
}
