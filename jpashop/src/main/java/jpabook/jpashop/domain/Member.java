package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // Embeddable, Embedded 둘 중에 하나만 표시해도 되는데, 지금은 둘 다 표시함.
    private Address address;

    @OneToMany(mappedBy = "member") // mappedBy : member에 의해 맵핑된 거울일 뿐이야. (읽기전용)
    private List<Order> orders = new ArrayList<>();
}
