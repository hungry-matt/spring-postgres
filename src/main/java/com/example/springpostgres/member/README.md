# Sequence 전략
insert 성능 향상과 동시성 문제 해결을 위한 테스트.

### 테스트에 사용된 Sequence
```
CREATE SEQUENCE TEST.MEMBER_SEQ START WITH 1 INCREMENT 100;

SELECT last_value FROM TEST.MEMBER_SEQ;
```

### Entity 설정
```
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "TEST.MEMBER_SEQ",
        allocationSize = 100
)
public Class {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    ...
}
```

