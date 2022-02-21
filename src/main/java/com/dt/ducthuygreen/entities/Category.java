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
@Table(name = "Category")
public class Category extends BaseModel implements Serializable {

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

}
