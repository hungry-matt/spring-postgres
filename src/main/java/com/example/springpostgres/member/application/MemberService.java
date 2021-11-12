package com.example.springpostgres.member.application;

import com.example.springpostgres.member.domain.Member;
import com.example.springpostgres.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }

    @Transactional
    public void saveAll(List<Member> members) {
        memberRepository.saveAll(members);
    }
}
