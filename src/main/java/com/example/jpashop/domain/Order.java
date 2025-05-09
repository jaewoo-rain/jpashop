package com.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne // 다대 1 -> 오더 여러개 대 멤버 하나, 주인은 아무것도 안넣음
    @JoinColumn(name = "member_id") // DB에는 Order 테이블의 member_id 컬럼이 Long 타입(숫자)으로 저장된다. -> 기본키 이름이랑 동일할 필요 없음
    private Member member;

    @OneToMany(mappedBy = "order") // 양방향일때
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    // 1대1관계에서 FK누구한테 둘것인가?
    // 접근 많이 하는곳에 둔다
    // delibery보다 order를 더 많이 조회할듯
    @JoinColumn(name = "delibery_id")
    private Delibery delibery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;  // 주문 상태 [ODER, CANCEL]




}
