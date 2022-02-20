package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product_type")
public class ProductType {

    static final String SQ_CLIENT = "product_type_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_CLIENT)
    @SequenceGenerator(name = SQ_CLIENT, sequenceName = SQ_CLIENT,
            allocationSize = 1,initialValue=1)
    private Integer id;

    @Column(name = "product_type")
    private String productType;

    @JoinColumn(name = "product_type_id", referencedColumnName = "id", updatable = false, insertable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> productList;
}
