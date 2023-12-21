//package com.raunak.email.Repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.raunak.email.Entity.MatchedMember;
//
//public interface MatchMembersRepo extends JpaRepository<MatchedMember, Long>{
//	MatchedMember findByMemberName(String memberName);
//	
//	@Query("SELECT e FROM MatchedMember e WHERE e.selected IS NULL AND e.groupId = :groupId")
//	List<MatchedMember> findAllByGroup(Integer groupId);
//}
