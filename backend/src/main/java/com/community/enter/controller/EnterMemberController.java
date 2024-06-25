package com.community.enter.controller;


import com.community.enter.domain.dto.EnterMemberDTO;
import com.community.enter.domain.entity.EnterMemberEntity;
import com.community.enter.service.EnterMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/enter")
public class EnterMemberController {

    @Autowired
    EnterMemberService enterMemberService;
    // ResponseEntity로 상태 코드만 전달,

    @RequestMapping("/register")
    public ResponseEntity register(@RequestBody EnterMemberDTO enterMemberDTO){
//        public ResponseEntity register(@RequestBody Map<String,String> map){

        log.info(enterMemberDTO.getGndrCtryCd());
            enterMemberService.insert(enterMemberDTO);
            log.info("badRequest" + enterMemberDTO);


        log.info("okrequest" + enterMemberDTO);



        return ResponseEntity.ok().build();
    }

}
