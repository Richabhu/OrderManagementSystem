package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    static final String SQ_CLIENT = "product_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_CLIENT)
    @SequenceGenerator(name = SQ_CLIENT, sequenceName = SQ_CLIENT,
            allocationSize = 1,initialValue=1)
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_type_id")
    private Integer productTypeId;

    @Column(name = "vendor_id")
    private Integer vendorId;

    @Column(name = "available")
    private boolean available;
}
