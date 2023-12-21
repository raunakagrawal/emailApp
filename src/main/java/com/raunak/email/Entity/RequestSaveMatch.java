package com.raunak.email.Entity;

public class RequestSaveMatch {
	private Long selectedId;
	private String matchedMember;
	private Long groupId;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}
	public String getMatchedMember() {
		return matchedMember;
	}
	public void setMatchedMember(String matchedMember) {
		this.matchedMember = matchedMember;
	}
	
	
}
