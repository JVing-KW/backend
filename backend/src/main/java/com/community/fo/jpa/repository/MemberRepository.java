package com.community.fo.jpa.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.community.fo.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
	//Jpql
	MemberEntity findByMbrIdAndMbrPswrd(String mbrId, String mbrPswrd);

	@Query("SELECT m FROM MemberEntity m WHERE m.id = :userId")
	MemberEntity findByUserId(@Param("userId") String userId);
	
	MemberEntity findByMbrEmlAdrs(String mbrEmlAdrs);

	Optional<MemberEntity> findByMbrId(String mbrId);
	

}