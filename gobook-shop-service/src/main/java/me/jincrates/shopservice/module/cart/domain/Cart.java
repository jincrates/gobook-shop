package me.jincrates.shopservice.module.cart.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.jincrates.shopservice.infra.common.entity.BaseTimeEntity;
import me.jincrates.shopservice.module.member.domain.Member;

import javax.persistence.*;

@Getter @ToString
@NoArgsConstructor
@Table(name = "CART")
@Entity
public class Cart extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
