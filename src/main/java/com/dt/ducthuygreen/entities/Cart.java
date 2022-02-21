package com.dt.ducthuygreen.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Cart")
public class Cart extends BaseModel implements Serializable {

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "quantity")
    private Long quantity;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

}
