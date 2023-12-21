package com.raunak.email.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raunak.email.Entity.Members;

public interface MemberRepository extends JpaRepository<Members, Long>{
	@Query("SELECT e FROM Members e WHERE e.accociateMember IS NULL AND e.groupId = :groupId")
	List<Members> findAllByGroup(Integer groupId);
	
	List<Members> findByGroupId(Long groupId);

	Members findByGroupIdAndMemberName(Long groupId, String memberName);
	
	void deleteAllByGroupId(Long groupId);
}
