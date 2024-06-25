package com.community.enter.domain.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class EnterMemberDTO {

    private String entrprsId;

    private String entrprsPswrd;

    private String cmnRgtrrtnNmbr;

    private String entrprsPicName; // 기업담당자_이름

    private String entrprsPicEml; // 기업담당자_이메일_주소

    private String  entrprsName;

    private String entrprsPicMp; // 기업담당자_휴대폰

    private String entrprsEmlRcvYn; // 기업담당자_이메일_수신_여부

    private String entrprsPrvcyTrmsYn; // 회원 개인정보 약관 동의 여부

    private String gndrCtryCd;
}
