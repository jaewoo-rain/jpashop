package com.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장타입이다 라는 표시 -> 내장타입은 객체처럼 그냥 들어있는거임 -> 함수처럼 여러번 쓸거를 한번에 작성한다
    private Address address;

    @OneToMany(mappedBy = "member") // 1대 다 -> 멤버 1개에 오더 여러개, 주인아님 연관관계 거울임 - order테이블에 있는 member 필드에 매핑 된거임 => 읽기전용
    private List<Order> orders = new ArrayList<>();

}
