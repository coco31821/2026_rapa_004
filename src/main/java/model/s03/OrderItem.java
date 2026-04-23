package model.s03;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Product product;
    private Order order;

    private int quantity;
    private int price; // price snapshot column

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;









}
