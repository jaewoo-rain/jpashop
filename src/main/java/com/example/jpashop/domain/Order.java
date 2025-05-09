package com.example.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY) // 다대 1 -> 오더 여러개 대 멤버 하나, 주인은 아무것도 안넣음
    @JoinColumn(name = "member_id") // DB에는 Order 테이블의 member_id 컬럼이 Long 타입(숫자)으로 저장된다. -> 기본키 이름이랑 동일할 필요 없음
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // 양방향일때, cascade -> persist(order)하면 persist(OrderItemA)까지 해줌
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL) // cascade -> order 저장하면 delevery도 자동으로 저장됨
    // 1대1관계에서 FK누구한테 둘것인가?
    // 접근 많이 하는곳에 둔다
    // delivery보다 order를 더 많이 조회할듯
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;  // 주문 상태 [ODER, CANCEL]


    // == 연관관계 메서드 == //
    // 위치는 양방향 연관관계에서 핵심적으로 컨트롤 하는 곳에
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

//    public static void main(String[] args) {
//        Member member = new Member();
//        Order order = new Order();
//        member.getOrders().add(order);
//        order.setMember(member);
//    }

//    => 연관관계 메서드에 의해서
//        public static void main(String[] args) {
//        Member member = new Member();
//        Order order = new Order();
//        order.setMember(member);
//    }
//        이렇게만 해도 됨

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
