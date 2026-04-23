package model.s02;

import jakarta.persistence.*;

@Entity
public class GymMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MemberShipLevel membershipLevel;



}
