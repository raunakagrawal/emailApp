package com.raunak.email.Entity;

public class MatchedMember {

	private Long id;

	private String memberName;
	
	private Boolean selected;
	
	private Long groupId;
	

	public MatchedMember() {

	}

	public MatchedMember(String memberName, Long groupId) {
		this.memberName = memberName;
		this.groupId = groupId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	
}
