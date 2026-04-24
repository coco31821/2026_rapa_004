package model.s03;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus= OrderStatus.ORDERED;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderItem> items = new ArrayList<>();


    private LocalDateTime orderedAt = LocalDateTime.now(); // snapshot column : 주문당시와 가격이 다를 수 있기 떄문에
    private LocalDateTime updatedAt = LocalDateTime.now();


    /*
    Constructor
     */

    public Order() {}


    public Order(Member member) {

        this.member = member;
    }



    public void addOrderItem(OrderItem oi){
        this.items.add(oi);
        this.orderStatus= orderStatus;
    }

    /*
    Getter and Setter
     */

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    protected void setMember(Member member){
        this.member = member;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        this.updatedAt = LocalDateTime.now();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }



}
