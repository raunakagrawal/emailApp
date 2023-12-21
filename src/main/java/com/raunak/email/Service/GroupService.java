package com.raunak.email.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raunak.email.EncryptionUtil;
import com.raunak.email.Entity.Group;
import com.raunak.email.Repository.GroupRepository;
import com.raunak.email.Repository.MemberRepository;

import jakarta.transaction.Transactional;

@Service
public class GroupService {
	
	private GroupRepository groupRepo;
	private MemberRepository memberRepo;
	
	private EncryptionUtil encryptionUtil;
	
	public GroupService(GroupRepository groupRepo,EncryptionUtil encryptionUtil, MemberRepository memberRepo) {
		this.groupRepo = groupRepo;
		this.encryptionUtil = encryptionUtil;
		this.memberRepo = memberRepo;
	}
	
	public List<Group> getAllGroups() {
        return (List<Group>) groupRepo.findAll();
    }
	
	public Group createGroup(Group group) {
		return groupRepo.save(group);
	}
	
	public Group findByGroupName(String groupName) {
		return groupRepo.findByGroupName(groupName);
	}
	
	public Group findGroupById(String encGroupId) {
		Long groupId = Long.parseLong(encryptionUtil.decrypt(encGroupId));
		return groupRepo.findById(groupId).get();
	}
	
	public List<Group> findGroupByUserId(Long userid) {
		return groupRepo.findByUserId(userid);
	}
	@Transactional
	public String deleteById(Long groupId) {
		groupRepo.deleteById(groupId);
		memberRepo.deleteAllByGroupId(groupId);
		return "SuccessFully Deleted";
	}

}
