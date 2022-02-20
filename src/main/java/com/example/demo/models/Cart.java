package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {

    static final String SQ_CLIENT = "cart_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_CLIENT)
    @SequenceGenerator(name = SQ_CLIENT, sequenceName = SQ_CLIENT,
            allocationSize = 1,initialValue=1)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_id")
    private Integer orderId;

    @JoinColumn(name = "id", referencedColumnName = "id", updatable = false, insertable = false)
    @ManyToMany(fetch = FetchType.LAZY)
    List<Product> productList;




}
