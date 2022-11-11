package me.jincrates.shopservice.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.jincrates.shopservice.domain.BaseTimeEntity;
import me.jincrates.shopservice.domain.enumtype.MemberRole;

import javax.persistence.*;

@Getter @ToString
@NoArgsConstructor
@Table(name = "MEMBER")
@Entity
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

//    public static Member createMember(MemberRequest request)

}