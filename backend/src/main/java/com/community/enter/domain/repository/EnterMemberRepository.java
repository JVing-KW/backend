package com.community.enter.domain.repository;

import com.community.enter.domain.entity.EnterMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterMemberRepository extends JpaRepository<EnterMemberEntity,Long> {
}
