package model.s03;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

    /*
    생성자
    */
    protected Category() {}

    public Category(String name) {
        this.name = name;
    }


    /*
    Getter and Setter
     */

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }


    public void setName(String name) {
        this.name = name;
    }
}
