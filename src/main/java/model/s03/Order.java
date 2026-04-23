package model.s03;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany
    private List<OrderItem> items;


    private LocalDateTime orderedAt; // snapshot column : 주문당시와 가격이 다를 수 있기 떄문에
    private LocalDateTime updatedAt;





}
