package com.community.community;

import com.community.enter.domain.entity.EnterMemberEntity;
import com.community.enter.service.EnterMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@RequiredArgsConstructor
@SpringBootTest
class CommunityApplicationTests {

	@Autowired
	EnterMemberService service;
	@Test
	void contextLoads() {


	}

	@Test
	public void insertTest(){
//		EnterMemberEntity enterMember=	EnterMemberEntity.builder()
//				.gndrCtryCd("남자")
//				.entrprsId("estsoft")
//				.entrprsPswrd("12341234")
//				.entrprsName("est")
//				.entrprsPicName("이기우")
//				.entrprsPicEml("rldn4743")
//				.entrprsPicMp("01072114743")
//				.entrprsEmlRcvYn(true)
//				.entrprsPrvcyTrmsYn(true)
//				.build();
//		log.info(enterMember);
	}


}
