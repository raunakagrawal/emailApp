package com.raunak.email.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raunak.email.Dto.LoginDto;
import com.raunak.email.Dto.UserDto;
import com.raunak.email.Entity.User;
import com.raunak.email.ErrorResponce.ResponseHandler;
import com.raunak.email.Repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public ResponseEntity<Object> createUser(User user) {
	    	User emailExists = userRepository.findByEmail(user.getEmail());
	    	User userNameExists = userRepository.findByUsername(user.getUsername());
	    	if (emailExists != null) {
	    		return ResponseHandler.generateResponse("This Email is already registered.", HttpStatus.MULTI_STATUS, null);
            }else if(userNameExists != null) {
            	return ResponseHandler.generateResponse("This Username is already registered.", HttpStatus.MULTI_STATUS, null);
            } else {
	        User newUser = new User();
	        newUser.setEmail(user.getEmail());
	        newUser.setFullName(user.getFullName());
	        newUser.setPassword(user.getPassword());
	        newUser.setUsername(user.getUsername());
	        User savedUser = userRepository.save(newUser);
	        UserDto userDto = convertToUserDto(savedUser);
	        return ResponseHandler.generateResponse("Sucessfully Registered", HttpStatus.OK, userDto);
            }
	    }
	    
	    public ResponseEntity<Object> login(LoginDto login) {
	    	User user = userRepository.findByEmail(login.getEmail());
	    	if(user == null) {
	    		return ResponseHandler.generateResponse("Email Id Not Found, Please Signup", HttpStatus.OK, null);
	    	}
	    	
	    	String userPassword = user.getPassword();
	    	String loginPassword = login.getPassword();
	    	
	    	if(loginPassword.equals(userPassword)) {
	    		UserDto userDto = convertToUserDto(user);
	    		return ResponseHandler.generateResponse("Login Successfully", HttpStatus.OK, userDto);
	    	}else {
	    		return ResponseHandler.generateResponse("Password Does not Match", HttpStatus.MULTI_STATUS, null);
	    	}
	    }

	    public List<UserDto> getAllUser() {
	        List<User> User = (List<User>) userRepository.findAll();
	        List<UserDto> userDtos = new ArrayList<>();
	
	        for (User user : User) {
	            UserDto userDto = convertToUserDto(user);
	            userDtos.add(userDto);
	        }
	
	        return userDtos;
	    }
	
	    public UserDto convertToUserDto(User user) {
	        UserDto userDto = new UserDto();
	        userDto.setId(user.getId());
	        userDto.setFullName(user.getFullName());
	        userDto.setEmail(user.getEmail());
	        userDto.setUserName(user.getUsername());
	        return userDto;
	    }
	    
	    
}
