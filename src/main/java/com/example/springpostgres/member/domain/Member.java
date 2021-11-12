package com.example.springpostgres.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(schema = "TEST")
@NoArgsConstructor
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "TEST.MEMBER_SEQ",
        allocationSize = 100
)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Builder
    public Member(String name) {
        this.name = name;
    }

}
