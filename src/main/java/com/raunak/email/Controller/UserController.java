package com.raunak.email.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.email.Dto.LoginDto;
import com.raunak.email.Dto.UserDto;
import com.raunak.email.Entity.User;
import com.raunak.email.ErrorResponce.ResponseHandler;
import com.raunak.email.Service.UserService;
import com.raunak.email.Service.ValidationService;

@RestController
@RequestMapping("/users")
@CrossOrigin(maxAge = 3600)
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUser();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
		try {
			ValidationService.validate(user);
			return userService.createUser(user); 
		} catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody LoginDto login ) {
        return userService.login(login);
    }
}