package com.raunak.email.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Members {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String memberName;
	
	private String accociateMember;
	
	private Long groupId;
	
	private Boolean selected;

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
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

	public String getAccociateMember() {
		return accociateMember;
	}

	public void setAccociateMember(String accociateMember) {
		this.accociateMember = accociateMember;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Members(String memberName , Long groupId) {
		this.memberName = memberName;
		this.groupId = groupId;
	}

	public Members() {
	}
	
	
}
