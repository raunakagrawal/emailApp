package com.raunak.email.Entity;

import java.util.List;

public class RequestGroupMembers {
	
	private String groupName;
	
	private Long userId;
	
	private List<String> membersName;
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<String> getMembersName() {
		return membersName;
	}
	public void setMembersName(List<String> membersName) {
		this.membersName = membersName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
