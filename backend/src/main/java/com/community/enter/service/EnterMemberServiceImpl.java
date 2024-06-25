package com.community.enter.service;

import com.community.common.security.Role;
import com.community.enter.domain.dto.EnterMemberDTO;
import com.community.enter.domain.entity.EnterMemberEntity;
import com.community.enter.domain.repository.EnterMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Log4j2
@RequiredArgsConstructor
@Service
public class EnterMemberServiceImpl implements EnterMemberService{


    @Autowired
    EnterMemberRepository enterMemberRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void insert(EnterMemberDTO enterMemberDTO) {

        if(enterMemberDTO != null && enterMemberDTO.getEntrprsId() !=null){

           EnterMemberEntity enterMemberEntity = modelMapper.map(enterMemberDTO,EnterMemberEntity.class);

           enterMemberEntity.setCmnRgtrtnCrtfctnNmbr(Role.FENTER);

            enterMemberRepository.save(enterMemberEntity);

            log.info("EnterMemberService : " + enterMemberEntity);

        }


    }
}
