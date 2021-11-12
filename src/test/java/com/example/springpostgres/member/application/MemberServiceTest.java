package com.example.springpostgres.member.application;

import com.example.springpostgres.member.domain.Member;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void save() {
        String name = UUID.randomUUID().toString();
        Member member = Member.builder()
                        .name(name)
                        .build();

        memberService.save(member);

        System.out.println(member.getId());
    }

    @Test
    void saveAll() {
        List<Member> members = new ArrayList<>();
        int count = 100;

        while (--count >= 0) {
            String name = UUID.randomUUID().toString();
            members.add(Member.builder()
                    .name(name)
                    .build());
        }

        memberService.saveAll(members);
    }
}