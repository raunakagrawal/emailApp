package com.raunak.email.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raunak.email.Entity.Group;
import java.util.List;


public interface GroupRepository extends JpaRepository<Group, Long>{
	Group findByGroupName(String groupName);
	
	List<Group> findByUserId(Long userId);
}
