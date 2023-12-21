package com.raunak.email.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raunak.email.EncryptionUtil;
import com.raunak.email.Entity.Group;
import com.raunak.email.Entity.Members;
import com.raunak.email.Entity.RequestGroupMembers;
import com.raunak.email.Entity.RequestSaveMatch;
import com.raunak.email.ErrorResponce.ResponseHandler;
import com.raunak.email.Repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class MemberService {

	private MemberRepository memberRepo;
	
//	private MatchMembersRepo matchMemberRepo;
	
	private GroupService groupService;
	
	private EncryptionUtil encryptionUtil;
	
	public MemberService(MemberRepository memberRepo, GroupService groupService,EncryptionUtil encryptionUtil) {
		this.memberRepo = memberRepo;
		this.groupService = groupService;
		this.encryptionUtil = encryptionUtil;
//		this.matchMemberRepo = matchMemberRepo;
	}
	
	public List<Members> getAllMembers(){
		return memberRepo.findAll();
	}
	
//	public List<MatchedMember> getMembersForGroup(String encId){
//		
//		Integer groupId = Integer.parseInt(encryptionUtil.decrypt(encId));
//		return matchMemberRepo.findAllByGroup(groupId);
//	}
	public List<Members> getAllMembersForGroup(String encId){
		Long groupId = Long.parseLong(encryptionUtil.decrypt(encId));
		return memberRepo.findByGroupId(groupId);
	}
	
	public List<Members> getAllMembersForGroup(Long groupId){
		return memberRepo.findByGroupId(groupId);
	}
	
	@Transactional
	public ResponseEntity<Object> saveMembers(RequestGroupMembers membersList){
		
		List<String> MemberNames = membersList.getMembersName();
		
		Group checkGroup = groupService.findByGroupName(membersList.getGroupName());
		
		if(checkGroup == null) {
			Group group = new Group(membersList.getGroupName(), membersList.getUserId());
			Group newGroup = groupService.createGroup(group) ;
			
			List<Members> members = new ArrayList<>();
			
			for(String memberName: MemberNames) {
				Members member = new Members(memberName,newGroup.getId());
				members.add(member);
			}
			
			@SuppressWarnings("unused")
			List<Members> saveMembers = memberRepo.saveAll(members);
			
			String encId = encryptionUtil.encrypt(newGroup.getId().toString());
			
			return ResponseHandler.generateResponse("Sucessfully Saved", HttpStatus.OK, encId);
		}else {
			return ResponseHandler.generateResponse("Group Name Already Present", HttpStatus.MULTI_STATUS, null);
		}
	}
	public ResponseEntity<Object> saveMatch(RequestSaveMatch requst){
		Members member = memberRepo.findById(requst.getSelectedId()).get();
		Members selectedMember = memberRepo.findByGroupIdAndMemberName(requst.getGroupId(), requst.getMatchedMember());
		if(member == null || selectedMember == null) {
			System.out.print(member);
			return ResponseHandler.generateResponse("Error", HttpStatus.OK, null);
		} else {
			member.setAccociateMember(requst.getMatchedMember());
			Members savedMember = memberRepo.save(member);
			selectedMember.setSelected(true);
			memberRepo.save(selectedMember);
			return ResponseHandler.generateResponse("Sucessfully Saved", HttpStatus.OK, savedMember);
		}
		
	}
}
