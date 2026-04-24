package model.s03;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private int quantity;
    private int price; // price snapshot column

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /*
    *  생성자
    * */
    public OrderItem() {}


    public OrderItem(Product product, int quantity) {

        // service쪽에 놓치만, 생성자안에서 생성 거부할 수 있음.
        if(product ==  null)
            throw new IllegalArgumentException("상품은 반드시 입력되어야합니다.");

        this.product = product;
        this.quantity = quantity;

        this.price = product.getPrice();

        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();



    }

    /*
        Getter and Setter
     */

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
