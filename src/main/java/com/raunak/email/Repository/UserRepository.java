package com.raunak.email.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raunak.email.Entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	User findByUsername(String username);
}
