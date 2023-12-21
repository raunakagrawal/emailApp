package com.raunak.email.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.email.Entity.Group;
import com.raunak.email.ErrorResponce.ResponseHandler;
import com.raunak.email.Service.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupController {
	private GroupService groupService;
	
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Group> saveCity(@RequestBody Group group) {
		Group savedGroup = groupService.createGroup(group);
        return new ResponseEntity<>(savedGroup, HttpStatus.CREATED);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/byId")
    public Group findGroupById(@RequestBody String encGroupId) {
		Group savedGroup = groupService.findGroupById(encGroupId);
        return savedGroup;
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/byUserId")
    public List<Group> findGroupByUserId(@RequestBody Long userId) {
		List<Group> savedGroup = groupService.findGroupByUserId(userId);
        return savedGroup;
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		String group = groupService.deleteById(id);
        return ResponseHandler.generateResponse(group, HttpStatus.OK, null);
    }
	
}
