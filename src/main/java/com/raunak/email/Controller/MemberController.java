package com.raunak.email.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.email.Entity.Members;
import com.raunak.email.Entity.RequestGroupMembers;
import com.raunak.email.Entity.RequestSaveMatch;
import com.raunak.email.Service.MemberService;

@RestController
@CrossOrigin(origins = "*")				
@RequestMapping("/members")
public class MemberController {

	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Members>> getAllMembers() {
		List<Members> members = memberService.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/all")
    public ResponseEntity<List<Members>> getAllMembersFromGroup(@RequestBody String groupId) {
		List<Members> members = memberService.getAllMembersForGroup(groupId);
        return new ResponseEntity<>(members, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/groupmember/{groupId}")
    public ResponseEntity<List<Members>> getAllMembersFromGroup(@PathVariable Long groupId) {
		List<Members> members = memberService.getAllMembersForGroup(groupId);
        return new ResponseEntity<>(members, HttpStatus.OK);
	}
//    @PostMapping("/encrypt")
//    public ResponseEntity<String> encrypt(@RequestParam Long groupId) {
//		String members = encryptionUtil.encrypt(groupId.toString());
//        return new ResponseEntity<>(members, HttpStatus.OK);
//	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ResponseEntity<Object> saveMembers(@RequestBody  RequestGroupMembers membersList ) {
        return memberService.saveMembers(membersList);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/savematch")
    public ResponseEntity<Object> saveMatch(@RequestBody  RequestSaveMatch request ) {
        return memberService.saveMatch(request);
	}
}
