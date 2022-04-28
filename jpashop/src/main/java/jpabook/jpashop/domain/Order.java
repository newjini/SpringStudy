package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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


    @ManyToOne
    @JoinColumn(name = "member_id") // foreign key 는 member_id 라는 셈.
    private Member member;          // 회원과 주문 사이의 연관관계 주인.

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;    // 주문시간 ( Hybernate가 알아서 다 해줌)

    @Enumerated(EnumType.STRING)
    private OrderStatus status;         // 주문상태 [ORDER, CANCEL]

}
