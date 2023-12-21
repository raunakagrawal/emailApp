package com.raunak.email.Dto;

public class UserDto {

    private Long id;

    private String fullName;

    private String email;
	
	private String userName;
    
    public UserDto() {
    }

	public UserDto(Long id, String fullName, String email, String mobileNo, String gender, String role, Integer age,
			String dob,String userName) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long long1) {
		this.id = long1;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	
}