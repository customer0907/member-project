package com.example.member.service;

import com.example.member.dto.MemberDTO;
import com.example.member.entity.MemberEntity;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // spring이 관리해주는 객체. 즉 Spring bean
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository; // 생성자 주입
    public void save(MemberDTO memberDTO) {
        // 1. dto 객체 -> entity 변환
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        // 2.repository의 save 메서드 호출
        memberRepository.save(memberEntity); // save는 jpa에서 제공하는 method로, 현재 함수 이름인 save와는 다름. 함수 이름은 join으로 설정해도 됨.
        // Hibernate: insert into member_table (member_email, member_name, member_password) values (?, ?, ?) spring JPA가 insert query를 만들어줬다고 생각할 수 있음.
    }
}
