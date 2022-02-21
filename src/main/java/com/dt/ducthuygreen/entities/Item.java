package com.dt.ducthuygreen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item extends BaseModel implements Serializable {

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product = new Product();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    Order order = new Order();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    Cart cart = new Cart();

}
