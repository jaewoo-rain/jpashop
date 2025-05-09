package com.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delibery {

    @Id
    @GeneratedValue
    @Column(name = "delibery_id")
    private Long id;

    @OneToOne(mappedBy = "delibery")
    // 1대1관계에서 FK누구한테 둘것인가?
    // 접근 많이 하는곳에 둔다
    // delibery보다 order를 더 많이 조회할듯
    private Order order;

    @Embedded // 내장타입
    private Address address;

    @Enumerated(EnumType.STRING) // ordinal이 기본인데 그러면 문제생김, 숫자로 생각해서 중간에 넣으면 이상해짐
    private DeliveryStatus deliveryStatus; // READY, COMP
}
